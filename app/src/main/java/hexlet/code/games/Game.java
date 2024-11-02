package hexlet.code.games;

public interface Game {

    String getDescription();
    String generateQuestion();
    String getCorrectAnswer();
    boolean isCorrectAnswer(String userAnswer);
}
