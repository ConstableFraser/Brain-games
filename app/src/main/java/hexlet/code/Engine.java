package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Progression;
import hexlet.code.games.Calculator;
import hexlet.code.games.Prime;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import static hexlet.code.Cli.greeting;
public class Engine {
    private static final String[] MENU_OF_GAME = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime", "Exit"};
    private static final String WELCOME_TEXT = "Please enter the game number and press Enter.";
    private static final String LOSE = """
                                       '%s' is wrong answer ;(. Correct answer was '%s'.
                                       Let's try again, %s!%n
                                       """;
    private static final String WIN = "Congratulations, %s!%n";
    private static final String QUESTION = "Question: ";
    private static final String ANSWER = "Your answer: ";
    private static final String ANSWER_CORRECT = "Correct!";
    private static final int NUMBER_OF_ROUNDS = 3;
    private static final int EXIT = 0;
    private static final int GREETING = 1;
    private static final int EVEN = 2;
    private static final int CALCULATOR = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;


    public static void startEngine() {
        Scanner scanner = new Scanner(System.in);
        int menuItem;

        System.out.println(WELCOME_TEXT);
        printListOfGames();
        menuItem = scanner.nextInt();
        System.out.println("Your choice: " + menuItem);

        String[] questions = ;
        String[] answers;
        String prompt;

        switch (menuItem) {
            case GREETING:
                greeting();
                return;
            case EVEN:
                prompt = Even.getPrompt();
                questions = Even.getQuestions(NUMBER_OF_ROUNDS);
                answers = Even.getCorrectAnswers();
                break;
            case CALCULATOR:
                prompt = Calculator.getPrompt();
                questions = Calculator.getQuestions(NUMBER_OF_ROUNDS);
                answers = Calculator.getCorrectAnswers();
                break;
            case GCD:
                prompt = GCD.getPrompt();
                questions = GCD.getQuestions(NUMBER_OF_ROUNDS);
                answers = GCD.getCorrectAnswers();
                break;
            case PROGRESSION:
                prompt = Progression.getPrompt();
                questions = Progression.getQuestions(NUMBER_OF_ROUNDS);
                answers = Progression.getCorrectAnswers();
                break;
            case PRIME:
                prompt = Prime.getPrompt();
                questions = Prime.getQuestions(NUMBER_OF_ROUNDS);
                answers = Prime.getCorrectAnswers();
                break;
            case EXIT:
            default:
                return;
        }

        String nameOfUser = greeting();
        System.out.println(prompt);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            System.out.println(QUESTION + questions[i]);
            System.out.print(ANSWER);
            var answerOfUser = scanner.next();
            if (!answerOfUser.equals(answers[i])) {
                System.out.format(LOSE, answerOfUser, answers[i], nameOfUser);
                return;
            }
            System.out.println(ANSWER_CORRECT);
        }
        System.out.format(WIN, nameOfUser);
    }

    private static void printListOfGames() {
        var length = MENU_OF_GAME.length;
        for (int i = 0; i < length - 1; i++) {
            System.out.println(i + 1 + " - " + MENU_OF_GAME[i]);
        }
        System.out.println(0 + " - " + MENU_OF_GAME[length - 1]);
    }
}
