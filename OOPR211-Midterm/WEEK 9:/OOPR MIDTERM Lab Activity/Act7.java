import java.util.Scanner;

public class Act7 {
    private static final String[] ONES = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private static final String[] TEENS = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 3000) {
            System.out.println("Invalid input. Maximum input number is 3000.");
            return;
        } 
        
        if (number == 0) {
            System.out.println("zero");
            return;
        }

        StringBuilder result = new StringBuilder();

        int thousands = number / 1000;
        if (thousands > 0) {
            result.append(ONES[thousands]).append(" thousand ");
        }
        
        int remainder = number % 1000;
 
        int hundreds = remainder / 100;
        if (hundreds > 0) {
            result.append(ONES[hundreds]).append(" hundred ");
        }

        remainder = remainder % 100;
   
        if (remainder >= 10 && remainder <= 19) {
            result.append(TEENS[remainder - 10]);
        } else {
            int tens = remainder / 10;
            if (tens > 0) {
                result.append(TENS[tens]).append(" ");
            }

            int ones = remainder % 10;
            if (ones > 0) {
                result.append(ONES[ones]);
            }
        }

        System.out.println(result.toString().trim().replaceAll("\\s+", " "));
    }
}
