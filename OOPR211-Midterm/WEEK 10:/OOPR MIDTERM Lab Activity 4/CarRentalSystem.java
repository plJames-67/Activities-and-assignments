import java.util.Scanner;

public class CarRentalSystem {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }
    static int i(String p) { return Integer.parseInt(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-28s %15.2f%n", label, v); }

    public static void main(String[] args) {
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");
        String license = s("Driver's License Number: ");

        System.out.println("\n=== Vehicle Details ===");
        String vType = s("Vehicle Type (Sedan/SUV/Van): ");
        String model = s("Vehicle Model: ");
        double rate = d("Rental Rate per Day: ");

        System.out.println("\n=== Rental Details ===");
        int days = i("Number of Rental Days: ");
        String pickup = s("Pickup Date (YYYY-MM-DD): ");
        String ret = s("Return Date (YYYY-MM-DD): ");

        System.out.println("\n=== Additional Charges ===");
        double insurance = d("Insurance Fee: ");
        double fuel = d("Fuel Charge: ");
        double other = d("Other Charges: ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double paid = d("Amount Paid: ");

        double rentalCost = rate * days;
        double addCharges = insurance + fuel + other;
        double subtotal = rentalCost + addCharges;
        double discAmt = subtotal * (discPct / 100);
        double due = subtotal - discAmt;

        String bar = "=".repeat(48);
        String dash = "-".repeat(48);
        System.out.println();
        System.out.println(bar);
        System.out.println("        ******** CAR RENTAL RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-24s %s%n", "Name", name);
        System.out.printf("  %-24s %s%n", "Customer ID", id);
        System.out.printf("  %-24s %s%n", "Driver's License Number", license);
        System.out.println(dash);
        System.out.println("VEHICLE INFORMATION");
        System.out.printf("  %-24s %s%n", "Vehicle Type", vType);
        System.out.printf("  %-24s %s%n", "Vehicle Model", model);
        line("Rate per Day", rate);
        System.out.println(dash);
        System.out.println("RENTAL SUMMARY");
        System.out.printf("  %-24s %s%n", "Pickup Date", pickup);
        System.out.printf("  %-24s %s%n", "Return Date", ret);
        System.out.printf("  %-28s %15d%n", "Number of Days", days);
        line("Rental Cost", rentalCost);
        System.out.println(dash);
        System.out.println("CHARGES BREAKDOWN");
        line("Insurance Fee", insurance);
        line("Fuel Charge", fuel);
        line("Other Charges", other);
        line("SUBTOTAL", subtotal);
        System.out.println(dash);
        System.out.println("PAYMENT SUMMARY");
        System.out.printf("  %-28s %14.2f%%%n", "Discount (%)", discPct);
        line("Discount Amount", discAmt);
        line("TOTAL AMOUNT DUE", due);
        line("Amount Paid", paid);
        if (paid >= due) {
            line("CHANGE", paid - due);
        } else {
            line("REMAINING BALANCE", due - paid);
        }
        System.out.println(bar);
    }
}
