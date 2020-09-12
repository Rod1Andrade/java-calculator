package controller;

import presenter.components.Result;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contoller do componente Button
 *
 * @author Rodrigo Andrade
 */
public class ButtonController implements ActionListener {

    private ResultController resultController;

    /**
     * Construtor
     * @param resultController
     */
    public ButtonController(ResultController resultController) {
        this.resultController = resultController;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();

        if(button.getText().equals("Deletar")) {
            this.resultController.deleteValue();
        } else {
            this.resultController.concatValue(button.getText());
        }

        this.resultController.changeLabel();

    }
}
