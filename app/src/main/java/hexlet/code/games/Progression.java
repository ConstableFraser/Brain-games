package hexlet.code.games;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;

import hexlet.code.Engine;


public class Progression {
    private static final String PROMPT = "What number is missing in the progression?";
    private static final int MAX_RAND = 100;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 5;
    private static final Random RAND = new Random();

    public static void playGame(String nameOfUser) {
        boolean isCorrect = true;
        System.out.println(PROMPT);

        for (int i = 0; i < Engine.getNumberOfRounds() && isCorrect; i++) {
            String question = String.join(" ", makeQuestion());
            Engine.displayQuestion(question);
            String userAnswer = Engine.displayAnswer();
            isCorrect = isCorrectAnswer(userAnswer, question);
            Engine.displayResultOfRound(isCorrect, userAnswer, getCorrectAnswer(question), nameOfUser);
        }
        if (isCorrect) {
            Engine.displayResultOfGame(nameOfUser);
        }
    }

    public static boolean isCorrectAnswer(String userAnswer, String question) {
        return userAnswer.equals(getCorrectAnswer(question));
    }

    public static String getCorrectAnswer(String question) {
        String[] words = question.split(" ");
        // позиция искомого элемента
        int posSecret = ArrayUtils.indexOf(words, "..");
        int delta = 0;
        // узнаём значение дельты - разницы между двумя соседними цифрами
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals("..") || words[i + 1].equals("..")) {
                continue;
            }
            delta = Integer.parseInt(words[i + 1]) - Integer.parseInt(words[i]);
        }
        // находим искомое значение
        int result = posSecret == 0 ? Integer.parseInt(words[1]) - delta
                                      : Integer.parseInt(words[posSecret - 1]) + delta;
        return String.valueOf(result);
    }

    private static String[] makeQuestion() {
        String[] numbers = new String[MAX_LENGTH];
        int startNumber = RAND.nextInt(MAX_RAND);
        int stopQuestion = RAND.nextInt(MAX_LENGTH);
        int step = RAND.nextInt(MAX_STEP);

        while (step == 0) {
            step = RAND.nextInt(MAX_STEP);
        }

        for (int i = 0; i < MAX_LENGTH; i++) {
            if (i == stopQuestion) {
                numbers[i] = "..";
                startNumber += step;
                continue;
            }
            numbers[i] = String.valueOf(startNumber);
            startNumber += step;
        }
        return numbers;
    }
}
