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
            questionsAndAnswers[i][1] = String.valueOf(calc(questionsAndAnswers[i][0]));
        }
        Engine.startEngine("What is the result of the expression?", questionsAndAnswers);
    }

    public static int calc(String question) {
        String[] operators = parseQuestion(question);
        int operandA = Integer.parseInt(operators[0]);
        int operandB = Integer.parseInt(operators[1]);
        String operator = operators[2];
        switch (operator) {
            case "+":
                return operandA + operandB;
            case "-":
                return operandA - operandB;
            case "*":
                return operandA * operandB;
            default:
                return 0;
        }
    }

    private static String[] parseQuestion(String question) {
        String operator = "";
        for (String item : OPERATORS) {
            if (question.contains(item)) {
                operator = item;
                break;
            }
        }
        String[] operators = new String[3];
        operators[0] = question.substring(0, question.indexOf(operator) - 1).trim();
        operators[1] = question.substring(question.indexOf(operator) + 1).trim();
        operators[2] = operator;
        return operators;
    }
}
