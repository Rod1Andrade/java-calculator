package presenter.components;

import javax.swing.*;
import java.awt.*;

/**
 * Painel lateral
 * 
 * @author Rodrigo Andrade
 */
public class SidePanel extends JPanel {

    private JComboBox<String> operatorSelect;
    private JButton operatorSelectActionButton;

    /**
     * Construtor
     */
    public SidePanel() {
        this.setLayout(new BorderLayout());
        this.init();

        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(5);

        JPanel operatorPanel = new JPanel(gridLayout);
        operatorPanel.add(this.operatorSelect);
        operatorPanel.add(this.operatorSelectActionButton);

        this.add(operatorPanel, BorderLayout.NORTH);
    }

    /**
     * Funcao para iniciar os componentes
     */
    private void init() {
        this.operatorSelect = this.defineOperatorSelect();
        this.operatorSelectActionButton = new JButton("Selecionar Operacao");
    }

    /**
     * Intancia uma combox com seus valores pre-definidos.
     *
     * @return JComboBox
     */
    private JComboBox<String> defineOperatorSelect() {
        JComboBox<String> comboBox = new JComboBox();
        comboBox.addItem("Adicao");
        comboBox.addItem("Subtracao");
        comboBox.addItem("Divisao");
        comboBox.addItem("Multiplicacao");

        return comboBox;
    }
}
