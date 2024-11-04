package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static final int ROUNDS_COUNTS = 3;
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MAX_VALUE = 100;

    public static void run(String gameName) {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        String userName = Cli.getUserName();
        System.out.println("Hello, " + userName + "!");

        switch (gameName) {
            case "Even":
                playEvenGame(userName);
                break;
            case "Calc":
                playCalcGame(userName);
                break;
            case "GCD":
                playGCDGame(userName);
                break;
            case "Progression":
                playProgressionGame(userName);
                break;
            case "Prime":
                playPrimeGame(userName);
                break;
            default:
                System.out.println("Game not found");
        }
    }

    private static void playEvenGame(String userName) {
        System.out.println(Even.getDescription());
        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            int number = RANDOM.nextInt(MAX_VALUE);
            System.out.println("Question: " + number);
            String userAnswer = getUserAnswer();

            if (Even.isCorrectAnswer(userAnswer, number)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.println("Correct answer was '" + Even.getCorrectAnswer(number) + "'. ");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static void playCalcGame(String userName) {
        System.out.println(Calc.getDescription());
        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            int numberOne = RANDOM.nextInt(MAX_VALUE);
            int numberTwo = RANDOM.nextInt(MAX_VALUE);
            String currentQuestion = Calc.generateQuestion(numberOne, numberTwo);
            System.out.println("Question: " + currentQuestion);
            String userAnswer = getUserAnswer();

            if (Calc.isCorrectAnswer(userAnswer, numberOne, numberTwo, currentQuestion)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.print("Correct answer was '");
                System.out.println(Calc.getCorrectAnswer(numberOne, numberTwo, currentQuestion) + "'. ");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static void playGCDGame(String userName) {
        System.out.println(GCD.getDescription());
        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            int numberOne = RANDOM.nextInt(MAX_VALUE);
            int numberTwo = RANDOM.nextInt(MAX_VALUE);
            System.out.println("Question: " + numberOne + " " + numberTwo);
            String userAnswer = getUserAnswer();

            if (GCD.isCorrectAnswer(userAnswer, numberOne, numberTwo)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.println("Correct answer was '" + GCD.getCorrectAnswer(numberOne, numberTwo) + "'. ");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static void playProgressionGame(String userName) {
        System.out.println(Progression.getDescription());
        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            String question = Progression.generateQuestion();
            System.out.println("Question: " + question);
            String userAnswer = getUserAnswer();

            if (Progression.isCorrectAnswer(userAnswer, question)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.println("Correct answer was '" + Progression.getCorrectAnswer(question) + "'. ");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static void playPrimeGame(String userName) {
        System.out.println(Prime.getDescription());
        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            int number = RANDOM.nextInt(MAX_VALUE);
            System.out.println("Question: " + number);
            String userAnswer = getUserAnswer();

            if (Prime.isCorrectAnswer(userAnswer, number)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.println("Correct answer was '" + Prime.getCorrectAnswer(number) + "'. ");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static String getUserAnswer() {
        System.out.println("Your answer: ");
        return SCANNER.nextLine();
    }
}
