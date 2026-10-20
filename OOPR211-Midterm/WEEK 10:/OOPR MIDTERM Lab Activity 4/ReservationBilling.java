import java.util.Scanner;

public class ReservationBilling {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-28s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");

        System.out.println("\n=== Reservation Details ===");
        String type = s("Reservation Type (Room/Cottage/Table): ");
        double duration = d("Number of Days/Hours Reserved: ");
        double rate = d("Rate per Day/Hour: ");

        System.out.println("\n=== Additional Services ===");
        double food = d("Food Charges: ");
        double service = d("Service Charges: ");
        double other = d("Other Charges: ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double down = d("Down Payment: ");

        double resCost = duration * rate;
        double addCharges = food + service + other;
        double subtotal = resCost + addCharges;
        double discAmt = subtotal * (discPct / 100);
        double total = subtotal - discAmt;
        double balance = total - down;

        String bar = "=".repeat(46);
        String dash = "-".repeat(46);
        System.out.println();
        System.out.println(bar);
        System.out.println("      ******** RESERVATION BILLING ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-14s %s%n", "Name", name);
        System.out.printf("  %-14s %s%n", "Customer ID", id);
        System.out.println(dash);
        System.out.println("RESERVATION DETAILS");
        System.out.printf("  %-14s %s%n", "Type", type);
        System.out.printf("  %-28s %15.2f%n", "Duration (Days/Hours)", duration);
        line("Rate", rate);
        line("Reservation Cost", resCost);
        System.out.println(dash);
        System.out.println("CHARGES BREAKDOWN");
        line("Food Charges", food);
        line("Service Charges", service);
        line("Other Charges", other);
        line("SUBTOTAL", subtotal);
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        System.out.printf("  %-28s %14.2f%%%n", "Discount (%)", discPct);
        line("Discount Amount", discAmt);
        line("TOTAL BILL", total);
        line("Down Payment", down);
        line("REMAINING BALANCE", balance);
        System.out.println(bar);
    }
}
