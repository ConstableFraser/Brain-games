package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.greeting;

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

    public static void startEngine(String prompt, String[] questions, String[] answers) {
        String userName = greeting();
        System.out.println(prompt);
        boolean isCorrect = true;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUMBER_OF_ROUNDS && isCorrect; i++) {
            String userAnswer;
            System.out.println(QUESTION + questions[i]);
            userAnswer = scanner.next();
            System.out.println(ANSWER + userAnswer);
            isCorrect = userAnswer.equals(answers[i]);
            if (isCorrect) {
                System.out.println(ANSWER_CORRECT);
            } else {
                System.out.format(LOSE, userAnswer, answers[i], userName);
            }
        }
        if (isCorrect) {
            System.out.format(WIN, userName);
        }
    }
    public static int getNumberOfRounds() {
        return NUMBER_OF_ROUNDS;
    }
}
