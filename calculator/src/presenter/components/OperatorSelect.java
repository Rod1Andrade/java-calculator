package presenter.components;

import controller.OperatorController;
import domain.Operator;
import enums.Opeators;

import javax.swing.*;
import java.awt.*;

/**
 * OperatorSelect Componente de selecao
 * de operacao
 *
 * @author Rodrigo Andrade
 */
public class OperatorSelect extends JPanel {

    private JComboBox<Operator> operatorSelect;
    private JButton operatorSelectActionButton;

    public OperatorSelect() {
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(5);

        this.init();

        this.setLayout(gridLayout);
        this.add(this.operatorSelect);
        this.add(this.operatorSelectActionButton);
    }

    /**
     * Funcao para iniciar os componentes
     */
    private void init() {
        this.operatorSelect = this.defineOperatorSelect();
        this.operatorSelectActionButton = new JButton("Selecionar Operacao");
    }

    /**
     * Define 'operatorSelect' com seus valores padroes.
     *
     * @return JComboBox
     */
    private JComboBox<Operator> defineOperatorSelect() {
        JComboBox<Operator> comboBox = new JComboBox();
        comboBox.addItem(new Operator("Adição", Opeators.SUM, "+"));
        comboBox.addItem(new Operator("Subtração", Opeators.SUM, "-"));
        comboBox.addItem(new Operator("Multiplicação", Opeators.SUM, "*"));
        comboBox.addItem(new Operator("Divisão", Opeators.SUM, "/"));

        return comboBox;
    }

    public JComboBox<Operator> getOperatorSelect() {
        return operatorSelect;
    }

    public void setOperatorSelect(JComboBox<Operator> operatorSelect) {
        this.operatorSelect = operatorSelect;
    }

    public JButton getOperatorSelectActionButton() {
        return operatorSelectActionButton;
    }

    public void setOperatorSelectActionButton(JButton operatorSelectActionButton) {
        this.operatorSelectActionButton = operatorSelectActionButton;
    }
}
