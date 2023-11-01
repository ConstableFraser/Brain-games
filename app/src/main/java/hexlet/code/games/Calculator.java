package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.randInt;

public class Calculator {
    private static final String PROMPT = "What is the result of the expression?";
    private static final int MAX_RAND = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void playGame() {
        int numberOfRounds = Engine.getNumberOfRounds();
        String[] questions = new String[numberOfRounds];
        String[] answers = new String[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++) {
            String operator = OPERATORS[randInt(OPERATORS.length)];
            int operandA = randInt(MAX_RAND);
            int operandB = randInt(MAX_RAND);
            questions[i] = String.format("%s %s %s", operandA, operator, operandB);
            answers[i] = String.valueOf(calc(questions[i]));
        }
        Engine.startEngine(PROMPT, questions, answers);
    }

    public static int calc(String question) {
        String operator = "";
        for (String item : OPERATORS) {
            if (question.contains(item)) {
                operator = item;
                break;
            }
        }
        String[] operators = new String[2];
        operators[0] = question.substring(0, question.indexOf(operator) - 1);
        operators[1] = question.substring(question.indexOf(operator) + 1);
        int value;
        switch (operator) {
            case "+":
                value = Integer.parseInt(operators[0].trim()) + Integer.parseInt(operators[1].trim());
                return value;
            case "-":
                value = Integer.parseInt(operators[0].trim()) - Integer.parseInt(operators[1].trim());
                return value;
            case "*":
                value = Integer.parseInt(operators[0].trim()) * Integer.parseInt(operators[1].trim());
                return value;
            default:
                return 0;
        }
    }
}
