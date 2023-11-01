package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Prime {
    private static final String PROMPT = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RAND = 150;

    public static void playGame() {
        int numberOfRounds = Engine.getNumberOfRounds();
        String[] questions = new String[numberOfRounds];
        String[] answers = new String[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++) {
            int questionValue = randInt(MAX_RAND);
            boolean answerValue = isPrime(questionValue);
            questions[i] = String.valueOf(questionValue);
            answers[i] = answerValue ? "yes" : "no";
        }
        Engine.startEngine(PROMPT, questions, answers);
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
