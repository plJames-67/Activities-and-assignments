import java.util.Scanner;

public class SmartPayslipGenerator {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-30s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Employee Information ===");
        String name = s("Employee Name: ");
        String id = s("Employee ID: ");
        String dept = s("Department: ");
        double salary = d("Basic Monthly Salary: ");

        System.out.println("\n=== Payroll Information ===");
        String start = s("Payroll Start Date (YYYY-MM-DD): ");
        String end = s("Payroll End Date (YYYY-MM-DD): ");
        String payout = s("Payout Date (YYYY-MM-DD): ");

        System.out.println("\n=== Work Details ===");
        double regHours = d("Total Regular Hours Worked: ");
        double otHours = d("Overtime Hours Worked: ");
        double absent = d("Number of Absent Days: ");

        System.out.println("\n=== Allowances ===");
        double rice = d("Rice Allowance: ");
        double transpo = d("Transportation Allowance: ");
        double comm = d("Communication Allowance: ");

        System.out.println("\n=== Deductions ===");
        double sss = d("SSS Contribution: ");
        double phil = d("PhilHealth Contribution: ");
        double pagibig = d("PAG-IBIG Contribution: ");
        double tax = d("Withholding Tax: ");
        double other = d("Other Deductions: ");

        double hourly = salary / 160;
        double daily = salary / 20;
        double regularPay = regHours * hourly;
        double overtimePay = otHours * (hourly * 1.25);
        double absenceDed = absent * daily;
        double totalAllow = rice + transpo + comm;
        double gross = regularPay + overtimePay + totalAllow;
        double totalDed = sss + phil + pagibig + tax + other + absenceDed;
        double net = gross - totalDed;

        String bar = "=".repeat(48);
        String dash = "-".repeat(48);
        System.out.println();
        System.out.println(bar);
        System.out.println("          *** Smart Employee Payslip ***");
        System.out.println(bar);
        System.out.println("EMPLOYEE DETAILS");
        System.out.printf("  %-30s %s%n", "Name", name);
        System.out.printf("  %-30s %s%n", "Employee ID", id);
        System.out.printf("  %-30s %s%n", "Department", dept);
        System.out.println(dash);
        System.out.println("PAYROLL SUMMARY");
        System.out.printf("  %-14s %s to %s%n", "Pay Period", start, end);
        System.out.printf("  %-14s %s%n", "Payout Date", payout);
        System.out.println(dash);
        System.out.println("EARNINGS");
        line("Regular Pay", regularPay);
        line("Overtime Pay", overtimePay);
        line("Total Allowances", totalAllow);
        line("GROSS PAY", gross);
        System.out.println(dash);
        System.out.println("ALLOWANCES BREAKDOWN");
        line("Rice Allowance", rice);
        line("Transportation Allowance", transpo);
        line("Communication Allowance", comm);
        System.out.println(dash);
        System.out.println("DEDUCTIONS");
        line("SSS", sss);
        line("PhilHealth", phil);
        line("PAG-IBIG", pagibig);
        line("Withholding Tax", tax);
        line("Absence Deduction", absenceDed);
        line("Other Deductions", other);
        line("TOTAL DEDUCTIONS", totalDed);
        System.out.println(bar);
        line("NET PAY", net);
        System.out.println(bar);
    }
}
