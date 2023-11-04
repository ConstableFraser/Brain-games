package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class GCD {
    private static final int MAX_RAND = 100;

    public static void playGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int operandA = randInt(1, MAX_RAND);
            int operandB = randInt(1, MAX_RAND);
            questionsAndAnswers[i][0] = String.format("%s %s", operandA, operandB);
            questionsAndAnswers[i][1] = String.valueOf(gcd(operandA, operandB));
        }
        Engine.startEngine("Find the greatest common divisor of given numbers.", questionsAndAnswers);
    }
    private static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }
}
