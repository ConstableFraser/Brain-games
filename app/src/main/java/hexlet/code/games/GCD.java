package hexlet.code.games;

import java.util.Random;

public class GCD {
    private static final String PROMPT = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RAND = 100;
    private static String[] correctAnswers;
    private static final Random RAND = new Random();

    public static String getPrompt() {
        return PROMPT;
    }
    public static String[] getQuestions(int rounds) {
        String[] questions = new String[rounds];
        correctAnswers = new String[rounds];
        int operandA;
        int operandB;

        for (int i = 0; i < rounds; i++) {
            operandA = RAND.nextInt(MAX_RAND);
            operandB = RAND.nextInt(MAX_RAND);
            questions[i] = String.format("%s %s", operandA, operandB);
            correctAnswers[i] = String.valueOf(gcd(operandA, operandB));
        }
        return questions;
    }
    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
    public static String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
