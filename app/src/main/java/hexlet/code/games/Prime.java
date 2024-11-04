package hexlet.code.games;

import java.util.Random;

public final class Prime implements Game {
    public static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;
    private int number;

    @Override
    public String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        number = RANDOM.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    @Override
    public String getCorrectAnswer() {
        return isPrime(number) ? "yes" : "no";
    }

    public boolean isPrime(int num) {
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

    @Override
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
