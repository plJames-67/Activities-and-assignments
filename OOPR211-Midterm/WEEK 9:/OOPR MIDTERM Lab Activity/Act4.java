import java.util.Scanner;

public class Act4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plane's observed speed (km/h): ");
        double speed = scanner.nextDouble();
        System.out.print("Enter plane's estimated length (m): ");
        double length = scanner.nextDouble();

        if (speed > 1100 && length > 52) {
            System.out.println("The plane is a civilian aircraft");
        } else if (speed >= 500 && length >= 20) {
            System.out.println("The plane is a military aircraft");
        } else {    
            System.out.println("It's a bird");
        }
    }
}
