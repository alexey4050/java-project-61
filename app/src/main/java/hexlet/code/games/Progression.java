package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression {
    static final String RULES = "What number is missing in the progression?";
    static final int PROGRESSION_SIZE = 10;
    static final int MIN_STEP_VALUE = 1;
    static final int MAX_STEP_VALUE = 10;

    public static void run() {
        var rounds = new String[Engine.ROUNDS_COUNTS][2];

        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = generateRound();
        }
        Engine.run(RULES, rounds);
    }

    private static String[] generateRound() {
        int startValue = Utils.generateRandomNumber();
        int step = Utils.generateRandomNumber(MIN_STEP_VALUE, MAX_STEP_VALUE);
        var progression = generateProgression(startValue, step, PROGRESSION_SIZE);
        int hiddenIndex = Utils.generateRandomNumber(0, PROGRESSION_SIZE - 1);
        var question = generateQuestion(progression, hiddenIndex);
        var correctAnswer = progression[hiddenIndex];

        return new String[]{question, correctAnswer};
    }

    private static String[] generateProgression(int first, int step, int size) {

        var progression = new String[size];

        for (int i = 0; i < size; i++) {
            progression[i] = Integer.toString(first + step * i);
        }
        return progression;
    }

    private static String generateQuestion(String[] progression, int hiddenIndex) {
        var value = progression.clone();
        value[hiddenIndex] = "..";
        return String.join(" ", value);
    }
}
