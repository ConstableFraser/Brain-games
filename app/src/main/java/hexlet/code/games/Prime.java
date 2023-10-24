package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static final String PROMPT = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RAND = 103;
    private static String[] correctAnswers;
    private static final Random RAND = new Random();

    public static String getPrompt() {
        return PROMPT;
    }
    public static String[] getQuestions(int rounds) {
        correctAnswers = new String[rounds];
        String[] questions = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            int value = RAND.nextInt(MAX_RAND);
            questions[i] = String.valueOf(value);
            correctAnswers[i] = isPrime(value) ? "yes" : "no";
        }
        return questions;
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
    public static String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
