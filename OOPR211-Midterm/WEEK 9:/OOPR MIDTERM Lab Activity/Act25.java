public class Act25 {
    public static void main (String[] args) {   
        int rows = 5;
        
        for (int row = 1; row <= rows; row++){
            for (int column = 1; column <= rows - row; column++){
                System.out.print(" ");
            } 
            for (int asterisk = 1; asterisk <= (2 * row - 1); asterisk++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
