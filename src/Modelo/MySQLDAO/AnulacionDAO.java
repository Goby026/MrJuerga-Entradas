/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.AnulacionesCRUD;
import Modelo.Anulacion;
import Modelo.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author toshiba
 */
public class AnulacionDAO  extends Conexion implements AnulacionesCRUD{

    @Override
    public void Buscar(Anulacion a) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT `idventaEntrada`,`fecha`,venta.fecha `numPersonas`, `total` FROM `ventaentrada` INNER JOIN venta on ventaentrada.venta_idventa = venta.idventa WHERE idventaEntrada = ?");
          //PreparedStatement pst = this.conexion.prepareStatement("SELECT `idventa` FROM `venta_detalle` INNER JOIN producto on venta_detalle.idproducto = producto.id INNER JOIN tmarca on producto.id_marca = tmarca.id_marca WHERE idventa= "+idVenta+" ";)
            pst.setDate(1, a.getFecha());
            pst.setString(2, a.getHora());
            pst.setInt(3, a.getIdventaEntrada());
            pst.setInt(4, a.getNumPersonas());
            pst.setDouble(5, a.getTotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("hola bea ja ja ja");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
        }
        
        
    }
    
    
}
