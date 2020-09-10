package presenter.components;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

/**
 * JLabel para apresentar o resultado
 * 
 * @author Rodrigo Andrade
 */
public class Result extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final int PADDING_HORIZONTAL = 10;
    public static final int PADDING_VERTICAL = 15;

    private JLabel resultText;
    private String value;

    public Result(String value) {
        this.setLayout(new FlowLayout(
            FlowLayout.LEADING,
            Result.PADDING_HORIZONTAL,
            Result.PADDING_VERTICAL));
        this.setValue(value);

        this.resultText = new JLabel(this.getValue());
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
        this.add(this.resultText);
    }   

    /**
     * Define o valor
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Retorna o valor
     * @return
     */
    public String getValue() {
        return this.value;
    }

    // TODO Eventos para manipular o texto

}
