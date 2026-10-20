import java.util.Scanner;

public class Act9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter tuition fee: ");
        double tuitionFee = scanner.nextDouble();
    
        System.out.print("Enter mode of payment (Type 1 for Cash, 2 for Two-Installment, 3 for Three-Installment): ");
        int mode = scanner.nextInt();
        
        double totalTuition = 0;

        if (mode == 1) {
            totalTuition = tuitionFee - (tuitionFee * 0.10);
        } else if (mode == 2) {
            totalTuition = tuitionFee + (tuitionFee * 0.05);
        } else if (mode == 3) {
            totalTuition = tuitionFee + (tuitionFee * 0.10);
        } else {
            System.out.println("Invalid mode of payment selected.");
            scanner.close();
            return; 
        }

        System.out.println("Your total tuition fee is: " + totalTuition);
        
        scanner.close();
    }
}
