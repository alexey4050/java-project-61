package hexlet.code.games;

public class Calc implements Game {

    private String currentQuestion;
    private int numberOne;
    private int numberTwo;

    public String getDescription() {
        return "What is the result of the expression?";
    }

    public String generateQuestion() {
        numberOne = getRandomNumber(1, 100);
        numberTwo = getRandomNumber(1, 100);
        String[] operations = {"+", "-", "*"};
        String operation = operations[getRandomNumber(0, operations.length)];
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
