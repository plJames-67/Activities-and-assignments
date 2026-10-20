package com.mycompany.oop_lab_act;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class OOP_LAB_ACT {

    static Scanner input = new Scanner(System.in);

    static class Date {
        private String value;

        public Date(String date) {
            this.value = date;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    static class Student {

        private static int noOfStudents = 0;

        private String studentNo;
        private String studentName;
        private Date dateOfBirth;
        private int tariffPoints;

        public String getStudentNo()   { return studentNo; }
        public String getStudentName() { return studentName; }
        public Date getDateOfBirth()   { return dateOfBirth; }
        public int getTariffPoints()   { return tariffPoints; }

        public static int getNoOfStudents() { return noOfStudents; }

          public static String validateStudentNo(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Student number must not be empty.");
        }
        return s.trim();
    }

         public static String validateStudentName(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name must not be empty.");
        }
        return s.trim();
    }

        public static String validateDateOfBirth(Date d) {
            if (d == null) {
                throw new IllegalArgumentException("Date of birth must not be null.");
            }
            return null;
        }

        public static int validateTariffPoints(int p) {
        if (p < 20 || p > 280) {
            throw new IllegalArgumentException("Tariff points must be between 20 and 280.");
        }
        return p;
    }
        
        public void setStudentNo(String studentNo) {
        this.studentNo = validateStudentNo(studentNo);
    }

    public void setStudentName(String studentName) {
        this.studentName = validateStudentName(studentName);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth must not be null.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setTariffPoints(int tariffPoints) {
        this.tariffPoints = validateTariffPoints(tariffPoints);
    }
        
        public Student() {
            this.studentNo    = "not known";
            this.studentName  = "not known";
            this.dateOfBirth  = new Date("01/01/1995");
            this.tariffPoints = 20;
            noOfStudents++;
        }

        public Student(String studentNo, String studentName,
                       Date dateOfBirth, int tariffPoints) {
            setStudentNo(studentNo);
            setStudentName(studentName);
            setDateOfBirth(dateOfBirth);
            setTariffPoints(tariffPoints);
            noOfStudents++;
        }
          @Override
        public String toString() {
        return "Student No: " + studentNo
             + " | Name: " + studentName
             + " | DOB: " + dateOfBirth
             + " | Tariff Points: " + tariffPoints;
    }
    }

    static void Lab_Prog1() {
        int size = 10;
        double[] numb = new double[size];

        System.out.println("Please enter 10 real numbers (both positive and negative):");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numb[i] = input.nextDouble();
        }

        double sum_pos = 0;
        int count_pos = 0;
        int count_neg = 0;
        double min_val = numb[0];

        for (int i = 0; i < size; i++) {
            if (numb[i] > 0) {
                sum_pos += numb[i];
                count_pos++;
            } else if (numb[i] < 0) {
                count_neg++;
            }
            if (numb[i] < min_val) {
                min_val = numb[i];
            }
        }

        System.out.println("Sum of positive numbers: " + sum_pos);
        if (count_pos > 0) {
            System.out.println("Average of positive numbers: " + (sum_pos / count_pos));
        } else {
            System.out.println("Average of positive numbers: N/A (no positive numbers)");
        }
        System.out.println("Count of negative numbers: " + count_neg);
        System.out.println("Minimum value in the array: " + min_val);
    }

    static void RemoveDupe(int[] arr) {
        int[] uniqueNumb = Arrays.stream(arr).distinct().toArray();
        System.out.println("Array without duplicates: " + Arrays.toString(uniqueNumb));
    }

    static Integer getSecondLargest(int[] numb) {
        int[] unique = Arrays.stream(numb).distinct().sorted().toArray();
        if (unique.length < 2) {
            return null;
        }
        return unique[unique.length - 2];
    }

    static Integer getSecondSmallest(int[] numb) {
        int[] unique = Arrays.stream(numb).distinct().sorted().toArray();
        if (unique.length < 2) {
            return null;
        }
        return unique[1];
    }

    static void Lab_Prog2() {
        int size = 8;
        int[] numb = new int[size];

        System.out.println("Please enter 8 integers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numb[i] = input.nextInt();
        }

        RemoveDupe(numb);

        Integer secLargest = getSecondLargest(numb);
        Integer secSmallest = getSecondSmallest(numb);

        System.out.println("Second largest: "
                + (secLargest != null ? secLargest : "N/A (fewer than 2 distinct values)"));
        System.out.println("Second smallest: "
                + (secSmallest != null ? secSmallest : "N/A (fewer than 2 distinct values)"));
    }

    static void Lab_Prog3() {
        int n = 5;
        int[] arr = new int[n];

        System.out.print("Enter Data in Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Stored Data in Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Enter position of Element to Delete (0-" + (n - 1) + "): ");
        int pos = input.nextInt();

        if (pos < 0 || pos >= n) {
            System.out.println("Invalid position. Nothing deleted.");
            return;
        }

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;

        System.out.print("New data in Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void Lab_Prog4() {
        System.out.print("Enter Size of Array: ");
        int size = input.nextInt();

        if (size <= 0) {
            System.out.println("Size must be greater than 0.");
            return;
        }

        int[] numb = new int[size];

        System.out.print("Enter any " + size + " elements in Array: ");
        for (int i = 0; i < size; i++) {
            numb[i] = input.nextInt();
        }

        System.out.print("Even Elements: ");
        for (int i = 0; i < size; i++) {
            if (numb[i] % 2 == 0) {
                System.out.print(numb[i] + " ");
            }
        }
        System.out.println();

        System.out.print("Odd Elements: ");
        for (int i = 0; i < size; i++) {
            if (numb[i] % 2 != 0) {
                System.out.print(numb[i] + " ");
            }
        }
        System.out.println();
    }

    static void Lab_Prog5() {
        int rows = 4;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
                if (j < i) {
                    System.out.print("A");
                }
            }
            System.out.println();
        }
    }

    static void Lab_Prog6() {
        Student defaultStudent = new Student();
        System.out.println("Default student: " + defaultStudent);
        System.out.println();

        System.out.println("Enter details for a new student:");

    String studentNo = null;
    while (studentNo == null) {
        System.out.print("Student number: ");
        try {
            studentNo = Student.validateStudentNo(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    String studentName = null;
    while (studentName == null) {
        System.out.print("Student name: ");
        try {
            studentName = Student.validateStudentName(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    Date dob = null;
    while (dob == null) {
        System.out.print("Date of birth (dd/MM/yyyy): ");
        try {
            dob = new Date(input.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    int tariff = -1;
    while (tariff == -1) {
        System.out.print("Tariff points (20-280): ");
        try {
            tariff = Student.validateTariffPoints(Integer.parseInt(input.nextLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a whole number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    Student s = new Student(studentNo, studentName, dob, tariff);

    System.out.println();
    System.out.println("Student created: " + s);
    System.out.println("Students created so far: " + Student.getNoOfStudents());
    }
   

    static void Lab_Prog7(String fileName) {
        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            if (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Raw Line: " + line);
                System.out.println("---------------------------------");

                try (Scanner lineScanner = new Scanner(line)) {
                    lineScanner.useDelimiter("\t");

                    System.out.println("Split Records:");
                    int fieldNum = 1;
                    while (lineScanner.hasNext()) {
                        System.out.println("Field " + fieldNum + ": " + lineScanner.next());
                        fieldNum++;
                    }
                }
            } else {
                System.out.println("The file '" + fileName + "' is empty.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + fileName + "' was not found.");
        }
    }

    public static void main(String[] args) {
        char continueChoice;

        do {
            System.out.print("Choose the program you want to run (1-7): ");

                int decision = input.nextInt();
                switch (decision) {
                    case 1:
                        Lab_Prog1();
                        break;
                    case 2:
                        Lab_Prog2();
                        break;
                    case 3:
                        Lab_Prog3();
                        break;
                    case 4:
                        Lab_Prog4();
                        break;
                    case 5:
                        Lab_Prog5();
                        break;
                    case 6:
                        Lab_Prog6();
                        break;
                    case 7:
                        System.out.print("Enter file name: ");
                        String fileName = input.next();
                        Lab_Prog7(fileName);
                        break;
                    default:
                        System.out.println("Invalid choice! Please select between 1 and 7.");
                }

            System.out.print("Do you want to continue? (Y/N): ");
            continueChoice = input.next().charAt(0);
            System.out.println();
        } while (continueChoice == 'Y' || continueChoice == 'y');

        System.out.println("Program terminated. Goodbye!");
    }
}
