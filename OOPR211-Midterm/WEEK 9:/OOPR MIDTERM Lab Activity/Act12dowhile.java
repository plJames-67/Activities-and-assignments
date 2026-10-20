public class Act12dowhile {    
    public static void main(String[] args) {
        int left = 1;
        int right = 5;
        
        do {
            System.out.print(left + ", " + right + ", ");
            left++;  
            right--; 
        } while (left <= 5);
    }
}
