import java.util.Scanner;
public class ASSIGNMENTS {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter a number: ");
    int num = input.nextInt();
    if (num % 2 == 0) {
    System.out.println("It is an even number!");
    } else {
    System.out.println("It is an odd number!");
    }
  }
}
