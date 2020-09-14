package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controla o efeito de hover no botao.
 */
public class MouseHover extends MouseAdapter {

    private final JButton button;
    private final Color oldColor;
    private final Color hoverColor;

    public MouseHover(JButton button, Color hoverColor) {
        this.button = button;
        this.oldColor = button.getBackground();
        this.hoverColor = hoverColor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        this.button.setBackground(this.hoverColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        this.button.setBackground(this.oldColor);
    }
}