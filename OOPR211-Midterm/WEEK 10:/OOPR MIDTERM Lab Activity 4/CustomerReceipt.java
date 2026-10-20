import java.util.Scanner;

public class CustomerReceipt {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    public static void main(String[] args) {
        final int N = 3;
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");

        String[] items = new String[N];
        int[] qty = new int[N];
        double[] price = new double[N];
        double[] total = new double[N];
        double subtotal = 0;

        System.out.println("\n=== Purchase Details (" + N + " items) ===");
        for (int k = 0; k < N; k++) {
            System.out.println("Item " + (k + 1) + ":");
            items[k] = s("  Item Name: ");
            qty[k] = i("  Quantity: ");
            price[k] = d("  Price per Item: ");
            total[k] = qty[k] * price[k];
            subtotal += total[k];
        }

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double tendered = d("Amount Tendered: ");

        double discAmt = subtotal * (discPct / 100);
        double due = subtotal - discAmt;
        double change = tendered - due;

        String bar = "=".repeat(52);
        String dash = "-".repeat(52);
        System.out.println();
        System.out.println(bar);
        System.out.println("             ******** CUSTOMER RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-14s %s%n", "Name", name);
        System.out.printf("  %-14s %s%n", "Customer ID", id);
        System.out.println(dash);
        System.out.println("PURCHASED ITEMS");
        System.out.printf("  %-20s %5s %10s %12s%n", "Item Name", "Qty", "Price", "Total");
        System.out.println("  " + "-".repeat(50));
        for (int k = 0; k < N; k++) {
            System.out.printf("  %-20s %5d %10.2f %12.2f%n", items[k], qty[k], price[k], total[k]);
        }
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        System.out.printf("  %-28s %17.2f%n", "Subtotal", subtotal);
        System.out.printf("  %-28s %16.2f%%%n", "Discount (%)", discPct);
        System.out.printf("  %-28s %17.2f%n", "Discount Amount", discAmt);
        System.out.printf("  %-28s %17.2f%n", "TOTAL AMOUNT DUE", due);
        System.out.printf("  %-28s %17.2f%n", "Amount Tendered", tendered);
        System.out.printf("  %-28s %17.2f%n", "Change", change);
        System.out.println(bar);
    }
}
