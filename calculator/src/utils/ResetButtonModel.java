package utils;

import javax.swing.*;

/**
 * Controla o modelo padrao do botao
 *
 * Usado nesse contexto para tirar a resposta do click
 * gerada por padrao.
 */
public class ResetButtonModel extends DefaultButtonModel {

    @Override
    public boolean isPressed() {
        return false;
    }

    @Override
    public boolean isRollover() {
        return false;
    }

    @Override
    public void setRollover(boolean b) {
        //NOOP
    }
}

