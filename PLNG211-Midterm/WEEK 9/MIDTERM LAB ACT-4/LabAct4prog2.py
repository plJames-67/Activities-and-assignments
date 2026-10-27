class Patient:
    def __init__(self, name, admission, disease, discharge, age):
        self.name = name
        self.admission = admission    # (year, month, day)
        self.disease = disease
        self.discharge = discharge
        self.age = age

    def show(self):
        print("-------------------------")
        print("Name      :", self.name)
        print("Admission : %d-%d-%d" % self.admission)
        print("Disease   :", self.disease)
        print("Discharge : %d-%d-%d" % self.discharge)
        print("Age       :", self.age)


def ask_number(prompt):
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print("Please enter a whole number.")


def ask_date():
    """Ask for a date until it is a real calendar date. Returns (year, month, day)."""
    while True:
        year = ask_number("   Year : ")
        month = ask_number("   Month: ")
        day = ask_number("   Day  : ")

        days_in_month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
            days_in_month[1] = 29

        if year >= 1 and 1 <= month <= 12 and 1 <= day <= days_in_month[month - 1]:
            return (year, month, day)
        print("   Invalid date. Try again.")


def add_patient(patients):
    name = input("1. Name of the patient: ")
    print("2. Date of admission:")
    admission = ask_date()
    disease = input("3. Disease: ")
    print("4. Date of discharge:")
    discharge = ask_date()
    if discharge < admission:          # tuples compare year, then month, then day
        print("Error: discharge cannot be before admission.")
        return
    age = ask_number("5. Age: ")
    if age < 0 or age > 130:
        print("Error: age must be between 0 and 130.")
        return
    patients.append(Patient(name, admission, disease, discharge, age))
    print("Patient added.")


patients = []

while True:
    print("\n1. Insert New Patient")
    print("2. Display all Patient")
    print("3. Display pediatric patient")
    print("4. Exit")
    choice = input("Choice: ")

    if choice == "1":
        add_patient(patients)
    elif choice == "2":
        if not patients:
            print("No patients in the database.")
        for p in patients:
            p.show()
    elif choice == "3":
        children = [p for p in patients if p.age < 12]
        if not children:
            print("No pediatric patients found.")
        for p in children:
            p.show()
    elif choice == "4":
        break
    else:
        print("Invalid option. Please choose 1-4.")
