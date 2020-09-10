package presenter.calculator;

import javax.swing.JPanel;

import presenter.components.ButtonPanel;
import presenter.components.Result;

import java.awt.BorderLayout;

/**
 * Presenter Calculator
 * 
 * Classe responsalve por apresentar a feature
 * calculadora.
 * 
 * @author Rodrigo Andrade
 */
public class Calculator  extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private Result result;
    private ButtonPanel buttonPanel;

    /**
     * Construtor
     */
    public Calculator() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(this.getPreferredSize());

        this.result = new Result("Nenhuma operação...");
        this.add(this.result, BorderLayout.NORTH);

        this.buttonPanel = new ButtonPanel();
        this.add(this.buttonPanel, BorderLayout.CENTER);
    }
}
