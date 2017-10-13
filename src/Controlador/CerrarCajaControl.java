
package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.FlujoCaja;
import Modelo.MySQLDAO.FlujoCajaDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class CerrarCajaControl {
    
//    public double getSaldoInicial(int idFlujoCaja) throws Exception{
//        try {
//            FlujoCajaDAO fcdao = new FlujoCajaDAO();
//            for (FlujoCaja fc : fcdao.Listar()) {
//                if (fc.getIdFlujoCaja()==idFlujoCaja) {
//                    return fc.getSaldo();
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return 0.0;
//    }
    
    /*METODO PARA OBTENER EL NOMBRE DE USUARIO CON EL USUARIO*/
    public String getNombreUsuario(String usuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    return u.getNombre();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
    /*METODO PARA OBTENER EL APELLIDO DE USUARIO CON EL USUARIO*/
    public String getApellidoUsuario(String usuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    return u.getApellido();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
    /*METODO PARA OBTENER EL ID DE USUARIO CON EL NOMBRE*/
    public int getIdUsuario(String usuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    return u.getId();
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*METODO PARA OBTENER EL ID DE CAJA CON SU NOMBRE*/
    public int getIdCaja(String nomCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getNomCaja().equals(nomCaja)) {
                    return c.getIdCaja();
                }
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*METODO PARA OBTENER EL MONTO DE TARJETAS A PARTIR DE LA APERTURA DE CAJA */
    public double getMontoTarjetas(int idUsuario, int idCaja) throws Exception{
        try {
            String fechaInicial=null;
            String horaInicial= null;
            int tipoPago=3;
            //primero obtengo el id de flujo de caja para obtener la fecha inicial y la hora inical
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(idUsuario, idCaja);
            return new FlujoCajaDAO().getMontoFlujo(idFlujoCaja);
        } catch (Exception e) {
            throw e;
        }
    }
    /* METODO PARA OBTENER EL MONTO TOTAL DE VENTAS A PARTIR DE LA APERTURA DE CAJA */
//    public double getMontoVentas(int idUsuario, int idCaja) throws Exception{
//        try {
//            int tipoPago=1;
//            //primero obtengo el id de flujo de caja para obtener la fecha inicial y la hora inical
//            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(idUsuario, idCaja);
//            //obtengo la fecha inicial y hora inicial para empezar ah contabilizar las operacione con tarjeta
//            return new FlujoCajaDAO().getMontoFlujo(idFlujoCaja, tipoPago);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    /* METODO PARA CERRAR CAJA */ 
    public boolean cerrarCaja(int idUsuario, int idCaja, FlujoCaja fc) throws Exception{
        try {
            //obtengo el id de flujo de caja respectivo
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(idUsuario, idCaja);
            fc.setIdFlujoCaja(idFlujoCaja);
            if (new FlujoCajaDAO().updateFlujoCaja(fc)) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }
}
