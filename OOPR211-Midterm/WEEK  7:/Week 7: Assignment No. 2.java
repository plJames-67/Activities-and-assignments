import java.util.Scanner;
public class ASSIGNMENTS {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {

    System.out.print("Enter a letter: ");
    char ch = input.next().charAt(0);
    if (Character.isLetter(ch)) {
        char lowerCh = Character.toLowerCase(ch);
      if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
          System.out.println("Its a consonant!");
      }
    } else {
        System.out.println("Invalid input. Please enter a valid letter.");
    }
  }
}
