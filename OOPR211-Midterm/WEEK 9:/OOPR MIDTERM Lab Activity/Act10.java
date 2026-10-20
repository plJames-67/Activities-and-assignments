import java.util.Scanner;

public class Act10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter grade in percentile form: ");
        int percentile = scanner.nextInt();
     
        if (percentile >= 98 && percentile <= 100) {
            System.out.println("Grade is equivalent to 1.00");
        } else if (percentile >= 95 && percentile <= 97) {
            System.out.println("Grade is equivalent to 1.25");
        } else if (percentile >= 92 && percentile <= 94) {
            System.out.println("Grade is equivalent to 1.50");
        } else if (percentile >= 89 && percentile <= 91) {
            System.out.println("Grade is equivalent to 1.75");
        } else if (percentile >= 85 && percentile <= 88) {
            System.out.println("Grade is equivalent to 2.00");
        } else if (percentile >= 82 && percentile <= 84) {
            System.out.println("Grade is equivalent to 2.25");
        } else if (percentile >= 80 && percentile <= 81) {
            System.out.println("Grade is equivalent to 2.50");
        } else if (percentile >= 77 && percentile <= 79) {
            System.out.println("Grade is equivalent to 2.75");
        } else if (percentile >= 75 && percentile <= 76) {
            System.out.println("Grade is equivalent to 3.00");
        } else {
            System.out.println("Grade equivalent is Out-of-Range");
        }
    }
}
