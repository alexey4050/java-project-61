package hexlet.code.games;

import java.util.Random;

public class Calc implements Game {
    private static final Random RANDOM = new Random();
    private static final String DESCRIPTION = "What is the result of the expression?";
    private String currentQuestion;
    private int numberOne;
    private int numberTwo;

    public String getDescription() {
        return DESCRIPTION;
    }

    public String generateQuestion() {
        numberOne = RANDOM.nextInt(100);
        numberTwo = RANDOM.nextInt(100);
        String[] operations = {"+", "-", "*"};
        String operation = operations[RANDOM.nextInt(operations.length)];
        currentQuestion = String.format("%d %s %d", numberOne, operation, numberTwo);
        return currentQuestion;
    }

    public String getCorrectAnswer()  {
        String[] parts = currentQuestion.split(" ");
        numberOne = Integer.parseInt(parts[0]);
        numberTwo = Integer.parseInt(parts[2]);
        String operation = parts[1];
        switch (operation) {
            case "+":
                return String.valueOf(numberOne + numberTwo);
            case "-":
                return String.valueOf(numberOne - numberTwo);
            case "*":
                return String.valueOf(numberOne * numberTwo);
            default:
                return "Invalid choice. Please try again. " + operation;
        }
    }
    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }
}
