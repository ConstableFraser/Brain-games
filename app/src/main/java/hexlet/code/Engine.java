package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final String LOSE = """
                                       '%s' is wrong answer ;(. Correct answer was '%s'.
                                       Let's try again, %s!%n
                                       """;
    private static final String WIN = "Congratulations, %s!%n";
    private static final String QUESTION = "Question: ";
    private static final String ANSWER = "Your answer: ";
    private static final String ANSWER_CORRECT = "Correct!";
    private static final int NUMBER_OF_ROUNDS = 3;

    public static void displayQuestion(String value) {
        System.out.println(QUESTION + value);
    }
    public static String displayAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSWER);
        return scanner.next();
    }
    public static void displayResultOfRound(boolean isCorrect,
                                            String userAnswer,
                                            String correctAnswer,
                                            String nameOfUser) {
        if (isCorrect) {
            System.out.println(ANSWER_CORRECT);
        } else {
            System.out.format(LOSE, userAnswer, correctAnswer, nameOfUser);
        }
    }
    public static void displayResultOfGame(String nameOfUser) {
        System.out.format(WIN, nameOfUser);
    }
    public static int getNumberOfRounds() {
        return NUMBER_OF_ROUNDS;
    }
}
