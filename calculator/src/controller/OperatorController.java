package controller;

import domain.Operator;
import presenter.components.OperatorSelect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller das operacoes
 *
 * @author Rodrigo Andrade
 */
public class OperatorController implements ActionListener {

    private final ResultController resultController;
    private final JComboBox<Operator> comboBox;

    /**
     * Construtor
     * @param resultController Controller do Result
     * @param comboBox ComboBox com as opcoes de operacoes
     */
    public OperatorController(ResultController resultController, JComboBox<Operator> comboBox) {
        this.resultController = resultController;
        this.comboBox = comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Operator operator = (Operator) this.comboBox.getSelectedItem();
        this.resultController.concatValue(operator.getSimbol());
        this.resultController.changeLabel();
    }
}
