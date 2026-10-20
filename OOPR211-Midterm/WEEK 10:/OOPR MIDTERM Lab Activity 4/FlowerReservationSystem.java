import java.util.Scanner;

public class FlowerReservationSystem {
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

        System.out.println("\n=== Reservation Details ===");
        String flower = s("Flower Type (Roses/Tulips/Sunflowers): ");
        String arrangement = s("Arrangement Type (Bouquet/Vase/Box): ");
        double price = d("Price per Arrangement: ");
        int qty = i("Quantity: ");
        String resDate = s("Reservation Date (YYYY-MM-DD): ");
        String pickupDate = s("Pickup/Delivery Date (YYYY-MM-DD): ");

        System.out.println("\n=== Additional Services ===");
        double delivery = d("Delivery Fee: ");
        double custom = d("Customization Fee: ");
        double other = d("Other Charges: ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double down = d("Down Payment: ");

        double resCost = price * qty;
        double addCharges = delivery + custom + other;
        double subtotal = resCost + addCharges;
        double discAmt = subtotal * (discPct / 100);
        double total = subtotal - discAmt;
        double balance = total - down;

        String bar = "=".repeat(50);
        String dash = "-".repeat(50);
        System.out.println();
        System.out.println(bar);
        System.out.println("     ******** FLOWER RESERVATION RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-20s %s%n", "Name", name);
        System.out.printf("  %-20s %s%n", "Customer ID", id);
        System.out.printf("  %-20s %s%n", "Contact Number", contact);
        System.out.println(dash);
        System.out.println("RESERVATION SUMMARY");
        System.out.printf("  %-20s %s%n", "Flower Type", flower);
        System.out.printf("  %-20s %s%n", "Arrangement Type", arrangement);
        System.out.printf("  %-28s %15d%n", "Quantity", qty);
        line("Price per Arrangement", price);
        line("Reservation Cost", resCost);
        System.out.printf("  %-20s %s%n", "Reservation Date", resDate);
        System.out.printf("  %-20s %s%n", "Pickup/Delivery Date", pickupDate);
        System.out.println(dash);
        System.out.println("CHARGES BREAKDOWN");
        line("Delivery Fee", delivery);
        line("Customization Fee", custom);
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
