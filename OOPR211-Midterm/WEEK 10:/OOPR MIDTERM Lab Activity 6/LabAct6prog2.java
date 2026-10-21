package com.mycompany.labact6prog2;

import java.util.Scanner;

// Thrown when a date is not a real calendar date or is out of order
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// Thrown when an age is outside a sensible range
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Structure-like class to store and validate a date manually
class Date {
    int year;
    int month;
    int day;

    private static int readInt(Scanner sc, String label) throws InvalidDateException {
        System.out.print("   " + label);
        if (!sc.hasNextLine()) {
            throw new InvalidDateException("No input received.");
        }
        String text = sc.nextLine().trim();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new InvalidDateException("'" + text + "' is not a valid number.");
        }
    }

    void read(Scanner sc) throws InvalidDateException {
        year = readInt(sc, "Year : ");
        month = readInt(sc, "Month: ");
        day = readInt(sc, "Day  : ");
        validate(); 
    }

    // Manual calendar validation
    void validate() throws InvalidDateException {
        if (year < 1) {
            throw new InvalidDateException("Invalid year: " + year);
        }
        if (month < 1 || month > 12) {
            throw new InvalidDateException("Invalid month: " + month);
        }
        
        int maxDays = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDays = 30;
        } else if (month == 2) {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            maxDays = isLeap ? 29 : 28;
        }

        if (day < 1 || day > maxDays) {
            throw new InvalidDateException("Invalid day " + day + " for month " + month + " in year " + year);
        }
    }

    // Compares chronological order using YYYYMMDD math
    boolean isBefore(Date other) {
        long thisValue = (this.year * 10000L) + (this.month * 100) + this.day;
        long otherValue = (other.year * 10000L) + (other.month * 100) + other.day;
        return thisValue < otherValue;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

// Base class: general patient information
class Patient {
    protected String name;
    protected Date admission = new Date();
    protected String disease;
    protected Date discharge = new Date();

    private static String readText(Scanner sc, String prompt) {
        System.out.print(prompt);
        if (!sc.hasNextLine()) {
            throw new IllegalStateException("No input received.");
        }
        String text = sc.nextLine().trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException("This field cannot be empty.");
        }
        return text;
    }

    void getData(Scanner sc) throws InvalidDateException {
        name = readText(sc, "1. Name of the patient: ");
        System.out.println("2. Date of admission:");
        admission.read(sc);
        disease = readText(sc, "3. Disease: ");
        System.out.println("4. Date of discharge:");
        discharge.read(sc);
        
        if (discharge.isBefore(admission)) {
            throw new InvalidDateException("Date of discharge cannot be before date of admission.");
        }
    }

    void display() {
        System.out.println("Name      : " + name);
        System.out.println("Admission : " + admission);
        System.out.println("Disease   : " + disease);
        System.out.println("Discharge : " + discharge);
    }
}

// Derived class: adds the age of the patient
class PatientAge extends Patient {
    private int age;

    @Override
    void getData(Scanner sc) throws InvalidDateException {
        super.getData(sc);
        System.out.print("5. Age: ");
        if (!sc.hasNextLine()) {
            throw new IllegalStateException("No input received.");
        }
        String text = sc.nextLine().trim();
        try {
            age = Integer.parseInt(text);
            if (age < 0 || age > 130) {
                throw new InvalidAgeException("Age must be between 0 and 130.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'" + text + "' is not a valid age.");
        } catch (InvalidAgeException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    void display() {
        super.display();
        System.out.println("Age       : " + age);
    }

    boolean isPediatric() {
        return age < 12;
    }
}

public class LabAct6prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // REPLACEMENT: Standard native array with a fixed limit (e.g., up to 100 patients)
        PatientAge[] patients = new PatientAge[100];
        int patientCount = 0;
        int choice = 0;

        do {
            try {
                System.out.println("\n1. Insert New Patient");
                System.out.println("2. Display all Patient");
                System.out.println("3. Display pediatric patient");
                System.out.println("4. Exit");
                System.out.print("Choice: ");
                
                if (!sc.hasNextLine()) {
                    System.out.println("No input received. Exiting.");
                    break;
                }
                
                choice = Integer.parseInt(sc.nextLine().trim());

                if (choice == 1) {
                    if (patientCount >= patients.length) {
                        System.out.println("Database full! Cannot add more patients.");
                    } else {
                        PatientAge p = new PatientAge();
                        p.getData(sc);
                        patients[patientCount] = p; // Store inside standard index
                        patientCount++;
                        System.out.println("Patient added.");
                    }
                } else if (choice == 2) {
                    if (patientCount == 0) {
                        System.out.println("No patients in the database.");
                    } else {
                        for (int i = 0; i < patientCount; i++) {
                            System.out.println("-------------------------");
                            patients[i].display();
                        }
                    }
                } else if (choice == 3) {
                    boolean found = false;
                    for (int i = 0; i < patientCount; i++) {
                        if (patients[i].isPediatric()) {
                            System.out.println("-------------------------");
                            patients[i].display();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("No pediatric patients found.");
                } else if (choice != 4) {
                    System.out.println("Invalid option. Please choose 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                choice = 0;
            } catch (InvalidDateException | IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage() + " Processing stopped.");
                if (e instanceof IllegalStateException) {
                    choice = 4; // Exit if input stream completely ended
                }
            }
        } while (choice != 4);

        sc.close();
    }
}
