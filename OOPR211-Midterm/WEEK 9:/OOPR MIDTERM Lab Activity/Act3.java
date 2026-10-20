import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Temperature: ");
        double temp = scanner.nextDouble();

        if (temp <= 0) {
            System.out.println("It is ice.");
        } else if (temp > 0 && temp < 100) {
            System.out.println("It is water.");
        } else {
            System.out.println("It is steam.");
        }
    }  
}
