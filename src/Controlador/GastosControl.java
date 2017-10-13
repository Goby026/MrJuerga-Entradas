
package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.Gasto;
import Modelo.MySQLDAO.GastoDAO;
import Modelo.Usuario;
import Modelo.UsuarioCaja;
import Modelo.MySQLDAO.UsuarioCajaDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Marce
 */
public class GastosControl {
    DefaultListModel modeloLista = new DefaultListModel();
    public void cargarListaGastos(JList lista) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                modeloLista.addElement(g.getConcepto());
            }
            lista.setModel(modeloLista);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //metodo para registrar gasto
    public void registrarGasto(String concepto){
        try {
            //obtener el id de gasto seleccionado
            //obtener el id de usuario
            //obtener el monto fecha hora ¿usuario pagado?
        } catch (Exception e) {
        }
    }
    
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
    
    /*METODO PARA OBTENER EL ID DE GASTO CON SU NOMBRE*/
    public int getIdGasto(String gasto) throws Exception {
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                if (g.getConcepto().equals(gasto)) {
                    return g.getIdgastos();
                }
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }
}
