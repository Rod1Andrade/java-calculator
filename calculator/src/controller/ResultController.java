package controller;

import domain.Calculator;
import presenter.components.Result;
import utils.Constants;

import javax.swing.*;

/**
 * Controller do componente 'Result'
 *
 * @author Rodrigo Andrade
 */
public class ResultController {

    private final Result result;
    private String value;

    /**
     * Construtor
     * @param result Componente Result
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
     * @param value Valor a ser concatenado
     */
    public void concatValue(String value) {
        if(this.value.trim().equals(Constants.DEFAULT_VALUE)) {
            this.value = value;
        } else {
            this.value += value;
        }
    }

    /**
     * Deleta o ultimo valor
     */
    public void deleteValue() {
        if(this.value.length() > 0 && !this.value.trim().equals(Constants.DEFAULT_VALUE)) {
            char lastChar = this.value.charAt(this.value.length() - 1);
            int lastIndex = this.value.lastIndexOf(lastChar);

            this.value = this.value.substring(0, lastIndex);
        }

        if (this.value.isEmpty()) {
            this.value = Constants.DEFAULT_VALUE;
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
