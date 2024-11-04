package hexlet.code.games;

public class Calc implements Game {
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = -100;
    private String currentQuestion;
    private int numberOne;
    private int numberTwo;

    public String getDescription() {
        return "What is the result of the expression?";
    }

    public String generateQuestion() {
        numberOne = getRandomNumber(MIN_VALUE, MAX_VALUE);
        numberTwo = getRandomNumber(MIN_VALUE, MAX_VALUE);
        String[] operations = {"+", "-", "*"};
        String operation = operations[getRandomNumber(0, operations.length - 1)];
        currentQuestion = String.format("%d %s %d", numberOne, operation, numberTwo);
        return currentQuestion;
    }

    public String getCorrectAnswer() {
        switch (currentQuestion.split(" ")[1]) {
            case "+":
                return String.valueOf(numberOne + numberTwo);
            case "-":
                return String.valueOf(numberOne - numberTwo);
            case "*":
                return String.valueOf(numberOne * numberTwo);
            default:
                return "Invalid choice. Please try again. " + currentQuestion.split(" ")[1];
        }
    }

    public boolean isCorrectAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer());
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (min - max + 1) + min);
    }
}
