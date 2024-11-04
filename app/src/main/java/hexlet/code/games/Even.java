package hexlet.code.games;

import java.util.Random;

public final class Even {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;

    public static String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

//    public static String generateQuestion() {
//        int number = RANDOM.nextInt(MAX_NUMBER);
//        return String.valueOf(number);
//    }

    public static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static boolean isCorrectAnswer(String userAnswer, int number) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(number));
    }
}
