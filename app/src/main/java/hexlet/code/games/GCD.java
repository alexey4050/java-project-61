package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD {

    static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void run() {
        var rounds = new String[Engine.ROUNDS_COUNTS][2];

        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = generateRound();
        }
        Engine.run(RULES, rounds);
    }

    private static String[] generateRound() {
        int numberOne = Utils.generateRandomNumber();
        int numberTwo = Utils.generateRandomNumber();
        String correctAnswer = "" + gcd(numberOne, numberTwo);
        String question = numberOne + " " + numberTwo;

        return new String[]{question, correctAnswer};
    }

    public static int gcd(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
        return gcd(numTwo, numOne % numTwo);
    }
}
