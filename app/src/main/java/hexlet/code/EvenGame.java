package hexlet.code;

import java.util.Scanner;

public class EvenGame {

    private static final int MAX_ROUNDS = 3;

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        int random = 0;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;

        while (correctAnswers < MAX_ROUNDS) {
            int number = (int) (Math.random() * 100);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            boolean isEven = number % 2 == 0;
            boolean isCorrect = (isEven && answer.equals("yes")) || (!isEven && answer.equals("no"));

            if (isCorrect) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. "
                        + "Correct answer was '" + (isEven ? "yes" : "no") + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
