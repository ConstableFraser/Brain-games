package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;

public class EvenGame implements Game {
    private static final String PROMPT = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_RAND = 100;
    private int value;
    private String correctAnswer;
    private final Random rand;

    public EvenGame() {
        this.rand = new Random();
    }
    public void printPrompt() {
        System.out.println(PROMPT);
    }
    public String getQuestion() {
        this.value = rand.nextInt(MAX_RAND);
        return String.valueOf(this.value);
    }
    public Boolean isCorrectAnswer(String answer) {
        if (this.value % 2 == 0) {
            this.correctAnswer = "yes";
            return answer.equals("yes");
        }
        this.correctAnswer = "no";
        return answer.equals("no");
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
