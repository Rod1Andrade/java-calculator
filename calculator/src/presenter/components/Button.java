package presenter.components;

import controller.ButtonController;
import utils.MouseHover;
import utils.ResetButtonModel;

import javax.swing.*;

import java.awt.*;

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
     * @param value  Valor textual
     * @param controller Controller do botao
     * @param backgroundColor Cor de fundo do botao
     * @param textColor Cor do texto do botao
     * @param hasHoverEffect Define se tem o efeito de hover no botao
     */
    Button(
            String value,
            ButtonController controller,
            Color backgroundColor,
            Color textColor,
            boolean hasHoverEffect
    ) {
        this.value = value;
        this.setMinimumSize(new Dimension(Button.WIDTH, Button.HEIGHT));
        this.setText(this.getValue());

        this.setBorderPainted(false);
        this.setContentAreaFilled(true);

        this.setFocusPainted(false);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);

        this.setModel(new ResetButtonModel());

        this.setRolloverEnabled(false);

        this.addActionListener(controller);

        if(hasHoverEffect) {
            this.addMouseListener(new MouseHover(this, new Color(75, 0, 130)));
        }
    }

    /**
     * Define o valor do botao
     * @param value Valor que vai ser definido para o botao
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
