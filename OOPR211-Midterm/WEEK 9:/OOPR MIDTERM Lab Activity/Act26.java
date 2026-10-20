public class Act26 {
    public static void main(String[] args) {
        int rows = 4;
        int num = 1; 

        for (int row = 1; row <= rows; row++) {
            for (int space = rows - row; space > 0; space--) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(num + " ");
                num++; 
            }
            System.out.println();
        }
    }
}
