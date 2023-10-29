package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final String PROMPT = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RAND = 100;
    private static final Random RAND = new Random();

    public static void playGame(String nameOfUser) {
        System.out.println(PROMPT);
        boolean isCorrect = true;
        int operandA;
        int operandB;

        for (int i = 0; i < Engine.getNumberOfRounds() && isCorrect; i++) {
            operandA = RAND.nextInt(MAX_RAND);
            operandB = RAND.nextInt(MAX_RAND);

            var question = String.format("%s %s", operandA, operandB);
            Engine.displayQuestion(String.valueOf(question));
            String userAnswer = Engine.displayAnswer();
            isCorrect = isCorrectAnswer(userAnswer, operandA, operandB);
            Engine.displayResultOfRound(isCorrect, userAnswer, getCorrectAnswer(operandA, operandB), nameOfUser);
        }
        if (isCorrect) {
            Engine.displayResultOfGame(nameOfUser);
        }
    }
    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
    public static boolean isCorrectAnswer(String userAnswer, int operandA, int operandB) {
        return userAnswer.equals(getCorrectAnswer(operandA, operandB));
    }
    public static String getCorrectAnswer(int operandA, int operandB) {
        return String.valueOf(gcd(operandA, operandB));
    }
}
