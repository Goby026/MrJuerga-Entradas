package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.FlujoCaja;
import Modelo.MySQLDAO.FlujoCajaDAO;
import Modelo.Usuario;
import Modelo.UsuarioCaja;
import Modelo.MySQLDAO.UsuarioCajaDAO;
import Modelo.MySQLDAO.UsuarioDAO;

/**
 *
 * @author Marce
 */
public class AbrirCajaControl {

    //METODO PARA OBTENER EL NOMBRE DE CAJA DEL USUARIO LOGEADO
    public String getCajaDeUsuario(String usuario) throws Exception {
        try {
            int idUsuario = getIdUsuario(usuario);
            UsuarioCajaDAO udao = new UsuarioCajaDAO();
            for (UsuarioCaja uc : udao.Listar()) {
                if (uc.getIdusuario() == idUsuario) {
                    return getCajaConId(uc.getIdcaja());
                }
            }
            return "NULL de getCajaDeUsuario";
        } catch (Exception e) {
            throw e;
        }
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

    /*METODO PARA OBTENER EL NOMBRE DE CAJA CON SU ID*/
    public String getCajaConId(int idCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getIdCaja() == idCaja) {
                    return c.getNomCaja();
                }
            }
            return "NULL de getCajaConId";
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

    //metodo para verificar el estado de la caja asignada a un usuario
    public int verificarEstadoCaja(String usuario) throws Exception {
        int flag = 0;
        //obtener el id de la caja asignada al usuario logeado
        String nomCaja = new AbrirCajaControl().getCajaDeUsuario(usuario);
        int idCaja = new AbrirCajaControl().getIdCaja(nomCaja);
        System.out.println(idCaja);
        //obtener el id del usuario
        int idUsuario = new AbrirCajaControl().getIdUsuario(usuario);
        System.out.println(idUsuario);
        //capturo el id de flujo de caja
        int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(idUsuario, idCaja);
        System.out.println(idFlujoCaja);
        
        FlujoCajaDAO fcdao = new FlujoCajaDAO();
        for (FlujoCaja fc : fcdao.Listar()) {
            if (fc.getIdFlujoCaja()==idFlujoCaja) {
                flag = Integer.parseInt(fc.getEstado());
                break;
            }
        }
        System.out.println(flag);
        return flag;
    }

    //METODO PARA VALIDAR LA APERTURA DE CAJA
    public boolean verificarApertura(int idUsuario,int idCaja) throws Exception {
        try {
            //verificar el estado de la caja
            FlujoCajaDAO fcdao = new FlujoCajaDAO();
            int idFlujoCaja = fcdao.getIdFlujo(idUsuario, idCaja);
            for (FlujoCaja fc : fcdao.Listar()) {
                if ("1".equals(fc.getEstado()) && fc.getIdFlujoCaja()==idFlujoCaja) {
                    return true;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return false;
    }
    
    public String getSaldoInicial(int idFlujoCaja) throws Exception{
        try {
            FlujoCajaDAO fcdao = new FlujoCajaDAO();
            for (FlujoCaja fc : fcdao.Listar()) {
                if (fc.getIdFlujoCaja() == idFlujoCaja) {                    
                    return String.valueOf(fc.getSaldo());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
