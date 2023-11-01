package hexlet.code.games;

import org.apache.commons.lang3.ArrayUtils;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Progression {
    private static final String PROMPT = "What number is missing in the progression?";
    private static final int MAX_RAND = 100;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 5;

    public static void playGame() {
        int numberOfRounds = Engine.getNumberOfRounds();
        String[] questions = new String[numberOfRounds];
        String[] answers = new String[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++) {
            questions[i] = String.join(" ", makeQuestion());
            answers[i] = getCorrectAnswer(questions[i]);
        }
        Engine.startEngine(PROMPT, questions, answers);
    }

    public static String getCorrectAnswer(String question) {
        String[] words = question.split(" ");
        // позиция искомого элемента
        int posSecret = ArrayUtils.indexOf(words, "..");
        int delta = 0;
        // получаем значение дельты - разницу между двумя соседними цифрами
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
        int startNumber = randInt(MAX_RAND);
        int stopQuestion = randInt(MAX_LENGTH);
        int step = randInt(1, MAX_STEP);

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
