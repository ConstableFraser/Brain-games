package hexlet.code.games;

import java.util.Random;

import hexlet.code.Game;
public class Prime implements Game {
    private static final String PROMPT = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RAND = 103;
    private String correctAnswer;
    private int number;
    private final Random rand;

    public Prime() {
        System.out.println(PROMPT);
        this.rand = new Random();
    }
    public void printPrompt() {
        System.out.println(PROMPT);
    }
    public String getQuestion() {
        this.number = rand.nextInt(MAX_RAND);
        return String.valueOf(number);
    }
    public Boolean isCorrectAnswer(String answer) {
        if (number == 1) {
            this.correctAnswer = "no";
            return answer.equals("no");
        }
        for (int i = 1; i < number - 1; i++) {
            if (number % (i + 1) == 0) {
                this.correctAnswer = "no";
                return answer.equals("no");
            }
        }
        return answer.equals("yes");
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
