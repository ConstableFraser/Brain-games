package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Progression {
    private static final int MAX_RAND = 100;
    private static final int MAX_LENGTH = 11;
    private static final int MAX_STEP = 5;
    private static final int MIN_LENGTH = 5;
    private static int indexOfSecretQuestion;

    public static void playGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            String[] question = makeQuestion(randInt(MIN_LENGTH, MAX_LENGTH), randInt(1, MAX_STEP), randInt(MAX_RAND));
            indexOfSecretQuestion = randInt(1, question.length);
            question[indexOfSecretQuestion] = "..";
            questionsAndAnswers[i][0] = String.join(" ", question);
            questionsAndAnswers[i][1] = getCorrectAnswer(questionsAndAnswers[i][0]);
        }
        Engine.startEngine("What number is missing in the progression?", questionsAndAnswers);
    }

    public static String getCorrectAnswer(String question) {
        String[] words = question.split(" ");
        int delta = 0;
        // получаем значение дельты - разницу между двумя соседними цифрами
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals("..") || words[i + 1].equals("..")) {
                continue;
            }
            delta = Integer.parseInt(words[i + 1]) - Integer.parseInt(words[i]);
        }
        // находим искомое значение
        int result = indexOfSecretQuestion == 0 ? Integer.parseInt(words[1]) - delta
                                      : Integer.parseInt(words[indexOfSecretQuestion - 1]) + delta;
        return String.valueOf(result);
    }

    private static String[] makeQuestion(int sizeOfProgression, int step, int startNumber) {
        String[] numbers = new String[sizeOfProgression];

        for (int i = 0; i < sizeOfProgression; i++) {
            numbers[i] = String.valueOf(startNumber);
            startNumber += step;
        }
        return numbers;
    }
}
