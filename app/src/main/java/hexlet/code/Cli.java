package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");
        String name = SCANNER.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static String getUserName() {
        System.out.println("May I have your name?");
        return SCANNER.nextLine();
        }

    public static String getUserAnswer() {
        System.out.println("Your answer: ");
        return SCANNER.nextLine();
    }
}
