import java.util.Scanner;

public class KMartPurchaseOrder {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-28s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");
        String contact = s("Contact Number: ");

        System.out.println("\n=== Order Details ===");
        String product = s("Product Name (e.g., Shin Ramyun): ");
        String brand = s("Brand: ");
        double price = d("Price per Pack: ");
        int qty = i("Quantity: ");

        System.out.println("\n=== Additional Charges ===");
        double packaging = d("Packaging Fee: ");
        double delivery = d("Delivery Fee (0 if not applicable): ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double cash = d("Cash Payment: ");

        double productCost = price * qty;
        double subtotal = productCost + packaging + delivery;
        double discAmt = subtotal * (discPct / 100);
        double total = subtotal - discAmt;

        String bar = "=".repeat(50);
        String dash = "-".repeat(50);
        System.out.println();
        System.out.println(bar);
        System.out.println("      ******** KMART PURCHASE RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-20s %s%n", "Name", name);
        System.out.printf("  %-20s %s%n", "Customer ID", id);
        System.out.printf("  %-20s %s%n", "Contact Number", contact);
        System.out.println(dash);
        System.out.println("ORDER SUMMARY");
        System.out.printf("  %-20s %s%n", "Product Name", product);
        System.out.printf("  %-20s %s%n", "Brand", brand);
        line("Price per Pack", price);
        System.out.printf("  %-28s %15d%n", "Quantity", qty);
        line("Total Product Cost", productCost);
        System.out.println(dash);
        System.out.println("CHARGES");
        line("Packaging Fee", packaging);
        line("Delivery Fee", delivery);
        line("SUBTOTAL", subtotal);
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        System.out.printf("  %-28s %14.2f%%%n", "Discount (%)", discPct);
        line("Discount Amount", discAmt);
        line("TOTAL BILL", total);
        line("Cash Payment", cash);
        if (cash >= total) {
            line("CHANGE", cash - total);
        } else {
            line("REMAINING BALANCE", total - cash);
        }
        System.out.println(bar);
    }
}
