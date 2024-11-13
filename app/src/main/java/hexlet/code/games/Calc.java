package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {

    static final String RULES = "What is the result of the expression?";
    static final String[] OPERATORS = {"+", "-", "*"};


    public static void run() {
        var rounds = new String[Engine.ROUNDS_COUNTS][2];

        for (int i = 0; i < rounds.length; i += 1) {
            rounds[i] = generateRound();
        }

        Engine.run(RULES, rounds);
    }

    private static String[] generateRound() {
        int numberOne = Utils.generateRandomNumber();
        int numberTwo = Utils.generateRandomNumber();
        String operation = OPERATORS[Utils.generateRandomNumber(0, OPERATORS.length)];
        String correctAnswer = "" + getCorrectAnswer(numberOne, numberTwo, operation);
        String question = numberOne + " " + operation + " " + numberTwo;
        return new String[]{question, correctAnswer};

    }

    public static int getCorrectAnswer(int numberOne, int numberTwo, String operation) {
        switch (operation) {
            case "+":
                return numberOne + numberTwo;
            case "-":
                return numberOne - numberTwo;
            case "*":
                return numberOne * numberTwo;
            default:
                throw new IllegalArgumentException("Invalid operation. Please try again: " + operation);
        }
    }
}
