def read_int(prompt):
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print("Invalid input. Please enter an integer.")


def read_float(prompt):
    while True:
        try:
            return float(input(prompt))
        except ValueError:
            print("Invalid input. Please enter a number.")


def lab_prog1():
    size = 10
    numbers = []

    print("Please enter 10 real numbers (both positive and negative):")
    for i in range(size):
        numbers.append(read_float(f"Enter number {i + 1}: "))

    positives = [n for n in numbers if n > 0]
    count_neg = sum(1 for n in numbers if n < 0)
    sum_pos = sum(positives)

    print("Sum of positive numbers:", sum_pos)
    if positives:
        print("Average of positive numbers:", sum_pos / len(positives))
    else:
        print("Average of positive numbers: N/A (no positive numbers)")
    print("Count of negative numbers:", count_neg)
    print("Minimum value in the array:", min(numbers))


def remove_dupe(arr):
    unique = list(dict.fromkeys(arr))
    print("Array without duplicates:", unique)


def get_second_largest(arr):
    unique = sorted(set(arr))
    return unique[-2] if len(unique) >= 2 else None


def get_second_smallest(arr):
    unique = sorted(set(arr))
    return unique[1] if len(unique) >= 2 else None


def lab_prog2():
    size = 8
    numbers = []

    print("Please enter 8 integers:")
    for i in range(size):
        numbers.append(read_int(f"Enter number {i + 1}: "))

    remove_dupe(numbers)

    second_largest = get_second_largest(numbers)
    second_smallest = get_second_smallest(numbers)

    if second_largest is None:
        print("Second largest: N/A (need at least 2 distinct values)")
        print("Second smallest: N/A (need at least 2 distinct values)")
    else:
        print("Second largest:", second_largest)
        print("Second smallest:", second_smallest)


def lab_prog3():
    n = 5
    arr = []

    print("Enter Data in Array:")
    for i in range(n):
        arr.append(read_int(f"  Element {i}: "))

    print("Stored Data in Array:", *arr)

    pos = read_int(f"Enter position of Element to Delete (0-{n - 1}): ")

    if pos < 0 or pos >= n:
        print("Invalid position. Nothing deleted.")
        return

    del arr[pos]

    print("New data in Array:", *arr)


def lab_prog4():
    size = read_int("Enter Size of Array: ")

    if size <= 0:
        print("Size must be greater than 0.")
        return

    numbers = []
    print(f"Enter any {size} elements in Array:")
    for i in range(size):
        numbers.append(read_int(f"  Element {i + 1}: "))

    evens = [n for n in numbers if n % 2 == 0]
    odds = [n for n in numbers if n % 2 != 0]

    print("Even Elements:", *evens)
    print("Odd Elements:", *odds)


def lab_prog5():
    rows = 4
    for i in range(1, rows + 1):
        print("A".join("*" * i))

def lab_prog6():
    basic = 12000
    da = 0.12 * basic     
    hra = 150               
    ta = 120                 
    others = 450
    pf = 0.14 * basic        
    it = 0.15 * basic        
 
    gross = basic + da + hra + ta + others
    deductions = pf + it
    net = gross - deductions
 
    print("----- Salary Slip -----")
    print(f"Basic Salary : ${basic:,.2f}")
    print(f"DA (12%)     : ${da:,.2f}")
    print(f"HRA          : ${hra:,.2f}")
    print(f"TA           : ${ta:,.2f}")
    print(f"Others       : ${others:,.2f}")
    print(f"Gross Salary : ${gross:,.2f}")
    print(f"PF (14%)     : ${pf:,.2f}")
    print(f"IT (15%)     : ${it:,.2f}")
    print(f"Deductions   : ${deductions:,.2f}")
    print(f"Net Salary   : ${net:,.2f}")


PROGRAMS = {
    1: lab_prog1,
    2: lab_prog2,
    3: lab_prog3,
    4: lab_prog4,
    5: lab_prog5,
    6: lab_prog6,

}


def main():
    while True:
        choice = read_int("Choose the program you want to run (1-6): ")

        program = PROGRAMS.get(choice)
        if program:
            program()
        else:
            print("Invalid choice! Please select between 1 and 6.")

        answer = input("Do you want to continue? (Y/N): ").strip().lower()
        print()
        if not answer.startswith("y"):
            break

    print("Program terminated. Goodbye!")


if __name__ == "__main__":
    main()