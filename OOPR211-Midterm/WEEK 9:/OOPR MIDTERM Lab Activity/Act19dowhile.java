import java.util.Scanner;

public class Act19dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int reversed = 0;
        
        do {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10; 
        } while (number != 0);
        System.out.println("Reverse number: " + reversed);
    }
}
