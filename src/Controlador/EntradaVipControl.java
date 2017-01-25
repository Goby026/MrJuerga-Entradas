/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VentaEntradaVipDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bea
 */
public class EntradaVipControl {
 
       
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
    
}

