import java.util.Scanner;

public class Act20for {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        
        int totalSum = 0;
 
        for (int i = 1; i <= n; i++) {
            int powerValue = 1;
            for (int j = 1; j <= i; j++) {
                powerValue = powerValue * i;
            }
            totalSum = totalSum + powerValue;
        }
        System.out.println("Output: " + totalSum);
    }
}
