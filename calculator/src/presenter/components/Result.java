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

    private JLabel resultLabel;

    /**
     * Construtor
     * @param value
     */
    public Result(String value) {
        this.setBackground(Color.DARK_GRAY);

        this.setLayout(new FlowLayout(
            FlowLayout.LEADING,
            Result.PADDING_HORIZONTAL,
            Result.PADDING_VERTICAL));

        this.resultLabel = new JLabel(value);
        this.resultLabel.setForeground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.add(this.resultLabel);
    }

    /**
     * Retorna uma resultLabel
     * @return JLabel resultLabel
     */
    public JLabel getResultLabel() {
        return resultLabel;
    }

    /**
     * Define uma resultLabel
     * @param resultLabel
     */
    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

}
