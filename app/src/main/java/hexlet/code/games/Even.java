package hexlet.code.games;

public final class Even {

    public static String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static boolean isCorrectAnswer(String userAnswer, int number) {
        return userAnswer.equalsIgnoreCase(getCorrectAnswer(number));
    }
}
