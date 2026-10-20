import java.util.Scanner;

public class Act16while {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base no. ");
        int base = scanner.nextInt();
        
        System.out.print("Enter exponent no. ");
        int exponent = scanner.nextInt();
        
        int result = 1;
        int i = 1; 
        
        while (i <= exponent) {
            result = result * base;
            i++;
        }
        System.out.println("Power value: " + result);
    }
}
