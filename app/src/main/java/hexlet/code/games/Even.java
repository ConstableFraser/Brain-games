package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Even {
    private static final String PROMPT = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_RAND = 100;

    public static void playGame() {
        int numberOfRounds = Engine.getNumberOfRounds();
        String[] questions = new String[numberOfRounds];
        String[] answers = new String[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++) {
            int questionValue = randInt(MAX_RAND);
            boolean answerValue = isEven(questionValue);
            questions[i] = String.valueOf(questionValue);
            answers[i] = answerValue ? "yes" : "no";
        }
        Engine.startEngine(PROMPT, questions, answers);
    }
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
