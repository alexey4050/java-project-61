package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.Engine;

public final class Even {

    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        var rounds = new String[Engine.ROUNDS_COUNTS][2];

        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = generateRound();
        }

        Engine.run(RULES, rounds);
    }

    private static String[] generateRound() {
        int randomNumber = Utils.generateRandomNumber();
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        String question = "" + randomNumber;
        return new String[]{question, correctAnswer};
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
