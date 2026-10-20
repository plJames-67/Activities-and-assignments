import java.util.Scanner;

public class Act5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter class ID (B or b, C or c, D or d, F or f: ");
        char id = scanner.next().charAt(0);

        if (id == 'B' || id == 'b')
            System.out.println("Battleship");
        else if (id == 'C' || id == 'c')
            System.out.println("Cruiser");
        else if (id == 'D' || id == 'd')
            System.out.println("Destroyer");
        else if (id == 'F' || id == 'f')
            System.out.println("Frigate");
        else
            System.out.println("Invalid class ID");
    }
}
