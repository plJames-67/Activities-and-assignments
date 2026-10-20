public class Act13dowhile {
    public static void main(String[] args) {
        int left = 5;
        int right = 1;
        
        do {
            System.out.print(left + ", " + right + ", ");
            left--;  
            right++; 
        } while (right <= 5);
    }
}
