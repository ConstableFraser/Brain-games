package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Prime {
    private static final int MAX_RAND = 150;

    public static void playGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int questionValue = randInt(MAX_RAND);
            boolean answerValue = isPrime(questionValue);
            questionsAndAnswers[i][0] = String.valueOf(questionValue);
            questionsAndAnswers[i][1] = answerValue ? "yes" : "no";
        }
        Engine.startEngine("Answer 'yes' if given number is prime. Otherwise answer 'no'.", questionsAndAnswers);
    }
    public static Boolean isPrime(int value) {
        if (value == 1) {
            return false;
        }
        for (int i = 1; i < value - 1; i++) {
            if (value % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
