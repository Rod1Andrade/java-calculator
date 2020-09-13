package domain;

import utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classe responsavel por representar o dominio
 * do projeto.
 * <p>
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
     * @return
     */
    public double make(String expression) {

        Stack<Double> stackNumbers = new Stack<>();
        Stack<Character> stackOperations = new Stack<>();

        List<Character> operators = this.listOfOperators(expression);
        String numbers[] = expression.split("[+,\\-,*,/]");

        // index de controle da pilha de operações...
        int operationIndex = 0;
        for(int i = 0; i < numbers.length; i++) {
            // Empilha um número na pilha de números...
            stackNumbers.push(Double.parseDouble(numbers[i]));

            // Se a lista de operações não tiver sido percorrido por completo ...
            if(operationIndex < operators.size()) {
                // Enquanto a pilha não estiver vazia e o operador atual ter a precedência menor que a precedência da pilha, é resolvido primeiro o operador
                // de precedência maior (ou seja o operador da pilha) ...
                while (!stackOperations.isEmpty() && this.precedence(operators.get(operationIndex)) <= this.precedence(stackOperations.peek())) {
                    // Nesse ponto é removido o operador da pilhar de operações
                    // e o número da pilha de números.
                    double result = executeCalc(stackNumbers, stackOperations);
                    // Depois de resolvido o calculo de precedência maior, ele é emiplhado novamente.
                    stackNumbers.push(result);
                }

                // Empilha as operações em cada iteração
                stackOperations.push(operators.get(operationIndex++));
            }
        }

        // Mesmo depois se ainda houver operações a serem feitas
        // Enquanto houber operações deve ser efetuado o calculo...
        while (!stackOperations.isEmpty()) {
            // Nesse ponto é removido o operador da pilhar de operações
            // e o número da pilha de números.
            double result = executeCalc(stackNumbers, stackOperations);

            // Depois de resolvido o calculo de precedência maior, ele é emiplhado novamente.
            stackNumbers.push(result);
        }

        // Por fim é retornado o último elemento que sobra da pilha de números...
        return stackNumbers.pop();
    }

    /**
     * Cria uma lista de operacoes existents
     * @param expression
     * @return
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
     * @param operator
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
     * Executa a operacao
     *
     * @param numbers
     * @param operations
     * @return
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
     * @param character
     * @return
     */
    public boolean isOperator(Character character) {
        return (character.equals('+') || character.equals('-') || character.equals('/') || character.equals('*'));
    }

}
