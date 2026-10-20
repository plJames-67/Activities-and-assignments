import java.util.Scanner;

public class RestaurantOrderingSystem {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    public static void main(String[] args) {
        final int N = 3;
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String orderType = s("Order Type (Dine-In or Takeout): ");
        boolean dineIn = orderType.equalsIgnoreCase("Dine-In") || orderType.equalsIgnoreCase("DineIn");

        String[] items = new String[N];
        int[] qty = new int[N];
        double[] price = new double[N];
        double[] total = new double[N];
        double subtotal = 0;

        System.out.println("\n=== Order Details (" + N + " items) ===");
        for (int k = 0; k < N; k++) {
            System.out.println("Item " + (k + 1) + ":");
            items[k] = s("  Item Name: ");
            qty[k] = i("  Quantity: ");
            price[k] = d("  Price per Item: ");
            total[k] = qty[k] * price[k];
            subtotal += total[k];
        }

        System.out.println("\n=== Additional Charges ===");
        double service = d("Service Charge (0 if Takeout): ");
        double packaging = d("Packaging Fee (0 if Dine-In): ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double tendered = d("Amount Tendered: ");

        double charge = dineIn ? service : packaging;
        String chargeLabel = dineIn ? "Service Charge" : "Packaging Fee";
        double beforeDisc = subtotal + charge;
        double discAmt = beforeDisc * (discPct / 100);
        double due = beforeDisc - discAmt;
        double change = tendered - due;

        String bar = "=".repeat(52);
        String dash = "-".repeat(52);
        System.out.println();
        System.out.println(bar);
        System.out.println("          ******** RESTAURANT RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-14s %s%n", "Name", name);
        System.out.printf("  %-14s %s%n", "Order Type", orderType);
        System.out.println(dash);
        System.out.println("ORDER SUMMARY");
        System.out.printf("  %-20s %5s %10s %12s%n", "Item Name", "Qty", "Price", "Total");
        System.out.println("  " + "-".repeat(50));
        for (int k = 0; k < N; k++) {
            System.out.printf("  %-20s %5d %10.2f %12.2f%n", items[k], qty[k], price[k], total[k]);
        }
        System.out.println(dash);
        System.out.println("BILLING SUMMARY");
        System.out.printf("  %-28s %17.2f%n", "Subtotal", subtotal);
        System.out.printf("  %-28s %17.2f%n", chargeLabel, charge);
        System.out.printf("  %-28s %17.2f%n", "Total Before Discount", beforeDisc);
        System.out.printf("  %-28s %16.2f%%%n", "Discount (%)", discPct);
        System.out.printf("  %-28s %17.2f%n", "Discount Amount", discAmt);
        System.out.printf("  %-28s %17.2f%n", "TOTAL AMOUNT DUE", due);
        System.out.printf("  %-28s %17.2f%n", "Amount Tendered", tendered);
        if (change >= 0) {
            System.out.printf("  %-28s %17.2f%n", "Change", change);
        } else {
            System.out.printf("  %-28s %17.2f%n", "Change", 0.00);
            System.out.printf("  %-28s %17.2f%n", "BALANCE DUE (short)", -change);
        }
        System.out.println(bar);
    }
}
