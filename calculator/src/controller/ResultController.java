package controller;

import presenter.components.Result;

import javax.swing.*;

/**
 * Controller do componente Result
 *
 * @author Rodrigo Andrade
 */
public class ResultController {

    private JLabel label;
    private String value;

    /**
     * Construtor
     * @param label
     */
    public ResultController(JLabel label) {
        this.label = label;
        this.value = "";
    }

    /**
     * Define um texto para a label
     */
    public void changeLabel() {
        if(this.label != null) {
            this.label.setText(value);
        }
    }

    /**
     * Concatena o valor
     * @param value
     */
    public void concatValue(String value) {

        if(this.value.isEmpty()) {
            this.label.setText("");
        }

        this.value += value;
    }

    /**
     * Deleta o ultimo valor
     */
    public void deleteValue() {
        if(this.value.length() > 0) {
            char lastChar = this.value.charAt(this.value.length() - 1);
            int lastIndex = this.value.lastIndexOf(lastChar);

            String substring = this.value.substring(0, lastIndex);
            this.value = substring;
        }
    }
}
