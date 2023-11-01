package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class GCD {
    private static final String PROMPT = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RAND = 100;

    public static void playGame() {
        int numberOfRounds = Engine.getNumberOfRounds();
        String[] questions = new String[numberOfRounds];
        String[] answers = new String[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++) {
            int operandA = randInt(MAX_RAND);
            int operandB = randInt(1, MAX_RAND);
            questions[i] = String.format("%s %s", operandA, operandB);
            answers[i] = String.valueOf(gcd(operandA, operandB));
        }
        Engine.startEngine(PROMPT, questions, answers);
    }
    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
