
package Controlador;

import Modelo.MySQLDAO.VentaEntradaVipDAO;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bea
 */
public class EntradaVipControl {
 
    DefaultListModel modeloLista = new DefaultListModel();
       
    public void LlenarTablaVIP(JTable tabla) throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        VentaEntradaVipDAO vevip = new VentaEntradaVipDAO();

        modelo.addColumn("CANT PRODUCTO");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("CANT COMPLEMENTO");
        modelo.addColumn("COMPLEMENTO");
        modelo.addColumn("PRECIO");

        Object[] columna = new Object[5];

        int numeroRegistros = vevip.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
//            columna[0] = vevip.listar().get(i).getIdpromocion();
            columna[0] = vevip.listar().get(i).getCantidadproducto();
            columna[1] = vevip.listar().get(i).getProducto();
            columna[2] = vevip.listar().get(i).getCantidadcomplemento();
            columna[3] = vevip.listar().get(i).getComplemento();
            columna[4] = vevip.listar().get(i).getPrecio();
            modelo.addRow(columna);
        }
    }
    
    /* METODO PARA LLENAR LA LISTA DE PROMOCIONES */
//    public void llenarLista(JList lista) throws Exception{
//        PromocionDAO pdao = new PromocionDAO();
//        for (Promocion p : pdao.listar()) {
//            modeloLista.addElement(p.getNombre());
//            lista.setModel(modeloLista);
//        }
//    }
    
    /* Metodo para cargar la tabla segun la seleccion de la lista de promociones */
    
}

