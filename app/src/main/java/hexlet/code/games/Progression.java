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
        String[] parts = question.split(" ");
        int hiddenIndex = -1;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("..")) {
                hiddenIndex = i;
            }
        }
        if (hiddenIndex == -1) {
            return "Error: Missing hiddin number";
        }

        int step;
        if (hiddenIndex > 1) {
            step = Integer.parseInt(parts[hiddenIndex - 1]) - Integer.parseInt(parts[hiddenIndex - 2]);
        } else {
            step = Integer.parseInt(parts[hiddenIndex + 2]) - Integer.parseInt(parts[hiddenIndex + 1]);
        }
        int correctAnswer = Integer.parseInt(parts[hiddenIndex - 1]) + step;
        return String.valueOf(correctAnswer);
    }

    public static boolean isCorrectAnswer(String userAnswer, String question) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(question));
    }
}
