package hexlet.code.games;

import java.util.Random;

public class Calculator {
    private static final String PROMPT = "What is the result of the expression?";
    private static final int MAX_RAND = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static String[] correctAnswers;
    private static final Random RAND = new Random();

    public static String getPrompt() {
        return PROMPT;
    }
    public static String[] getQuestions(int rounds) {
        String[] questions = new String[rounds];
        correctAnswers = new String[rounds];
        String operator;
        int operandA;
        int operandB;

        for (int i = 0; i < rounds; i++) {
            operator = OPERATORS[RAND.nextInt(OPERATORS.length)];
            operandA = RAND.nextInt(MAX_RAND);
            operandB = RAND.nextInt(MAX_RAND);
            questions[i] = String.format("%s %s %s", operandA, operator, operandB);

            switch (operator) {
                case "+":
                    correctAnswers[i] = String.valueOf(operandA + operandB);
                    break;
                case "-":
                    correctAnswers[i] = String.valueOf(operandA - operandB);
                    break;
                case "*":
                    correctAnswers[i] = String.valueOf(operandA * operandB);
                    break;
                default:
                    return null;
            }
        }
        return questions;
    }
    public static String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
