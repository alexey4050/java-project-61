package hexlet.code.games;

import java.util.Random;

public final class Progression {
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 6;
    private static final int MAX_START_VALUE = 100;
    private static final int MAX_STEP = 10;

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static String generateQuestion() {
        int progressionLength = RANDOM.nextInt(MAX_LENGTH) + MIN_LENGTH;
        int startValue = RANDOM.nextInt(MAX_START_VALUE) + 1;
        int step = RANDOM.nextInt(MAX_STEP) + 1;
        int hiddenIndex = RANDOM.nextInt(progressionLength);

        String question = "";
        int correctAnswer = 0;
        for (int i = 0; i < progressionLength; i++) {
            if (i == hiddenIndex) {
                question += ".. ";
                correctAnswer = startValue + step * i;
            } else {
                question += (startValue + step * i) + " ";
            }
        }
        return question.trim();
    }

    public static String getCorrectAnswer(String question) {
        int hiddenIndex = question.indexOf(".. ");
        if (hiddenIndex == -1) {
            return "Error: Missing hidden number";
        }
        String[] parts = question.split(" ");
        int startValue = Integer.parseInt(parts[0]);
        int step = Integer.parseInt(parts[2]) - Integer.parseInt(parts[1]);
        return String.valueOf(startValue + step * (hiddenIndex / 2 + 1));
    }


    public static boolean isCorrectAnswer(String userAnswer, String question) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(question));
    }
}
