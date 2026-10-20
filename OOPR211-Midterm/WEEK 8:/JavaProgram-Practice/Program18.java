// Pattern:
// 1
// 121
// 12321
// 1234321
// 123454321
import java.util.Scanner;

public class Program18 {
    public static void main(String args[]) {
        int s = 1;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N values");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            while (s <= i) {
                System.out.print(s);
                s++;
            }
            s--;
            while (s > 1) {
                System.out.print(--s);
            }
            System.out.println();
        }
    }
}
