public class Act13while {
    public static void main(String[] args) {
        int left = 5;
        int right = 1;
        
        while (right <= 5) {
            System.out.print(left + ", " + right + ", ");
            left--; 
            right++; 
        }
    }
}
