package hexlet.code.games;

import java.util.Random;

import hexlet.code.Game;

public class GCD implements Game {
    private static final String PROMPT = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RAND = 100;
    private int operandA;
    private int operandB;
    private int correctAnswer;
    private final Random rand;

    public GCD() {
        System.out.println(PROMPT);
        this.rand = new Random();
    }
    public void printPrompt() {
        System.out.println(PROMPT);
    }
    public String getQuestion() {
        this.operandA = rand.nextInt(MAX_RAND);
        this.operandB = rand.nextInt(MAX_RAND);

        return String.format("%s %s", operandA, operandB);
    }
    public Boolean isCorrectAnswer(String answer) {
        int result = gcd(operandA, operandB);
        this.correctAnswer = result;
        return String.valueOf(result).equals(answer);
    }
    private int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}
