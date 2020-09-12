package presenter.calculator;


import presenter.components.ButtonPanel;
import presenter.components.Result;
import presenter.components.SidePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Presenter Calculator
 * 
 * Classe responsalve por apresentar a funcionalidade principal
 * de calculadora.
 * 
 * @author Rodrigo Andrade
 */
public class Calculator  extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private Result result;
    private ButtonPanel buttonPanel;
    private SidePanel sidePanel;

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

        this.sidePanel = new SidePanel();
        this.add(this.sidePanel, BorderLayout.EAST);
    }
}
