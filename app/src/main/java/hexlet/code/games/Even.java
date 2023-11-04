package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Even {
    private static final int MAX_RAND = 100;

    public static void playGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            int questionValue = randInt(MAX_RAND);
            boolean answerValue = isEven(questionValue);
            questionsAndAnswers[i][0] = String.valueOf(questionValue);
            questionsAndAnswers[i][1] = answerValue ? "yes" : "no";
        }
        Engine.startEngine("Answer 'yes' if the number is even, otherwise answer 'no'.", questionsAndAnswers);
    }
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
