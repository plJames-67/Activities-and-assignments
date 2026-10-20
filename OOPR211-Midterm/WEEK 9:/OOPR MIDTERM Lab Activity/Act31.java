public class Act31 {
    public static void main(String[] args) {
        int n = 5;

        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            int num = 1;
            for (int col = 1; col <= row; col++) {
                System.out.print(num + " ");
                num++;
            }
            num -= 2; 
            for (int col = 1; col < row; col++) {
                System.out.print(num + " ");
                num--;
            }
            System.out.println();
        }
    }
}
