package presenter.components;

import domain.Operator;
import enums.Opeators;
import utils.Constants;
import utils.MouseHover;
import utils.ResetButtonModel;

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
        this.setBackground(Color.DARK_GRAY);

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
        operatorSelectInit();
        actionButtonInit();
    }

    /**
     * Define como o comboBox de selecao unica
     * deve ser iniciado.
     */
    private void operatorSelectInit() {
        this.operatorSelect = this.defineOperatorSelect();
        this.operatorSelect.setBackground(Color.BLACK);
        this.operatorSelect.setForeground(Color.WHITE);
    }

    /**
     * Define os valores a serem iniciados no botao de acao.
     */
    private void actionButtonInit() {
        this.operatorSelectActionButton = new JButton(Constants.SELECT_OPERATION);
        this.operatorSelectActionButton.setBackground(Color.BLACK);
        this.operatorSelectActionButton.setForeground(Color.WHITE);
        this.operatorSelectActionButton.setFocusPainted(false);
        this.operatorSelectActionButton.setBorderPainted(false);
        this.operatorSelectActionButton.setModel(new ResetButtonModel());
        this.operatorSelectActionButton.addMouseListener(
                new MouseHover(this.operatorSelectActionButton, new Color(13, 13, 13))
        );
    }

    /**
     * Define 'operatorSelect' com seus valores padroes.
     *
     * @return JComboBox
     */
    private JComboBox<Operator> defineOperatorSelect() {
        JComboBox<Operator> comboBox = new JComboBox<>();
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
