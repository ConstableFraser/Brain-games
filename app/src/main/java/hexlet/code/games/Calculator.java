package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calculator {
    private static final String PROMPT = "What is the result of the expression?";
    private static final int MAX_RAND = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final Random RAND = new Random();

    public static void playGame(String nameOfUser) {
        String operator;
        int operandA;
        int operandB;
        String correctAnswer;
        System.out.println(PROMPT);
        boolean isCorrect = true;

        for (int i = 0; i < Engine.getNumberOfRounds() && isCorrect; i++) {
            operator = OPERATORS[RAND.nextInt(OPERATORS.length)];
            operandA = RAND.nextInt(MAX_RAND);
            operandB = RAND.nextInt(MAX_RAND);
            switch (operator) {
                case "+":
                    correctAnswer = String.valueOf(operandA + operandB);
                    break;
                case "-":
                    correctAnswer = String.valueOf(operandA - operandB);
                    break;
                case "*":
                    correctAnswer = String.valueOf(operandA * operandB);
                    break;
                default:
                    break;
            }

            var question = String.format("%s %s %s", operandA, operator, operandB);
            Engine.displayQuestion(String.valueOf(question));
            String userAnswer = Engine.displayAnswer();
            isCorrect = isCorrectAnswer(userAnswer, operandA, operandB, operator);
            Engine.displayResultOfRound(isCorrect,
                                        userAnswer,
                                        getCorrectAnswer(operandA, operandB, operator),
                                        nameOfUser);
        }
        if (isCorrect) {
            Engine.displayResultOfGame(nameOfUser);
        }
    }
    public static boolean isCorrectAnswer(String userAnswer, int operandA, int operandB, String operator) {
        return userAnswer.equals(getCorrectAnswer(operandA, operandB, operator));
    }
    public static String getCorrectAnswer(int operandA, int operandB, String operator) {
        String correctAnswer = "";

        switch (operator) {
            case "+":
                correctAnswer = String.valueOf(operandA + operandB);
                break;
            case "-":
                correctAnswer = String.valueOf(operandA - operandB);
                break;
            case "*":
                correctAnswer = String.valueOf(operandA * operandB);
                break;
            default:
                break;
        }
        return correctAnswer;
    }
}
