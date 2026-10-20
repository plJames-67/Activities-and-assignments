public class Act11while {
    public static void main(String[] args) {
        System.out.println("Sequence nos. Squared");
        
        int i = 1; 
        while (i <= 5) { 
            int squared = i * i;
            System.out.println(i + "\t" + squared);
            i++;
        }
    }
}
