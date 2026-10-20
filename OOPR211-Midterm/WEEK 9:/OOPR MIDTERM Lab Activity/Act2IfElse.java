import java.util.Scanner;

public class Act2IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Month;
        
        System.out.println("ENTER DATE IN NUMERICAL FORM");
        System.out.print("Month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Day (1-31): ");
        int day = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();

        if (month == 1) {
            Month = "January";
        } else if (month == 2) {
            Month = "February";
        } else if (month == 3) {
            Month = "March";
        } else if (month == 4) {
            Month = "April";
        } else if (month == 5) {
            Month = "May";
        } else if (month == 6) {
            Month = "June";
        } else if (month == 7) {
            Month = "July";
        } else if (month == 8) {
            Month = "August";
        } else if (month == 9) {
            Month = "September";
        } else if (month == 10) {
            Month = "October";
        } else if (month == 11) {
            Month = "November";
        } else if (month == 12) {
            Month = "December";
        } else {
            Month = "Invalid Month";
        }

        System.out.println(Month + " " + day + ", " + year);
        
    }
}
