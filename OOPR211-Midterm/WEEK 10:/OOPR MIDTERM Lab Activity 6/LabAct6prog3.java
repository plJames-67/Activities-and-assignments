package com.mycompany.labact6prog1;

import java.util.Scanner;

class Professor {
    protected String name;
    protected double salary;

    public Professor(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

class Dean extends Professor {
    protected String department;

    public Dean(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    // Name, department and salary of the Dean
    protected String info() {
        return "Name: " + name + "\n"
             + "Department: " + department + "\n"
             + "Salary: " + (int) salary;
    }

    @Override
    public String toString() {
        return "Status\nRank: Dean\n" + info();
    }
}

class Executive extends Dean {
    public Executive(String name, double salary, String department) {
        super(name, salary, department);
    }

    // "Executive" followed by the information stored in the Dean superclass
    @Override
    public String toString() {
        return "Status\nRank: Executive\n" + info();
    }
}

public class LabAct6prog3 {
    public static void main(String[] args) {
        Dean dean = new Dean("John Cena", 32000, "English");
        Executive executive = new Executive("Ronald McDonald", 42000, "Computer Science");

        System.out.println(dean);
        System.out.println("-".repeat(50));
        System.out.println(executive);
    }
}
