import java.util.Scanner;

public class AssignmentNO1while {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.class);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        int i = 1;
        while (i <= 5) {
            System.out.println(name);
            i++;
        }
        
        scanner.close();
    }
}
