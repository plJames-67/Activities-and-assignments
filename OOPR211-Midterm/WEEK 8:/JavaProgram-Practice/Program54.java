// Program to print reversed string by word in given line
public class Program54 {
    public static void main(String[] args) {
        String input = "Welcome to Java Session";
        String[] words = input.split(" ");
        String[] revwords = new String[words.length];
        int j = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            revwords[j] = words[i];
            System.out.print(revwords[j] + " ");
            j++;
        }
    }
}
