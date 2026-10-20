import java.util.Scanner;

public class Act2Switch {
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

   switch (month) {
            case 1:
                Month = "January";
                break;
            case 2:
                Month = "February";
                break;
            case 3:
                Month = "March";
                break;
            case 4:
                Month = "April";
                break;
            case 5:
                Month = "May";
                break;
            case 6:
                Month = "June";
                break;
            case 7:
                Month = "July";
                break;
            case 8:
                Month = "August";
                break;
            case 9:
                Month = "September";
                break;
            case 10:
                Month = "October";
                break;
            case 11:
                Month = "November";
                break;
            case 12:
                Month = "December";
                break;
            default:
                System.out.println("Invalid month");
                return;
        }

        System.out.println(Month + " " + day + ", " + year);
    }
}
