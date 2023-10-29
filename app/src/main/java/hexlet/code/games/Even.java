package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    private static final String PROMPT = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_RAND = 100;
    //private static int value;
    private static final Random RAND = new Random();

    public static void playGame(String nameOfUser) {
        System.out.println(PROMPT);
        boolean isCorrect = true;

        for (int i = 0; i < Engine.getNumberOfRounds() && isCorrect; i++) {
            int questionValue = RAND.nextInt(MAX_RAND);
            Engine.displayQuestion(String.valueOf(questionValue));
            String userAnswer = Engine.displayAnswer();
            isCorrect = isCorrectAnswer(userAnswer, questionValue);
            Engine.displayResultOfRound(isCorrect, userAnswer, getCorrectAnswer(questionValue), nameOfUser);
        }
        if (isCorrect) {
            Engine.displayResultOfGame(nameOfUser);
        }
    }
    public static boolean isCorrectAnswer(String userAnswer, int questionValue) {
        return userAnswer.equals(getCorrectAnswer(questionValue));
    }
    public static String getCorrectAnswer(int questionValue) {
        return questionValue % 2 == 0 ? "yes" : "no";
    }
}
