package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame implements Game {
    private static final String PROMPT = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public String[] playGame() {
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        String answerOfUser;
        int randomValue;

        System.out.println(PROMPT);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            randomValue = ran.nextInt(100);
            System.out.println(QUESTION + randomValue);
            System.out.print(ANSWER);
            answerOfUser = scanner.next();
            if (answerOfUser.equals("no") && (randomValue % 2 == 0)) {
                return new String[]{"false", "no", "yes"};
            } else if (!answerOfUser.equals("yes") && !answerOfUser.equals("no")) {
                var answer = randomValue % 2 == 0 ? "yes" : "no";
                return new String[]{"false", answerOfUser, answer};
            } else if (answerOfUser.equals("yes") && (randomValue % 2 != 0)) {
                return new String[]{"false", "yes", "no"};
            }
        }
        return new String[]{"true", "yes", "yes"};
    }
}
