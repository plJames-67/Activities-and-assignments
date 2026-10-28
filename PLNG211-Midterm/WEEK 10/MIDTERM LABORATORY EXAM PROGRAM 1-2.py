class Book:
    def __init__(self, title, author, salary):
        self.title = title
        self.author = author
        self.salary = salary
    
    def __str__(self):
        return (f"Book: {self.title} | " f"Author: {self.author} | " f"Price: PHP {self.salary}")

class EBook(Book):
    def __init__(self, title, author, salary, fileSize):
        super().__init__(title, author, salary)
        self.fileSize = fileSize
    def __str__(self):
        return (f"EBook: {super().__str__()} " f"File Size: {self.fileSize}")

class Vehicle:
    def __init__(self, brand, daily_rate, days):
        self.brand = brand
        self.daily_rate = daily_rate
        self.days = days
    
    def calculate_rental(self):
        return self.daily_rate * self.days

    def __str__(self):
        return (f"{self.brand} | " f"Daily Rate: PHP {self.daily_rate} " 
                f"\nRental charge for {self.days} : PHP {self.calculate_rental()}")

class Car(Vehicle):
    def __init__(self, brand, daily_rate, days, seat):
        super().__init__(brand, daily_rate, days)
        self.seat = seat
    def __str__(self):
        return (f"Car: {super().__str__()} " f"| Seat: {self.seat}")
    
class Motorcycle(Vehicle):
    def __init__(self, brand, daily_rate, days, cc):
        super().__init__(brand, daily_rate, days)
        self.cc = cc
    def __str__(self):
        return (f"Motorcycle: {super().__str__()} " f"| Engine: {self.cc} cc")

def __main__():
    books = [Book("Python Basics", "Maria Santos", 450.00),
    EBook("Learning OOP", "Ana Cruz", 300.00, "5 MB"),
    EBook("Learning Python", "Robin Oak", 600.00, "40 MB")]
    print("Program 1")
    for book in books:  
        print(book)
        print()

    vroom = [Car("Toyota", 1500.00, 3, 5),
    Motorcycle("Honda", 500.00, 3, 150)]
    print("Program 2")
    for vroom in vroom:  
        print(vroom)
        print()

if __name__ == "__main__":
    __main__()
