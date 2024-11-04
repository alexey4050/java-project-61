package hexlet.code.games;

import java.util.Random;

public final class GCD {

    private static final Random RANDOM = new Random();
    private static final int MAX_GCD_NUMBER = 100;

    public static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String generateQuestion(int numberOne, int numberTwo) {
        numberOne = RANDOM.nextInt(MAX_GCD_NUMBER);
        numberTwo = RANDOM.nextInt(MAX_GCD_NUMBER);
        return String.format("%d %d", numberOne, numberTwo);
    }

    public static String getCorrectAnswer(int numberOne, int numberTwo) {
        return String.valueOf(gcd(numberOne, numberTwo));
    }

    public static boolean isCorrectAnswer(String userAnswer, int numberOne, int numberTwo) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(numberOne, numberTwo));
    }

    public static int gcd(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
        return gcd(numTwo, numOne % numTwo);
    }
}
