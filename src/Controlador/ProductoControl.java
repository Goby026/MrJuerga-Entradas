package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Goby
 */
public class ProductoControl {

    public void cargarCombo(JComboBox cmb) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto prod : pdao.listar()) {
                cmb.addItem(prod.getNombre());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int covers(int personas, int cantPersonas) {
        int covers = cantPersonas / personas;
        return covers;
    }

    public int entradas(int personasPorCover, int cantPersonas) {
        int entrada = 0;
        double res = cantPersonas % personasPorCover;
        if (res > 0) {
            entrada = 1;
        }
        return entrada;
    }

    public double total(int cantCovers, double precioCover) {
        double p = (cantCovers * precioCover);
        return p;
    }

    public double totalvip(int cant, double precio) {
        double p = (cant  * precio);
        return p;
    }
     
}
