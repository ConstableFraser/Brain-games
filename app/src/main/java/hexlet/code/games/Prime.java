package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final String PROMPT = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RAND = 150;
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
        return isPrime(questionValue) ? "yes" : "no";
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
