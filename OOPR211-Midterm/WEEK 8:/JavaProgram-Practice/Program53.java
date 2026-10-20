// Program to print character position count in a given string
public class Program53 {

    public static void main(String args[]) {
        String s = "CANDIDJAVA";
        char[] a = s.toCharArray();
        int i = 1;
        for (char output : a) {
            System.out.print(output + " " + i + " ");
            i++;
        }
    }
}
