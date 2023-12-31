package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_ROUNDS = 3;

    public static void startEngine(String prompt, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        if (questionsAndAnswers.length == 0) {
            return;
        }
        System.out.println(prompt);
        boolean isCorrect = true;

        for (int i = 0; i < NUMBER_OF_ROUNDS && isCorrect; i++) {
            String userAnswer;
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            userAnswer = scanner.next();
            System.out.println("Your answer: " + userAnswer);
            isCorrect = userAnswer.equals(questionsAndAnswers[i][1]);
            if (!isCorrect) {
                System.out.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!%n",
                        userAnswer, questionsAndAnswers[i][1], userName);
                return;
            }
            System.out.println("Correct!");
        }
        System.out.format("Congratulations, %s!%n", userName);
    }
}
