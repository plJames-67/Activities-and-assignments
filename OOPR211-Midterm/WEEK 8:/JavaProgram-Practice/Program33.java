// Program to print odd and even numbers from an array
public class Program33 {
    public static void main(String args[]) {
        int s, i;
        int[] a = { 33, 2, 4, 71, 88, 92, 9, 1 };
        for (i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    s = a[i];
                    a[i] = a[j];
                    a[j] = s;
                }
            }
        }
        System.out.print("Input numbers :");
        for (i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print("\nOdd numbers :");
        for (i = 0; i <= a.length - 1; i++) {
            if (a[i] % 2 != 0) {
                System.out.print(" " + a[i]);
            }
        }
        System.out.print("\nEven numbers :");
        for (i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.print(" " + a[i]);
            }
        }
    }
}
