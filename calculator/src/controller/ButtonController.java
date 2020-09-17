package controller;

import utils.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contoller do componente Button
 *
 * @author Rodrigo Andrade
 */
public class ButtonController implements ActionListener {

    private final ResultController resultController;

    /**
     * Construtor
     * @param resultController Controller do Result
     */
    public ButtonController(ResultController resultController) {
        this.resultController = resultController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();

        if(button.getText().equals("Deletar")) {
            this.resultController.deleteLastValue();
        } else if(button.getText().equals(Constants.RESULT_VALUE)) {
            this.resultController.makeResult();
        } else {
            this.resultController.concatValue(button.getText());
        }

        this.resultController.changeLabel();
    }
}
