import java.util.Scanner;

public class EventTicket {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-26s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");

        System.out.println("\n=== Ticket Details ===");
        String event = s("Event Name: ");
        String type = s("Ticket Type (Regular/VIP): ");
        double price = d("Ticket Price: ");
        int qty = i("Number of Tickets: ");

        System.out.println("\n=== Additional Options ===");
        double discPct = d("Discount (%): ");

        System.out.println("\n=== Payment Details ===");
        double tendered = d("Amount Tendered: ");

        double totalCost = price * qty;
        double discAmt = totalCost * (discPct / 100);
        double due = totalCost - discAmt;
        double change = tendered - due;

        String bar = "=".repeat(46);
        String dash = "-".repeat(46);
        System.out.println();
        System.out.println(bar);
        System.out.println("          ******** EVENT TICKET ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-14s %s%n", "Name", name);
        System.out.printf("  %-14s %s%n", "Customer ID", id);
        System.out.println(dash);
        System.out.println("TICKET INFORMATION");
        System.out.printf("  %-14s %s%n", "Event Name", event);
        System.out.printf("  %-14s %s%n", "Ticket Type", type);
        line("Ticket Price", price);
        System.out.printf("  %-26s %15d%n", "Number of Tickets", qty);
        line("Total Ticket Cost", totalCost);
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        System.out.printf("  %-26s %14.2f%%%n", "Discount (%)", discPct);
        line("Discount Amount", discAmt);
        line("FINAL AMOUNT DUE", due);
        line("Amount Tendered", tendered);
        line("Change", change);
        System.out.println(bar);
    }
}
