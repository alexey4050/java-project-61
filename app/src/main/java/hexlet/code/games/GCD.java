package hexlet.code.games;

import java.util.Random;

public final class GCD implements Game {

    private static final Random RANDOM = new Random();
    private static final int MAX_GCD_NUMBER = 100;
    private int numberOne;
    private int numberTwo;

    @Override
    public String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String generateQuestion() {
        numberOne = RANDOM.nextInt(MAX_GCD_NUMBER);
        numberTwo = RANDOM.nextInt(MAX_GCD_NUMBER);
        return String.format("%d %d", numberOne, numberTwo);
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(gcd(numberOne, numberTwo));
    }

    @Override
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }

    private int gcd(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
        return gcd(numTwo, numOne % numTwo);
    }
}
