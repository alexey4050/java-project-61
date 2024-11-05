package hexlet.code.games;

public final class Prime {

    public static String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static String getCorrectAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectAnswer(String userAnswer, int number) {
        String correctAnswer = getCorrectAnswer(number);
        return userAnswer.equals(correctAnswer);
    }
}
