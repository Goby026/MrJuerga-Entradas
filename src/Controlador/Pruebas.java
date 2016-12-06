
package Controlador;

import Modelo.FlujoCaja;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marce
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            AbrirCajaControl acc = new AbrirCajaControl();
            //System.out.println(acc.getCajaDeUsuario("grover987"));            
            System.out.println(acc.getIdUsuario("BEA123"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
