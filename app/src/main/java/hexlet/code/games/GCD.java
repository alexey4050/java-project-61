package hexlet.code.games;

public final class GCD {

    public static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static String getCorrectAnswer(int numberOne, int numberTwo) {
        return String.valueOf(gcd(numberOne, numberTwo));
    }

    public static boolean isCorrectAnswer(String userAnswer, int numberOne, int numberTwo) {
        String correctAnswer = getCorrectAnswer(numberOne, numberTwo);
        return userAnswer.equals(correctAnswer);
    }

    public static int gcd(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
        return gcd(numTwo, numOne % numTwo);
    }
}
