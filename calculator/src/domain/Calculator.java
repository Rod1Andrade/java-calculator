package domain;

import utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classe responsavel por representar o dominio
 * do projeto.
 * Classe calculadora.
 *
 * @author Rodrigo Andrade
 */
public class Calculator {

    /**
     * Fabrica uma instancia de calculator
     *
     * @return Calculator
     */
    public static Calculator factoryCalculatorIntance() {
        return new Calculator();
    }

    /**
     * Faz o cálculo baseado na expressão passada como argumento.
     *
     * @param expression
     * @return Double
     */
    public double make(String expression) {

        Stack<Double> stackNumbers = new Stack<>();
        Stack<Character> stackOperations = new Stack<>();

        List<Character> operators = this.listOfOperators(expression);
        String numbers[] = expression.split("[+,\\-,*,/]");

        int operationIndex = 0;

        for(int i = 0; i < numbers.length; i++) {

            stackNumbers.push(Double.parseDouble(numbers[i]));

            if(operationIndex < operators.size()) {

                while (!stackOperations.isEmpty() && this.precedence(operators.get(operationIndex)) <= this.precedence(stackOperations.peek())) {
                    double result = executeCalc(stackNumbers, stackOperations);
                    stackNumbers.push(result);
                }

                stackOperations.push(operators.get(operationIndex++));
            }
        }

        while (!stackOperations.isEmpty()) {
            double result = executeCalc(stackNumbers, stackOperations);
            stackNumbers.push(result);
        }

        return stackNumbers.pop();
    }

    /**
     * Cria uma lista de operacoes existentes
     * @param expression Expressao
     * @return List
     */
    private List<Character> listOfOperators(String expression) {
        List<Character> list = new ArrayList<>();
        for (Character operator: expression.toCharArray()) {
            if(isOperator(operator)) {
                list.add(operator);
            }
        }
        return list;
    }

    /**
     * Avalia a precedencia
     *
     * @param operator Operador
     * @return
     */
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    /**
     * Executa o calculo com base na operacao.
     *
     * @param numbers Pilha de numeros
     * @param operations Pilha de operacoes
     * @return Double
     * @throws UnsupportedOperationException
     */
    private double executeCalc(Stack<Double> numbers, Stack<Character> operations) {

        // Desempilha dois números da pilha
        double a = numbers.pop();
        double b = numbers.pop();

        // Desempilha a operação
        char operation = operations.pop();

        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException(Constants.DIVISION_BY_ZERO);
                return b / a;
        }
        return 0;
    }

    /**
     * Verifica se o caracter é uma operacao
     *
     * @param character Caracter a ser verificado
     * @return
     */
    public boolean isOperator(Character character) {
        return (character.equals('+') || character.equals('-') || character.equals('/') || character.equals('*'));
    }

}
