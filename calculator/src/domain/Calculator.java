package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classe responsavel por representar o dominio
 * do projeto.
 *
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
     * Faz o calculo da expressao passada como argumento.
     *
     * @param expresion String
     * @return Double resultado
     */
    public double make(String expresion) {

        Stack<Double> values = new Stack<>();
        String[] numbers = prepareNumbers(expresion);
        List<Character> simbols = prepareSimbols(expresion);

        if(numbers.length == 1) {
            return Double.parseDouble(numbers[0]);
        }

        int index = 0;
        for (String number : numbers) {
            char simbol = simbols.get(index);
            double numberParsed = Double.parseDouble(number);
            double numberPeek;
            double numberPop;

            if(values.isEmpty()) {
                values.push(numberParsed);
                continue;
            }

            if(simbol == '+') {
                numberPeek = values.peek();
                values.push(numberParsed);
                values.push(numberPeek + numberParsed);
                index++;
            }

            if(simbol == '-') {
                numberPeek = values.peek();
                values.push(numberParsed);
                values.push(numberPeek - numberParsed);
                index++;
            }

            if(simbol == '*') {
                numberPop = values.pop();
                values.push(numberPop * numberParsed);
                index++;
            }

            if(simbol == '/') {
                numberPop = values.pop();
                values.push(numberPop / numberParsed);
                index++;
            }
        }

        return values.peek();
    }

    /**
     * Prepara o simbolos matematicos
     *
     * @param expresion String
     * @return Char[]
     */
    private List<Character> prepareSimbols(String expresion) {
        List<Character> simbols = new ArrayList<>();
        for (char c : expresion.toCharArray()) {
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                simbols.add(c);
            }
        }
        return simbols;
    }

    /**
     * Prepara os numeros
     *
     * @param expresion Strings
     * @return Double[]
     */
    private String[] prepareNumbers(String expresion) {
        String numbers[] = expresion.split("[+,\\-,*,/]");
        return numbers;
    }

}
