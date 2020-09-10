import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presenter.calculator.Calculator;

/**
 * Classe principal
 * 
 * @author Rodrigo Andrade
 */
public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;

    /**
     * Construtor
     * 
     * @param entryPoint Painel inicial da aplicacao.
     */
    public App(final JPanel entryPoint) {
        super("Calculadora");
        this.setMinimumSize(new Dimension(App.WIDTH, App.HEIGHT));
        this.setDefaultCloseOperation(App.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(entryPoint);
        this.pack();
    }   

    /**
     * Metodo de inicializacao
     */
    public void start() {
        this.setVisible(true);
    }

    public static void main(final String[] args) {
        new App(new Calculator()).start();
    }
}
