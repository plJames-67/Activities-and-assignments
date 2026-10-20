import java.util.Scanner;

public class Act17dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        
        int sum = 0;
        int i = 1;
        
        do {
            sum = sum + (i * i);
            i++;
        } while (i <= n);
        System.out.println("Output: " + sum);
    }
}
