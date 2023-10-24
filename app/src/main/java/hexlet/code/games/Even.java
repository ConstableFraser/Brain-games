package hexlet.code.games;

import java.util.Random;

public class Even {
    private static final String PROMPT = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_RAND = 100;
    //private static int value;
    private static String[] correctAnswers;
    private static final Random RAND = new Random();

    public static String getPrompt() {
        return PROMPT;
    }
    public static String[] getQuestions(int rounds) {
        correctAnswers = new String[rounds];
        String[] questions = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            var value = RAND.nextInt(MAX_RAND);
            questions[i] = String.valueOf(value);
            correctAnswers[i] = value % 2 == 0 ? "yes" : "no";
        }
        return questions;
    }
    public static String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
