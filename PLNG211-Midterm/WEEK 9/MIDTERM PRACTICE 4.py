while True:
    try:
        total_pages = int(input("Enter total pages of the book: "))
        if total_pages < 1:
            print("Enter Whole Number")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")
        
while True:
    try:
        pages_read = int(input("Enter pages already read: "))
        if pages_read < 1:
            print("Enter Whole Number")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")

while True:
    try:
        days_reading = int(input("Enter how many days you have been reading: "))
        if days_reading < 1:
            print("Enter Whole Number")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")
    
print("\n--- Enter Issue Date ---")
while True:
    try:
        issue_day = int(input("Enter Day (1-31): "))
        if 0 < issue_day > 32:
            print("Enter valid day")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")
while True:
    try:
        issue_month = int(input("Enter Month (1-12): "))
        if 0 < issue_month > 13:
            print("Enter valid month")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")
while True:
    try:        
        issue_year = int(input("Enter Year (e.g., 2026): "))
        break
    except ValueError:
        print("Please Enter Valid Number")
    
print("\n--- Enter Due Date ---")
while True:
    try:
        due_day = int(input("Enter Day (1-31): "))
        if 0 < due_day > 32:
                    print("Enter valid day")
        else:
            break
    except ValueError:
                print("Please Enter Valid Number")
while True:
    try:
        due_month = int(input("Enter Month (1-12): "))
        if 0 < issue_month > 13:
            print("Enter valid month")
        else:
            break
    except ValueError:
        print("Please Enter Valid Number")

due_year = int(input("Enter Year (e.g., 2026): "))
    
total_days = 0
    
if due_month != issue_month:
    if issue_month in [4, 6, 9 ,11]:
        total_days = (due_day - issue_day) + 30
    elif issue_month == 2:
        total_days = (due_day - issue_day) + 28
    else:
        total_days = (due_day - issue_day) + 31
else:
    total_days = due_day - issue_day
        
read_progress = (pages_read * 100) // total_pages
days_left = total_days - days_reading
pages_rate = (total_pages - pages_read) // days_left

print(f"You have read {read_progress}% of the book")
print(f"You have {days_left} days remaining to finish the book")
print(f"You should read {pages_rate} pages per day")
