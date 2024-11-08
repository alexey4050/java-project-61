package hexlet.code;

public class App {
    private static final int GREET_GAME = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT = 0;

    public static void main(String[] args) {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int choice = Cli.SCANNER.nextInt();
        Cli.SCANNER.nextLine();

        switch (choice) {
            case GREET_GAME:
                Cli.greet();
                break;
            case EVEN_GAME:
                Engine.run("Even");
                break;
            case CALC_GAME:
                Engine.run("Calc");
                break;
            case GCD_GAME:
                Engine.run("GCD");
                break;
            case PROGRESSION_GAME:
                Engine.run("Progression");
                break;
            case PRIME_GAME:
                Engine.run("Prime");
                break;
            case EXIT:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again. " + choice);
        }
    }
}
