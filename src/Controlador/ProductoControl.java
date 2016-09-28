
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import javax.swing.JComboBox;

/**
 *
 * @author Goby
 */
public class ProductoControl {
    public void cargarCombo(JComboBox cmb) throws Exception{
        ProductoDAO pdao = new ProductoDAO();
        for (Producto prod : pdao.listar()) {
            cmb.addItem(prod.getNombre());
        }
    }
    public int covers(int personasPorCover, int cantPersonas) {
        int covers = cantPersonas / personasPorCover;
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

    public double total(int cantCovers, int cantPersonas, double precioCover, double precioEntrada) {
        double p = (cantCovers * precioCover) + (cantPersonas * precioEntrada);
        return p;
    }
}
