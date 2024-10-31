package hexlet.code;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Cli.greet();
                    break;
                case 2:
                    EvenGame.runGame();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. " + choice);
            }
        }
    }
}
