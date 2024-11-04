package hexlet.code.games;

import java.util.Random;

public final class Prime {
    public static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;

    public static String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String generateQuestion() {
        int number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    public static String getCorrectAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectAnswer(String userAnswer, int number) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(number));
    }
}
