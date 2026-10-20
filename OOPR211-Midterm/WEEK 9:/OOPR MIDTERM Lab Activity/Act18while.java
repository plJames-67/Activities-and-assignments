import java.util.Scanner;

public class Act18while {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        
        int sum = 0;
        int i = 1; 
        
        while (i <= n) {
            sum = sum + i;
            i++;
        }
        
        System.out.println("Output: " + sum);
        scanner.close();
    }
}
