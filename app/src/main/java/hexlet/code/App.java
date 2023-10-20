package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.greeting;

public class App {
    private static String nameOfUser;
    private static final int COUNT_SYSTEM_ITEMS = 2;
    //private static final String[] MENU_OF_GAME = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime", "Exit"};
    private static final String[] MENU_OF_GAME = {"Greet", "Even", "Exit"};
    private static final String WELCOME_TEXT = "Please enter the game number and press Enter.";
    private static final String LOSE = """
                                       '%s' is wrong answer ;(. Correct answer was '%s'.
                                       Let's try again, %s!%n
                                       """;
    private static final String WIN = "Congratulations, %s!%n";
    public static void main(String[] args) {
        brainGame();
    }
    private static void printListOfGames() {
        var length = MENU_OF_GAME.length;
        for (int i = 0; i < length - 1; i++) {
            System.out.println(i + 1 + " - " + MENU_OF_GAME[i]);
        }
        System.out.println(0 + " - " + MENU_OF_GAME[length - 1]);
    }

    private static void printResult(String[] result) {
        if (result[0].equals("true")) {
            System.out.format(WIN, nameOfUser);
        } else {
            System.out.format(LOSE, result[1], result[2], nameOfUser);
        }
    }
    private static void brainGame() {
        Scanner scanner = new Scanner(System.in);
        int menuItem;
        Game[] allGames = new Game[]{new EvenGame()};

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

        nameOfUser = greeting();
        var game = allGames[menuItem - COUNT_SYSTEM_ITEMS];
        printResult(game.playGame());
    }
}
