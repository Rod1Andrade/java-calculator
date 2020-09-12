package controller;

import domain.Calculator;
import presenter.components.Result;

import javax.swing.*;

/**
 * Controller do componente 'Result'
 *
 * @author Rodrigo Andrade
 */
public class ResultController {

    private Result result;
    private String value;

    /**
     * Construtor
     * @param result
     */
    public ResultController(Result result) {
        this.result = result;
        this.value = "";
    }

    /**
     * Aplica a mudanca na label
     */
    public void changeLabel() {
        if(this.result != null) {
            JLabel label = this.result.getResultLabel();
            label.setText(this.value);
        }
    }

    /**
     * Concatena o valor
     * @param value
     */
    public void concatValue(String value) {
        if(this.value.trim().equals(Result.DEFAULT_VALUE)) {
            this.value = value;
        } else {
            this.value += value;
        }
    }

    /**
     * Deleta o ultimo valor
     */
    public void deleteValue() {
        if(this.value.length() > 0 && !this.value.trim().equals(Result.DEFAULT_VALUE)) {
            char lastChar = this.value.charAt(this.value.length() - 1);
            int lastIndex = this.value.lastIndexOf(lastChar);

            String substring = this.value.substring(0, lastIndex);
            this.value = substring;
        }

        if (this.value.isEmpty()) {
            this.value = Result.DEFAULT_VALUE;
        }
    }

    /**
     * Aplica a expressao a uma funcao
     * para obter o resultado
     */
    public void makeResult() {
        Calculator calculator = Calculator.factoryCalculatorIntance();

        double result = calculator.make(this.value);
        this.value = String.valueOf(result);
    }
}
