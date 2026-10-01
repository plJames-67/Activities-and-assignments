import sys

tickets = []
next_id = 1

VALID_PURPOSES = {"Enrollment", "Records", "Payment"}
VALID_TYPES = {"regular", "priority"}
NUM_COUNTERS = 2

counters = [None for _ in range(NUM_COUNTERS)]
history = []
priority_streak = 0


def reset_state():
    global next_id, priority_streak
    tickets.clear()
    history.clear()
    for i in range(NUM_COUNTERS):
        counters[i] = None
    next_id = 1
    priority_streak = 0


def issue_ticket(purpose, service_type="regular"):
    global next_id
    if not isinstance(purpose, str) or not isinstance(service_type, str):
        return None
    fmt_purpose = purpose.strip().capitalize()
    fmt_type = service_type.strip().lower()

    if fmt_purpose not in VALID_PURPOSES or fmt_type not in VALID_TYPES:
        return None

    ticket = {
        "id": next_id,
        "type": fmt_type,
        "purpose": fmt_purpose,
        "status": "waiting"
    }
    tickets.append(ticket)
    next_id += 1
    return ticket["id"]


def issue_many(*requests):
    validated = []
    for req in requests:
        if not isinstance(req, (tuple, list)) or len(req) < 1 or len(req) > 2:
            return None
        if not all(isinstance(x, str) for x in req):
            return None
        purpose = req[0].strip().capitalize()
        service_type = req[1].strip().lower() if len(req) > 1 else "regular"

        if purpose not in VALID_PURPOSES or service_type not in VALID_TYPES:
            return None
        validated.append((purpose, service_type))

    issued_ids = []
    for purp, s_type in validated:
        t_id = issue_ticket(purp, s_type)
        issued_ids.append(t_id)
    return issued_ids


def next_ticket(waiting_list, priority_streak):
    waiting_priority = [t for t in waiting_list if t["type"] == "priority"]
    waiting_regular = [t for t in waiting_list if t["type"] == "regular"]

    if not waiting_priority and not waiting_regular:
        return None, priority_streak

    if waiting_priority and not waiting_regular:
        return waiting_priority[0], priority_streak + 1
    if waiting_regular and not waiting_priority:
        return waiting_regular[0], 0

    if priority_streak >= 2:
        return waiting_regular[0], 0
    else:
        return waiting_priority[0], priority_streak + 1


class WaitingTicketIterator:

    def __init__(self, ticket_list):
        self.ticket_list = ticket_list
        self.pos = 0

    def __iter__(self):
        return self

    def __next__(self):
        while self.pos < len(self.ticket_list):
            ticket = self.ticket_list[self.pos]
            self.pos += 1
            if ticket["status"] == "waiting":
                return ticket
        raise StopIteration


def get_waiting():
    return list(WaitingTicketIterator(tickets))


def find_ticket(ticket_id):
    for t in tickets:
        if t["id"] == ticket_id:
            return t
    return None


def free_counter_index():
    for i in range(NUM_COUNTERS):
        if counters[i] is None:
            return i
    return None


def call_next():
    global priority_streak
    idx = free_counter_index()
    if idx is None:
        return None
    ticket, new_streak = next_ticket(get_waiting(), priority_streak)
    if ticket is None:
        return None
    ticket["status"] = "serving"
    counters[idx] = ticket["id"]
    priority_streak = new_streak
    return idx + 1, ticket


def complete_service(counter_number):
    if counter_number < 1 or counter_number > NUM_COUNTERS:
        return None
    ticket_id = counters[counter_number - 1]
    if ticket_id is None:
        return None
    ticket = find_ticket(ticket_id)
    ticket["status"] = "served"
    history.append(ticket)
    counters[counter_number - 1] = None
    return ticket


def cancel_ticket(ticket_id):
    ticket = find_ticket(ticket_id)
    if ticket is None:
        return "not_found"
    if ticket["status"] != "waiting":
        return "not_waiting"
    ticket["status"] = "cancelled"
    return "ok"


def get_counts():
    return {
        "waiting": sum(t["status"] == "waiting" for t in tickets),
        "served": sum(t["status"] == "served" for t in tickets),
        "cancelled": sum(t["status"] == "cancelled" for t in tickets),
        "free_counters": counters.count(None),
    }


def report(**kwargs):
    known = ["waiting", "served", "cancelled", "free_counters"]
    print("--- Summary report ---")
    for key in known:
        if key in kwargs:
            print(f"{key.replace('_', ' ').capitalize():<15}: {kwargs[key]}")
    for key in kwargs:
        if key not in known:
            print(f"(note) {key}: {kwargs[key]}")


def fmt(t):
    return f"#{t['id']} {t['type']:<8} {t['purpose']:<10} [{t['status']}]"


def show_waiting():
    waiting = get_waiting()
    if not waiting:
        print("No tickets are waiting.")
    for pos in range(len(waiting)):
        print(f"  {pos + 1}. {fmt(waiting[pos])}")


def show_counters_and_history():
    for i in range(NUM_COUNTERS):
        if counters[i] is None:
            print(f"Counter {i + 1}: free")
        else:
            print(f"Counter {i + 1}: busy with ticket #{counters[i]}")
    print("Completed history:")
    if not history:
        print("  (none yet)")
    for n in range(len(history)):
        print(f"  {n + 1}. {fmt(history[n])}")


def read_number(prompt):
    text = input(prompt).strip()
    if not text.lstrip("-").isdigit():
        print(f"'{text}' is not a number. Please enter digits only.")
        return None
    return int(text)


def menu_issue():
    purpose = input("Purpose (Enrollment/Records/Payment): ")
    stype = input("Service type (regular/priority) [regular]: ").strip()
    if purpose.strip().capitalize() not in VALID_PURPOSES:
        print("Invalid purpose. Choose Enrollment, Records or Payment.")
        return
    if stype and stype.lower() not in VALID_TYPES:
        print("Invalid service type. Choose regular or priority.")
        return
    number = issue_ticket(purpose, stype or "regular")
    print(f"Ticket #{number} issued.")


def menu_call():
    if free_counter_index() is None:
        print("No free counter. Complete a service first.")
    elif not get_waiting():
        print("No tickets are waiting.")
    else:
        counter, t = call_next()
        print(f"Now serving {fmt(t)} at counter {counter}.")


def menu_complete():
    n = read_number(f"Counter number (1-{NUM_COUNTERS}): ")
    if n is None:
        return
    t = complete_service(n)
    if t is None:
        print("That counter does not exist or is already free.")
    else:
        print(f"Ticket #{t['id']} completed; counter {n} is free.")


def menu_cancel():
    n = read_number("Ticket number to cancel: ")
    if n is None:
        return
    result = cancel_ticket(n)
    if result == "ok":
        print(f"Ticket #{n} cancelled.")
    elif result == "not_found":
        print(f"Ticket #{n} does not exist.")
    else:
        print(f"Ticket #{n} is not waiting, so it cannot be cancelled.")


def main():
    actions = {"1": menu_issue, "2": menu_call, "3": menu_complete,
               "4": menu_cancel, "5": show_waiting,
               "6": show_counters_and_history,
               "7": lambda: report(**get_counts())}
    while True:
        print("\n===== Campus Service Queue Manager =====")
        print("1 Issue a ticket")
        print("2 Call the next ticket")
        print("3 Complete a service")
        print("4 Cancel a waiting ticket")
        print("5 Show waiting tickets")
        print("6 Show counter status and completed history")
        print("7 Show a summary report")
        print("8 Exit")
        try:
            choice = input("Choice: ").strip()
        except (EOFError, KeyboardInterrupt):
            print("\nGoodbye!")
            break
        if choice == "8":
            print("Goodbye!")
            break
        if choice in actions:
            actions[choice]()
        else:
            print("Invalid choice. Please enter a number from 1 to 8.")


def run_tests():
    reset_state()
    assert issue_ticket("records") == 1
    assert tickets[0]["type"] == "regular"
    assert issue_ticket("Parking") is None
    assert issue_ticket("Records", "vip") is None
    assert issue_ticket("Payment", "priority") == 2

    reset_state()
    assert issue_many(("Records",), ("Payment", "priority")) == [1, 2]
    assert issue_many(("Records",), ("Bogus", "regular")) is None
    assert len(tickets) == 2
    assert issue_ticket("Records") == 3

    assert next_ticket([], 1) == (None, 1)
    w = [{"type": "regular"}, {"type": "priority"}]
    assert next_ticket(w, 0) == (w[1], 1)
    assert next_ticket(w, 2) == (w[0], 0)

    reset_state()
    issue_many(*[("Records", "priority")] * 4, ("Payment",))
    order = []
    for _ in range(5):
        counter, t = call_next()
        order.append(t["id"])
        complete_service(counter)
    assert order == [1, 2, 5, 3, 4], order

    reset_state()
    issue_many(("Records",), ("Records",), ("Records",))
    assert cancel_ticket(1) == "ok"
    assert cancel_ticket(1) == "not_waiting"
    assert cancel_ticket(99) == "not_found"
    assert call_next()[1]["id"] == 2
    assert call_next()[1]["id"] == 3
    assert call_next() is None
    assert complete_service(1)["id"] == 2
    assert complete_service(1) is None
    assert counters[0] is None and len(history) == 1

    reset_state()
    issue_many(("Records",), ("Records",), ("Records",))
    it = WaitingTicketIterator(tickets)
    assert next(it)["id"] == 1
    cancel_ticket(2)
    issue_ticket("Payment")
    assert [t["id"] for t in it] == [3, 4]
    try:
        next(it)
        assert False, "expected StopIteration"
    except StopIteration:
        pass

    before = get_counts()
    report(waiting=1, mood="busy")
    assert get_counts() == before

    reset_state()
    print("All tests passed.")


if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == "test":
        run_tests()
    else:
        main()
