import java.util.Scanner;

public class Act15for {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a no. ");
        int n = scanner.nextInt();
        
        int num1 = 1, num2 = 1;
        
        System.out.print("Fibonacci series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(num1 + " ");

            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        System.out.println();
    }
}
