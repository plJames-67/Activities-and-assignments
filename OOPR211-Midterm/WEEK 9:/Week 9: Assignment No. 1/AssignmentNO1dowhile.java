import java.util.Scanner;

public class AssignmentNO1dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.class);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        int i = 1;
        do {
            System.out.println(name);
            i++;
        } while (i <= 5);
        
        scanner.close();
    }
}
