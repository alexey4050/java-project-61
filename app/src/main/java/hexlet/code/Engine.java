package hexlet.code;

import hexlet.code.games.Game;

public class Engine {

    private static final int ROUNDS_COUNTS = 3;

    public static void run(Game game) {
        String userName = Cli.getUserName();
        System.out.println("Hello, " + userName + "!");
        System.out.println(game.getDescription());

        int rounds = 0;
        while (rounds < ROUNDS_COUNTS) {
            String question = game.generateQuestion();
            System.out.println("Question: " + question);
            String userAnswer = Cli.getUserAnswer();

            if (game.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct!");
                rounds++;
            } else {
                String correctAnswer = game.getCorrectAnswer();
                System.out.print("'" + userAnswer + "' is wrong " + "answer ;(. ");
                System.out.println("Correct answer was '" + correctAnswer + "'. ");
                System.out.println("Let;s try again, " + userName + "!");
                break;
            }
        }
        if (rounds == ROUNDS_COUNTS) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
