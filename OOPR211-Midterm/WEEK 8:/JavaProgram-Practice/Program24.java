// Pattern:
// * *
// ** **
// ******
public class Program24 {
    public static void main(String[] x) {
        int i, j, k, n = 3;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (j = (n - i); j >= 2; j--) {
                System.out.print(" ");
            }
            for (k = i; k >= 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
