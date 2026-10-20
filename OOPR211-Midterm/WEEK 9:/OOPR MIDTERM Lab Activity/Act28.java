public class Act28 {
    public static void main(String[] args) {
        int rows = 10;

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
