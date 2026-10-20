// Program to add two matrices
class Program34 {
    public static void main(String args[]) {
        int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] b = new int[][] { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } };
        int[][] c = new int[3][3];
        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
        } else {
            System.out.println("'A' and 'B' Matrix are not SAME");
            return;
        }
        System.out.println("The Matrix 'A' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("The Matrix 'B' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The Addition Matrix of 'A' and 'B' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
