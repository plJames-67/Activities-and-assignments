public class Act24 {
    public static void main (String[] args) {
        int rows = 5;
        for (int row = 1; row <= rows; row++) {
            for (int space = rows - row; space > 0; space--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
