package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {

    static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        var rounds = new String[Engine.ROUNDS_COUNTS][2];

        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = generateRound();
        }
        Engine.run(RULES, rounds);
    }

    private static String[] generateRound() {
        int number = Utils.generateRandomNumber();
        var question = "" + number;
        var correctAnswer = isPrime(number) ? "yes" : "no";

        return new String[]{question, correctAnswer};
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
