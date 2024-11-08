package hexlet.code.games;

import hexlet.code.Utils;

public final class Calc {

    public static String getDescription() {
        return "What is the result of the expression?";
    }

    public static String generateQuestion(int numberOne, int numberTwo) {
        char[] operations = {'+', '-', '*'};
        char operation = operations[Utils.getRandomInt(0, operations.length - 1)];
        String currentQuestion = String.format("%d %s %d", numberOne, operation, numberTwo);
        return currentQuestion;
    }

    public static String getCorrectAnswer(int numberOne, int numberTwo, char operation) {
        switch (operation) {
            case '+':
                return String.valueOf(numberOne + numberTwo);
            case '-':
                return String.valueOf(numberOne - numberTwo);
            case '*':
                return String.valueOf(numberOne * numberTwo);
            default:
                return "Invalid operation. Please try again. " + operation;
        }
    }

    public static boolean isCorrectAnswer(String userAnswer, int numberOne, int numberTwo, String currentQuestion) {
        char operation = currentQuestion.trim().split(" ")[1].charAt(0);
        String correctAnswer = getCorrectAnswer(numberOne, numberTwo, operation);
        return userAnswer.equals(correctAnswer);
    }
}
