package hexlet.code.games;

import hexlet.code.Game;

import java.util.Random;

public class Calculator implements Game {
    private static final String PROMPT = "What is the result of the expression?";
    private static final int MAX_RAND = 100;
    private final String[] operators = {"+", "-", "*"};
    private String operator;
    private int operandA;
    private int operandB;
    private int correctAnswer;
    private final Random rand;

    public Calculator() {
        System.out.println(PROMPT);
        this.rand = new Random();
    }
    public void printPrompt() {
        System.out.println(PROMPT);
    }
    public String getQuestion() {
        this.operator = operators[rand.nextInt(operators.length)];
        this.operandA = rand.nextInt(MAX_RAND);
        this.operandB = rand.nextInt(MAX_RAND);

        return String.format("%s %s %s", operandA, operator, operandB);
    }
    public Boolean isCorrectAnswer(String answer) {
        int result;
        switch (operator) {
            case "+":
                result = operandA + operandB;
                break;
            case "-":
                result = operandA - operandB;
                break;
            case "*":
                result = operandA * operandB;
                break;
            default:
                return null;
        }
        this.correctAnswer = result;
        return String.valueOf(result).equals(answer);
    }
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}
