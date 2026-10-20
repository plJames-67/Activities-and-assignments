// Program to check given matrix is a null matrix
class Program35 {
    public static void main(String args[]) {
        int[][] a = new int[][] { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
        boolean setValue = true;
        abc: for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0) {
                    setValue = false;
                    break abc;
                }
            }
        }

        System.out.println("The Given Matrix Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        if (setValue == true) {
            System.out.println("The Given Matrix is a Null Matrix");
        } else {
            System.out.println("The Given Matrix is not a Null Matrix");
        }
    }
}
