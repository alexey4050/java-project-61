package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(Cli.SCANNER.nextLine());

            switch (choice) {
                case 1:
                    Cli.greet();
                    break;
                case 2:
                    Engine.run(new Even());
                    break;
                case 3:
                    Engine.run(new Calc());
                    break;
                case 4:
                    Engine.run(new GCD());
                    break;
                case 5:
                    Engine.run(new Progression());
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again. " + choice);
            }
        }
    }
}
