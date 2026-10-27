class Professor:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary


class Dean(Professor):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department

    def info(self):
        # Name, department and salary of the Dean
        return (f"Name: {self.name}\n"
                f"Department: {self.department}\n"
                f"Salary: {self.salary}")

    def to_string(self):
        return "Status\nRank: Dean\n" + self.info()


class Executive(Dean):
    def to_string(self):
        # "Executive" followed by the information stored in the Dean superclass
        return "Status\nRank: Executive\n" + self.info()


if __name__ == "__main__":
    dean = Dean("John Cena", 32000, "English")
    executive = Executive("Ronald McDonald", 42000, "Computer Science")

    print(dean.to_string())
    print("-" * 50)
    print(executive.to_string())
