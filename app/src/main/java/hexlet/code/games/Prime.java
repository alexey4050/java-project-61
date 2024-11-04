package hexlet.code.games;

import java.util.Random;

public class Prime implements Game {
    public static final Random RANDOM = new Random();
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'";
    private int number;

    public String getDescription() {
        return DESCRIPTION;
    }

    public String generateQuestion() {
        number = RANDOM.nextInt(100);
        return String.valueOf(number);
    }

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

    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
