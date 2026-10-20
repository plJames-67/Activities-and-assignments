import java.util.Scanner;

public class Act20dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number n: ");
        int n = scanner.nextInt();
        
        int totalSum = 0;
        int i = 1; 
        
        do {
            int powerValue = 1;
            int j = 1; 
            
            do {
                powerValue = powerValue * i;
                j++;
            } while (j <= i);
            
            totalSum = totalSum + powerValue;
            i++;
        } while (i <= n);
        System.out.println("Output: " + totalSum);
    }
}
