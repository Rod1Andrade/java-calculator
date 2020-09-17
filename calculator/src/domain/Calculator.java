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
     * @param expression Expressao matematica
     * @return Double - resultado expressao matematica
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
     * @return um valor inteiro que representa a precedencia de
     * operadores matematicos
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
     * @param stackNumbers Pilha de numeros
     * @param stackOperations Pilha de operacoes
     * @return Double sendo o resultado do calculo executado
     * @throws UnsupportedOperationException
     */
    private double executeCalc(Stack<Double> stackNumbers, Stack<Character> stackOperations) {

        double a = stackNumbers.pop();
        double b = stackNumbers.pop();

        char operation = stackOperations.pop();

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
     * @return Verdadaeiro caso seja um dos operadores validos
     */
    public boolean isOperator(Character character) {
        return (character.equals('+') || character.equals('-') || character.equals('/') || character.equals('*'));
    }

}
