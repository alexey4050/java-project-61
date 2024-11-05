package hexlet.code.games;

import java.util.Random;

public final class Calc {
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = -100;
    private static final Random RANDOM = new Random();

    public static String getDescription() {
        return "What is the result of the expression?";
    }

    public static String generateQuestion(int numberOne, int numberTwo) {
        String[] operations = {"+", "-", "*"};
        String operation = operations[getRandomNumber(0, operations.length - 1)];
        String currentQuestion = String.format("%d %s %d", numberOne, operation, numberTwo);
        return currentQuestion;
    }

    public static String getCorrectAnswer(int numberOne, int numberTwo, String currentQuestion) {
        switch (currentQuestion.split(" ")[1]) {
            case "+":
                return String.valueOf(numberOne + numberTwo);
            case "-":
                return String.valueOf(numberOne - numberTwo);
            case "*":
                return String.valueOf(numberOne * numberTwo);
            default:
                return "Invalid choice. Please try again. " + currentQuestion.split(" ")[1];
        }
    }

    public static boolean isCorrectAnswer(String userAnswer, int numberOne, int numberTwo, String currentQuestion) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(numberOne, numberTwo, currentQuestion));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (RANDOM.nextDouble() * (max - min + 1) + min);
    }
}
