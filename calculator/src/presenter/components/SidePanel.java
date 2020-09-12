package presenter.components;

import javax.swing.*;
import java.awt.*;

/**
 * Painel lateral com o seletor de operacoes
 * e o botao de resultado.
 * 
 * @author Rodrigo Andrade
 */
public class SidePanel extends JPanel {

    private OperatorSelect operatorSelect;
    private JButton resultButton;

    /**
     * Construtor
     */
    public SidePanel(OperatorSelect operatorSelect) {
        this.operatorSelect = operatorSelect;
        this.resultButton = new JButton("Resultado");

        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(10);

        JPanel sidePanelComponents = new JPanel(gridLayout);
        sidePanelComponents.add(this.operatorSelect);
        sidePanelComponents.add(this.resultButton);

        this.setLayout(new BorderLayout());
        this.add(sidePanelComponents, BorderLayout.NORTH);
    }

    public OperatorSelect getOperatorSelect() {
        return operatorSelect;
    }

    public void setOperatorSelect(OperatorSelect operatorSelect) {
        this.operatorSelect = operatorSelect;
    }

    public JButton getResultButton() {
        return resultButton;
    }

    public void setResultButton(JButton resultButton) {
        this.resultButton = resultButton;
    }
}
