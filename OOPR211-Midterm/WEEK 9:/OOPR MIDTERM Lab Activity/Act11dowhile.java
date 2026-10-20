public class Act11dowhile {
    public static void main(String[] args) {
        System.out.println("Sequence nos. Squared");
        
        int i = 1;
        do {
            int squared = i * i;
            System.out.println(i + "\t" + squared);
            i++;
        } while (i <= 5); 
    }
}
