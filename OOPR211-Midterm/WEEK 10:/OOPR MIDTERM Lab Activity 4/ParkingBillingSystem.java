import java.util.Scanner;

public class ParkingBillingSystem {
    static Scanner sc = new Scanner(System.in);

    static String s(String p) { System.out.print(p); return sc.nextLine().trim(); }
    static double d(String p) { return Double.parseDouble(s(p)); }

    static void line(String label, double v) { System.out.printf("  %-28s %15.2f%n", label, v); }

    // Converts HH:MM to minutes since midnight
    static int toMinutes(String t) {
        String[] p = t.split(":");
        return Integer.parseInt(p[0].trim()) * 60 + Integer.parseInt(p[1].trim());
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Information ===");
        String name = s("Customer Name: ");
        String id = s("Customer ID: ");
        String contact = s("Contact Number: ");

        System.out.println("\n=== Vehicle Information ===");
        String vType = s("Vehicle Type (Car or Motorcycle): ");
        String plate = s("Plate Number: ");

        System.out.println("\n=== Parking Reservation Details ===");
        String entry = s("Entry Time (HH:MM): ");
        String exit = s("Exit Time (HH:MM): ");
        double hourlyRate = d("Hourly Rate: ");
        double resFee = d("Reservation Fee: ");

        System.out.println("\n=== Additional Charges ===");
        double overnight = d("Overnight Fee (0 if none): ");
        double penalty = d("Penalty Fee (0 if none): ");

        System.out.println("\n=== Payment Details ===");
        double discPct = d("Discount (%): ");
        double cash = d("Cash Payment: ");

        int inMin = toMinutes(entry);
        int outMin = toMinutes(exit);
        int diff = outMin - inMin;
        if (diff < 0) diff += 24 * 60; // exit past midnight (next day)
        double hours = diff / 60.0;

        double parkingFee = hours * hourlyRate;
        double subtotal = parkingFee + resFee + overnight + penalty;
        double discAmt = subtotal * (discPct / 100);
        double total = subtotal - discAmt;

        String bar = "=".repeat(48);
        String dash = "-".repeat(48);
        System.out.println();
        System.out.println(bar);
        System.out.println("          ******** PARKING RECEIPT ********");
        System.out.println(bar);
        System.out.println("CUSTOMER DETAILS");
        System.out.printf("  %-18s %s%n", "Name", name);
        System.out.printf("  %-18s %s%n", "Customer ID", id);
        System.out.printf("  %-18s %s%n", "Contact Number", contact);
        System.out.println(dash);
        System.out.println("VEHICLE DETAILS");
        System.out.printf("  %-18s %s%n", "Vehicle Type", vType);
        System.out.printf("  %-18s %s%n", "Plate Number", plate);
        System.out.println(dash);
        System.out.println("PARKING SUMMARY");
        System.out.printf("  %-18s %s%n", "Entry Time", entry);
        System.out.printf("  %-18s %s%n", "Exit Time", exit);
        System.out.printf("  %-28s %15.2f%n", "Total Hours", hours);
        line("Hourly Rate", hourlyRate);
        line("Parking Fee", parkingFee);
        System.out.println(dash);
        System.out.println("CHARGES BREAKDOWN");
        line("Reservation Fee", resFee);
        line("Overnight Fee", overnight);
        line("Penalty Fee", penalty);
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
