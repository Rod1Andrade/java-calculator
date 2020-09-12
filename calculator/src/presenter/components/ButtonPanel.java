package presenter.components;

import controller.ButtonController;

import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Painel de botoes
 * 
 * @author Rodrigo Andrade
 */
public class ButtonPanel extends JPanel {
    
    private ButtonController buttonController;

    private Button button7;
    private Button button8;
    private Button button9;

    private Button button4;
    private Button button5;
    private Button button6;

    private Button button1;
    private Button button2;
    private Button button3;

    private Button button0;
    private Button buttonComma;
    private Button buttonDelete;

    /**
     * Construtor
     */
    public ButtonPanel(ButtonController buttonController) {

        GridLayout gridLayout = new GridLayout(4, 3);
        gridLayout.setVgap(1);
        gridLayout.setHgap(1);

        this.setLayout(gridLayout);
        this.setPreferredSize(this.getPreferredSize());

        this.buttonController = buttonController;

        this.init();
        this.addAllButtons();
    }

    /**
     * Funcao para instanciar os componentes
     */
    private void init() {
        this.button7 = new Button("7", this.buttonController);
        this.button8 = new Button("8", this.buttonController);
        this.button9 = new Button("9", this.buttonController);

        this.button4 = new Button("4", this.buttonController);
        this.button5 = new Button("5", this.buttonController);
        this.button6 = new Button("6", this.buttonController);

        this.button1 = new Button("1", this.buttonController);
        this.button2 = new Button("2", this.buttonController);
        this.button3 = new Button("3", this.buttonController);

        this.button0 = new Button("0", this.buttonController);
        this.buttonComma = new Button(",", this.buttonController);
        this.buttonDelete = new Button("Deletar", this.buttonController);
    }

    /**
     * Adiciona os botoes ao Painel
     */
    private void addAllButtons() {
        this.add(this.button7);
        this.add(this.button8);
        this.add(this.button9);
        
        this.add(this.button4);
        this.add(this.button5);
        this.add(this.button6);
        
        this.add(this.button1);
        this.add(this.button2);
        this.add(this.button3);
        
        this.add(this.button0);
        this.add(this.buttonComma);
        this.add(this.buttonDelete);
    }
}
