package hexlet.code.games;

import hexlet.code.Utils;

public final class Progression {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_START_VALUE = 100;
    private static final int MAX_STEP = 10;

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static String generateQuestion() {
        int progressionLength = MIN_LENGTH + Utils.getRandomInt(0, MAX_LENGTH - MIN_LENGTH);
        int startValue = Utils.getRandomInt(1, MAX_START_VALUE);
        int step = Utils.getRandomInt(1, MAX_STEP);

        String[] progression = new String[progressionLength];
        int hiddenIndex = Utils.getRandomInt(0, progressionLength - 1);
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
