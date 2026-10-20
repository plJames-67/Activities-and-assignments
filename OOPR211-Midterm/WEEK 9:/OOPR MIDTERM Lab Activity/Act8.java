import java.util.Scanner;

public class Act8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number <= 0 || number > 3000) {
            System.out.println("Invalid input. Please enter a number between 1 and 3000.");
        } else {
            System.out.println("Roman Numeral: "
                    + thousands[number / 1000]
                    + hundreds[number % 1000 / 100]
                    + tens[number % 100 / 10]
                    + ones[number % 10]);
        }

        scanner.close();
    }
}