package presenter.calculator;

import controller.ButtonController;
import controller.OperatorController;
import controller.ResultController;
import domain.Operator;
import presenter.components.ButtonPanel;
import presenter.components.OperatorSelect;
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
    private OperatorSelect operatorSelectComponent;

    /**
     * Construtor
     */
    public Calculator() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(this.getPreferredSize());

        this.result = new Result(Result.DEFAULT_VALUE);
        this.add(this.result, BorderLayout.NORTH);

        // Controllers (conscientemente acoplado nesse ponto)
        ResultController resultController = new ResultController(result);
        ButtonController buttonController = new ButtonController(resultController);

        this.buttonPanel = new ButtonPanel(buttonController);
        this.add(this.buttonPanel, BorderLayout.CENTER);

        this.operatorSelectComponent = new OperatorSelect();

        // Controller (conscientemente acoplado nesse ponto)
        OperatorController operatorController = new OperatorController(
                resultController,
                this.operatorSelectComponent.getOperatorSelect()
        );

        this.operatorSelectComponent.getOperatorSelectActionButton().addActionListener(operatorController);

        this.sidePanel = new SidePanel(this.operatorSelectComponent);
        this.add(this.sidePanel, BorderLayout.EAST);
    }
}
