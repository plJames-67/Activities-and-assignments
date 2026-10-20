// Total number of odd numbers between 1 - 100
class Program3 {
    public static void main(String args[]) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                count++;
            }
        }
        System.out.println("The Count Of Odd Numbers are:" + count);
    }
}
