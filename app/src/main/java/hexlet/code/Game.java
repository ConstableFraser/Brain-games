package hexlet.code;

public interface Game {
    void printPrompt();
    String getQuestion();
    Boolean isCorrectAnswer(String answer);
    String getCorrectAnswer();
}
