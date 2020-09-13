package presenter.calculator;

import controller.ButtonController;
import controller.OperatorController;
import controller.ResultController;
import presenter.components.ButtonPanel;
import presenter.components.OperatorSelect;
import presenter.components.Result;
import presenter.components.SidePanel;
import utils.Constants;

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
public class CalculatorView extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private final  Result result;
    private final ButtonPanel buttonPanel;
    private final SidePanel sidePanel;
    private final OperatorSelect operatorSelectComponent;

    /**
     * Construtor
     */
    public CalculatorView() {
        this.setBackground(Color.DARK_GRAY);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(this.getPreferredSize());

        // Label result panel
        this.result = new Result(Constants.DEFAULT_VALUE);
        this.add(this.result, BorderLayout.NORTH);

        ResultController resultController = new ResultController(result); // (conscientemente acoplado nesse ponto)

        // Keyboard panel
        ButtonController buttonController = new ButtonController(resultController);
        this.buttonPanel = new ButtonPanel(buttonController);
        this.add(this.buttonPanel, BorderLayout.CENTER);

        // SidePanel
        this.operatorSelectComponent = new OperatorSelect();

        OperatorController operatorController = new OperatorController(
                resultController,
                this.operatorSelectComponent.getOperatorSelect()
        ); // (conscientemente acoplado nesse ponto)

        this.operatorSelectComponent.getOperatorSelectActionButton().addActionListener(operatorController);

        this.sidePanel = new SidePanel(this.operatorSelectComponent);
        this.sidePanel.getResultButton().addActionListener(buttonController);

        this.add(this.sidePanel, BorderLayout.EAST);
    }
}
