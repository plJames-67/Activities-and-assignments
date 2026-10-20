import java.util.Scanner;

public class Act14while {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a no. ");
        int n = scanner.nextInt();
        
        int factorial = 1;
        int i = 1;
        while (i <= n) {
            factorial = factorial * i;
            i++; 
        }   
        System.out.println("Factorial value : " + factorial);
    }
}
