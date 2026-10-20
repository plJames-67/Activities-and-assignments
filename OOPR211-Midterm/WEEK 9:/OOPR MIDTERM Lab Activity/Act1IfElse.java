import java.util.Scanner;

public class Act1IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char ch = scanner.next().charAt(0);

        if (ch == 'a' || ch == 'A') {
            System.out.println(ch + " is a VOWEL.");
        } else if (ch == 'e' || ch == 'E') {
            System.out.println(ch + " is a VOWEL.");
        } else if (ch == 'i' || ch == 'I') {
            System.out.println(ch + " is a VOWEL.");
        } else if (ch == 'o' || ch == 'O') {
            System.out.println(ch + " is a VOWEL.");
        } else if (ch == 'u' || ch == 'U') {
            System.out.println(ch + " is a VOWEL.");
        } else {
            System.out.println(ch + " is a CONSONANT.");
        }
        
    }
}
