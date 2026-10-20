import java.util.Scanner;

public class StudentTuitionBilling {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-28s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Student Information ===");
        String name = s("Student Name: ");
        String id = s("Student ID: ");
        String course = s("Course/Program: ");
        String year = s("Year Level: ");

        System.out.println("\n=== Enrollment Details ===");
        int units = i("Number of Units Enrolled: ");
        double perUnit = d("Tuition Fee per Unit: ");
        double misc = d("Miscellaneous Fee: ");

        System.out.println("\n=== Additional Fees ===");
        double lab = d("Laboratory Fee: ");
        double lib = d("Library Fee: ");
        double other = d("Other Fees: ");

        System.out.println("\n=== Payment Details ===");
        double down = d("Down Payment: ");
        double scholarship = d("Scholarship Discount: ");

        double tuition = units * perUnit;
        double addFees = lab + lib + other;
        double gross = tuition + misc + addFees;
        double net = gross - scholarship;
        double balance = net - down;

        String bar = "=".repeat(46);
        String dash = "-".repeat(46);
        System.out.println();
        System.out.println(bar);
        System.out.println("      *** STUDENT TUITION BILLING SYSTEM ***");
        System.out.println(bar);
        System.out.println("STUDENT DETAILS");
        System.out.printf("  %-18s %s%n", "Name", name);
        System.out.printf("  %-18s %s%n", "Student ID", id);
        System.out.printf("  %-18s %s%n", "Course", course);
        System.out.printf("  %-18s %s%n", "Year Level", year);
        System.out.println(dash);
        System.out.println("ENROLLMENT SUMMARY");
        System.out.printf("  %-28s %15d%n", "Units Enrolled", units);
        line("Tuition per Unit", perUnit);
        line("Tuition Fee Total", tuition);
        System.out.println(dash);
        System.out.println("FEES BREAKDOWN");
        line("Miscellaneous Fee", misc);
        line("Laboratory Fee", lab);
        line("Library Fee", lib);
        line("Other Fees", other);
        line("GROSS TOTAL FEE", gross);
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        line("Scholarship Discount", scholarship);
        line("Net Total Fee", net);
        line("Down Payment", down);
        line("REMAINING BALANCE", balance);
        System.out.println(bar);
    }
}
