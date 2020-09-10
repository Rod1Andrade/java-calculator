package presenter.components;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Botao individual da calculadora
 * 
 * @author Rodrigo Andrade
 */
public class Button extends JButton {
    
    public static final int WIDTH = 100;
    public static final int HEIGHT = 103;

    private String value;
    
    /**
     * Construtor
     * 
     * @param value
     */
    Button(String value) {
        this.value = value;
        this.setMinimumSize(new Dimension(Button.WIDTH, Button.HEIGHT));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setText(this.getValue());
    }

    /**
     * Define o valor do botao
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Retorna o valor do botao
     */
    public String getValue() {
        return this.value;
    }
}
