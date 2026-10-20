// Program to print the reverse of a given number
public class Program41 {
    public static void main(String[] args) {
        int rev = 0;
        int num = 1234;
        int no = num;
        while (num > 0) {
            int rem = num % 10;
            rev = rem + (rev * 10);
            num = num / 10;
        }
        System.out.println("Number = " + no);
        System.out.println("Reverse = " + rev);
    }
}
