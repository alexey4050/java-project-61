package hexlet.code.games;

import java.util.Random;

public class Even implements Game {
    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;
    private int number;

    public String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String generateQuestion() {
        number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    public String getCorrectAnswer() {
        return number % 2 == 0 ? "yes" : "no";
    }
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
