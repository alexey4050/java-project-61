package hexlet.code.games;

import java.util.Random;

public class Even implements Game {
    private static final Random RANDOM = new Random();
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private int number;

    public String getDescription() {
        return DESCRIPTION;
    }

    public String generateQuestion() {
        number = RANDOM.nextInt(100);
        return String.valueOf(number);
    }

    public String getCorrectAnswer() {
        return number % 2 == 0 ? "yes" : "no";
    }
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
