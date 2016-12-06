package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class LoginControl {

    public boolean validar(Usuario usu) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usu.getUsuario()) && u.getPass().equals(usu.getPass())) {
                    return true;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return false;
    }
}
