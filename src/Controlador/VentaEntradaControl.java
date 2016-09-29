package Controlador;

import Modelo.VentaEntradaDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author g0by
 */
public class VentaEntradaControl {

    public void LlenarTabla(JTable tabla) throws Exception {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        VentaEntradaDAO ved = new VentaEntradaDAO();

        modelo.addColumn("ID");
        modelo.addColumn("N° PERSONAS");
        modelo.addColumn("N° COVERS");
        modelo.addColumn("TOTAL");
        modelo.addColumn("TIPO ENTRADA");

        Object[] columna = new Object[5];

        int numeroRegistros = ved.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ved.listar().get(i).getIdVenta();
            columna[1] = ved.listar().get(i).getNumPersonas();
            columna[2] = ved.listar().get(i).getNumCovers();
            columna[3] = ved.listar().get(i).getTotal();
            columna[4] = ved.listar().get(i).getTipoEntrada();
            modelo.addRow(columna);
        }
    }

}