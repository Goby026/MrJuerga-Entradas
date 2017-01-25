/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.VentaEntrada;
import Modelo.VentaEntradaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class AnulacionesControl {

    public String[] CargarDatos(int numboleta) throws Exception {
        try {
            String[] datos = new String[7];
            VentaEntradaDAO vdao = new VentaEntradaDAO();
            for (VentaEntrada ve : vdao.listar()) {
                if (ve.getIdVenta() == numboleta) {
                    datos[0] = ve.getTipoEntrada();
                    datos[1] = String.valueOf(ve.getNumPersonas());
                    datos[2] = String.valueOf(ve.getNumCovers());
                    datos[3] = ve.getFecha();
                    datos[4] = ve.getFecha();
                    datos[5] = getNomUsuario(getidUsuario(numboleta));
                    datos[6] = String.valueOf(ve.getTotal());
                    return datos;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }

    //METODO PARA OPTENER EL ID DEL USUARIO QUE REALIZO LA VENTA
    public int getidUsuario(int numboleta) throws Exception {
        try {
            VentaDAO vdao = new VentaDAO();
            for (Venta v : vdao.listar()) {
                if (v.getIdVenta() == numboleta) {
                    return v.getIdUsuario();

                }

            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }

    //METODO PARA OPTENER EL NOMBRE DEL USUARIO QUE REALIZO LA VENTA CON SU ID
    public String getNomUsuario(int idUsuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getId() == idUsuario) {
                    return u.getNombre();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }

    

}
