class BankAccount:
    def __init__(self, balance):
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if amount > self.balance:
            print(f"Insufficient funds: amount PHP {amount:.2f} exceeds balance PHP {self.balance:.2f}")
        else:
            self.balance -= amount


def ask_number(prompt):
    """Keep asking until the user types a number."""
    while True:
        try:
            return float(input(prompt))
        except ValueError:
            print("Invalid number. Please try again.")


print("Welcome!!")

opening = ask_number("Enter your balance: ")
while opening < 0:
    print("Opening balance must be zero or more.")
    opening = ask_number("Enter your balance: ")

account = BankAccount(opening)

while True:
    print("--------------------------")
    print("1. Withdraw\n2. Deposit\n3. Exit")
    choice = input("Select an option: ")

    if choice == "1":
        amount = ask_number("Amount to withdraw: ")
        if amount <= 0:
            print("Amount must be greater than zero. Balance unchanged.")
        else:
            account.withdraw(amount)
            print(f"Your new balance is: PHP {account.balance:.2f}")
    elif choice == "2":
        amount = ask_number("Amount to deposit: ")
        if amount <= 0:
            print("Amount must be greater than zero. Balance unchanged.")
        else:
            account.deposit(amount)
            print(f"Your new balance is: PHP {account.balance:.2f}")
    elif choice == "3":
        print("Thank you for using the system")
        break
    else:
        print("Invalid choice. Please enter 1, 2 or 3.")
