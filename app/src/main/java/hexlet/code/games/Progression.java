package hexlet.code.games;

import java.util.Random;

public class Progression {
    private static final String PROMPT = "What number is missing in the progression?";
    private static final int MAX_RAND = 100;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 5;
    private static String[] correctAnswers;
    private static final Random RAND = new Random();

    public static String getPrompt() {
        return PROMPT;
    }
    public static String[] getQuestions(int rounds) {
        String[] questions = new String[rounds];
        correctAnswers = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            questions[i] = makeQuestion(i);
        }
        return questions;
    }
    private static String makeQuestion(int cur) {
        String[] numbers = new String[MAX_LENGTH];
        int curNumber = RAND.nextInt(MAX_RAND);
        int stopQuestion = RAND.nextInt(MAX_LENGTH - 1);
        int step = RAND.nextInt(MAX_STEP);

        while (step == 0) {
            step = RAND.nextInt(MAX_STEP);
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            if (i == stopQuestion) {
                correctAnswers[cur] = String.valueOf(curNumber);
                numbers[i] = "..";
                curNumber += step;
                continue;
            }
            numbers[i] = String.valueOf(curNumber);
            curNumber += step;
        }
        return String.join(" ", numbers);
    }
    public static String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
