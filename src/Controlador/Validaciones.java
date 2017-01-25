package Controlador;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validaciones {

    public boolean validarCampoVacio(JTextField campo) {

        if (!campo.getText().trim().isEmpty()) {
            return true;
        } else {
            campo.requestFocus();
        }
        return false;
    }

    public void validarCampoNumerico(java.awt.event.KeyEvent evt, JTextField campo) {
        int tecla = (int) evt.getKeyChar();
        if (tecla > 47 && tecla < 58) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
            campo.requestFocus();
            //txt_nombres.requestFocus();
        }
    }

    public void validarCampoString(java.awt.event.KeyEvent evt, JTextField campo) {
        int tecla = (int) evt.getKeyChar();
        if (tecla > 64 && tecla < 91 || tecla > 96 && tecla < 123) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS");
            campo.requestFocus();
        } else if (campo.getText().trim().length() == 8) {
            evt.consume();
        }
    }

    public void validarCampoStringRuc(java.awt.event.KeyEvent evt, JTextField campo) {
        int tecla = (int) evt.getKeyChar();
        if (tecla > 64 && tecla < 91 || tecla > 96 && tecla < 123) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NUMEROS");
            campo.requestFocus();
        } else if (campo.getText().trim().length() == 11) {
            evt.consume();
        }
    }

    public void bloquear(JButton jb) {
        jb.setEnabled(false);
    }

    public void desbloquear(JButton jb) {
        jb.setEnabled(false);
    }
}
