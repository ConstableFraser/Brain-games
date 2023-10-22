package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Progression;
import hexlet.code.games.Calculator;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;

import static hexlet.code.Cli.greeting;
public class Engine {
    private static final int COUNT_SYSTEM_ITEMS = 2;
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


    public static void startEngine() {
        Scanner scanner = new Scanner(System.in);
        int menuItem;
        Game[] allGames = new Game[]{new EvenGame(), new Calculator(), new GCD(), new Progression(), new Prime()};

        System.out.println(WELCOME_TEXT);
        printListOfGames();
        menuItem = scanner.nextInt();
        System.out.println("Your choice: " + menuItem);

        if (menuItem - COUNT_SYSTEM_ITEMS > allGames.length || menuItem <= 0) {
            return;
        }

        if (menuItem == 1) {
            greeting();
            return;
        }

        String nameOfUser = greeting();
        var game = allGames[menuItem - COUNT_SYSTEM_ITEMS];
        game.printPrompt();

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            var value = game.getQuestion();
            System.out.println(QUESTION + value);
            System.out.print(ANSWER);
            var answerOfUser = scanner.next();
            if (!game.isCorrectAnswer(answerOfUser)) {
                var correctAnswer = game.getCorrectAnswer();
                System.out.format(LOSE, answerOfUser, correctAnswer, nameOfUser);
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
