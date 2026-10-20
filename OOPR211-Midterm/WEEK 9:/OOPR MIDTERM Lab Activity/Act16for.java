import java.util.Scanner;
public class Act16for { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base no. ");
        int base = scanner.nextInt();
        
        System.out.print("Enter exponent no. ");
        int exponent = scanner.nextInt();
        
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        System.out.println("Power value: " + result);
    }
}
