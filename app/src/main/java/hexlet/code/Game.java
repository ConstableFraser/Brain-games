package hexlet.code;

public interface Game {
    String QUESTION = "Question: ";
    String ANSWER = "Your answer: ";
    String ANSWER_CORRECT = "Correct!";
    int NUMBER_OF_ROUNDS = 3;

    String[] playGame();
}
