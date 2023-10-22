package hexlet.code.games;

import java.util.Random;

import hexlet.code.Game;
public class Progression implements Game {
    private static final String PROMPT = "What number is missing in the progression?";
    private static final int MAX_RAND = 100;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 5;
    private final String[] numbers = new String[MAX_LENGTH];
    private int correctAnswer;
    private final Random rand;

    public Progression() {
        System.out.println(PROMPT);
        this.rand = new Random();
    }
    public void printPrompt() {
        System.out.println(PROMPT);
    }
    public String getQuestion() {
        int curNumber = rand.nextInt(MAX_RAND);
        int stopQuestion = rand.nextInt(MAX_LENGTH - 1);
        int step = rand.nextInt(MAX_STEP);
        while (step == 0) {
            step = rand.nextInt(MAX_STEP);
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            if (i == stopQuestion) {
                this.correctAnswer = curNumber;
                numbers[i] = "..";
                curNumber += step;
                continue;
            }
            numbers[i] = String.valueOf(curNumber);
            curNumber += step;
        }

        return String.join(" ", numbers);
    }
    public Boolean isCorrectAnswer(String answer) {
        return String.valueOf(correctAnswer).equals(answer);
    }
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}
