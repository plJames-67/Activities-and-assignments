import  java.util.Scanner;

public class Act1Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char ch = scanner.next().charAt(0);

        switch (ch) {
            case 'a':
            case 'A':
                System.out.println(ch + " is a VOWEL.");
            break;
            case 'e':
            case 'E':
                System.out.println(ch + " is a VOWEL.");
            break;
            case 'i':
            case 'I':    
                System.out.println(ch + " is a VOWEL.");
            break;
            case 'o':
            case 'O':
                System.out.println(ch + " is a VOWEL.");
            break;
            case 'u':
            case 'U':
                System.out.println(ch + " is a VOWEL.");
            break;
            default: 
                System.out.println(ch + " is a CONSONANT");
        } 
        
    }
}

