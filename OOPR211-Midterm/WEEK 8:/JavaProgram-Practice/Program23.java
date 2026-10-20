// Pattern:
// *****
// ****
// ***
// **
// *
import java.util.Scanner;

public class Program23 {
    public static void main(String args[]) {
        int i, j, t;
        System.out.println("How many row you want ");
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (j = 0; j < t; j++) {
            for (i = t - 1; i >= j; i--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
