package hexlet.code.games;

import java.util.Random;

public final class Progression implements Game {
    private static final Random RANDOM = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 6;
    private static final int MAX_START_VALUE = 100;
    private static final int MAX_STEP = 10;
    private int progressionLength;
    private int startValue;
    private int step;
    private int hiddenIndex;
    private  int correctAnswer;

    @Override
    public String getDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    public String generateQuestion() {
        progressionLength = RANDOM.nextInt(MAX_LENGTH) + MIN_LENGTH;
        startValue = RANDOM.nextInt(MAX_START_VALUE) + 1;
        step = RANDOM.nextInt(MAX_STEP) + 1;
        hiddenIndex = RANDOM.nextInt(progressionLength);

        String question = "";
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

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }

    @Override
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
