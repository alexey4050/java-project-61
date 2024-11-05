package hexlet.code.games;

import java.util.Random;

public final class Progression {
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_START_VALUE = 100;
    private static final int MAX_STEP = 10;

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static String generateQuestion() {
        int progressionLength = MIN_LENGTH + RANDOM.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        int startValue = RANDOM.nextInt(MAX_START_VALUE) + 1;
        int step = RANDOM.nextInt(MAX_STEP) + 1;

        String[] progression = new String[progressionLength];
        int hiddenIndex = RANDOM.nextInt(progressionLength);
        for (int i = 0; i < progressionLength; i++) {
            if (i == hiddenIndex) {
                progression[i] = "..";
            } else {
                progression[i] = String.valueOf(startValue + i * step);
            }
        }
        return String.join(" ", progression);
    }

    public static String getCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int hiddenIndex = -1;

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("..")) {
                hiddenIndex = i;
                break;
            }
        }

        if (hiddenIndex == -1) {
            return "Error: Missing hidden number";
        }

        if (hiddenIndex > 1) {
            int prevNumber = Integer.parseInt(parts[hiddenIndex - 1]);
            int beforePrevNumber = Integer.parseInt(parts[hiddenIndex - 2]);
            int step = prevNumber - beforePrevNumber;
            return String.valueOf(prevNumber + step);
        } else if (hiddenIndex < parts.length - 2) {
            int nextNumber = Integer.parseInt(parts[hiddenIndex + 1]);
            int afterNextNumber = Integer.parseInt(parts[hiddenIndex + 2]);
            int step = afterNextNumber - nextNumber;
            return String.valueOf(nextNumber - step);
        } else {
            return "Error: Not enough data to calculate missing number";
        }

    }

    public static boolean isCorrectAnswer(String userAnswer, String question) {
        String correctAnswer = getCorrectAnswer(question);
        return userAnswer.equals(correctAnswer);
    }
}
