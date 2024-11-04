package hexlet.code.games;

import java.util.Random;

public class Progression implements Game {
    private static final Random RANDOM = new Random();
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private int progressionLength;
    private int startValue;
    private int step;
    private int hiddenIndex;
    private  int correctAnswer;

    public String getDescription() {
        return DESCRIPTION;
    }

    public String generateQuestion() {
        progressionLength = RANDOM.nextInt(6) + 5;
        startValue = RANDOM.nextInt(100);
        step = RANDOM.nextInt(10) + 1;
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

    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }

    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
