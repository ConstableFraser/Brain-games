package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Calculator {
    private static final int MAX_RAND = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void playGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            String operator = OPERATORS[randInt(OPERATORS.length)];
            int operandA = randInt(MAX_RAND);
            int operandB = randInt(MAX_RAND);
            questionsAndAnswers[i][0] = String.format("%s %s %s", operandA, operator, operandB);
            questionsAndAnswers[i][1] = String.valueOf(calc(operandA, operandB, operator));
        }
        Engine.startEngine("What is the result of the expression?", questionsAndAnswers);
    }

    public static int calc(int operandA, int operandB, String operator) {
        return switch (operator) {
            case "+" -> operandA + operandB;
            case "-" -> operandA - operandB;
            case "*" -> operandA * operandB;
            default -> 0;
        };
    }
}
