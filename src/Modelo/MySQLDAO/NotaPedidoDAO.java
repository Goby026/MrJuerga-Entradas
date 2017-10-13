package Modelo.MySQLDAO;

import Interfaces.NotaPedidoCRUD;
import Modelo.Conexion;
import Modelo.NotaPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class NotaPedidoDAO extends Conexion implements NotaPedidoCRUD {

    @Override
    public boolean registrar(NotaPedido np) throws Exception {
        try {
            String sql = "INSERT INTO `notapedido`(`fecha`, `hora`, `idusuario`, `idcliente`,`idtipocomprobante`, `estado`, `tipopago`, `noperacion`, `idcaja`, `idflujocaja`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, np.getFecha());
            pst.setString(2, np.getHora());
            pst.setInt(3, np.getIdUsuario());
            pst.setInt(4, np.getIdcliente());
            pst.setInt(5, np.getIdTipoComprobante());
            pst.setInt(6, np.getEstado());
            pst.setInt(7,np.getTipopago());
            pst.setString(8,np.getnOperacion());
            pst.setInt(9, np.getIdcaja());
            pst.setInt(10, np.getIdFlujoCaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                /* aca podria entrar la consulta para registrar el detalle de ventas (ventanota) */
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(NotaPedido np) throws Exception {
        try {
            String sql = "UPDATE notapedido SET fecha=?, hora=?, idusuario=?, idcliente=?,idtipocomprobante=?, estado=?, tipopago = ?,noperacion = ? ,idcaja = ? ,idflujocaja = ? WHERE idnotapedido = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, np.getFecha());
            pst.setString(2, np.getHora());
            pst.setInt(3, np.getIdUsuario());
            pst.setInt(4, np.getIdcliente());
            pst.setInt(5, np.getIdTipoComprobante());
            pst.setInt(6, np.getEstado());
            pst.setInt(7,np.getTipopago());
            pst.setString(8,np.getnOperacion());
            pst.setInt(9, np.getIdcaja());
            pst.setInt(10, np.getIdFlujoCaja());
            pst.setInt(11, np.getIdNotaPedido());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean anular(int numNotaPedido) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sqlAnularNotaPedido = "UPDATE notapedido SET estado = 0 WHERE idnotapedido = "+numNotaPedido+"";
            String sqlAnularDetalleNotaPedido = "UPDATE ventanota SET numCovers = 0, total = 0 WHERE idnotapedido = "+numNotaPedido+"";
            this.conectar();
            
            PreparedStatement pst = this.conexion.prepareStatement(sqlAnularNotaPedido);
            PreparedStatement pst2 = this.conexion.prepareStatement(sqlAnularDetalleNotaPedido);
            
            int res = pst.executeUpdate();
            int res2 = pst2.executeUpdate();
            
            if (res > 0 && res2 > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<NotaPedido> listar() throws Exception {
        List<NotaPedido> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from notapedido");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NotaPedido np = new NotaPedido();
                np.setIdNotaPedido(rs.getInt("idnotapedido"));
                np.setFecha(rs.getString("fecha"));
                np.setHora(rs.getString("hora"));
                np.setIdUsuario(rs.getInt("idusuario"));
                np.setIdcliente(rs.getInt("idcliente"));
                np.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                np.setEstado(rs.getInt("estado"));
                np.setTipopago(rs.getInt("tipopago"));
                np.setnOperacion(rs.getString("noperacion"));
                np.setIdcaja(rs.getInt("idcaja"));
                np.setIdFlujoCaja(rs.getInt("idflujocaja"));
                lista.add(np);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public NotaPedido obtener(int id) throws Exception {
        NotaPedido np = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from notapedido where idnotapedido = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                np = new NotaPedido();
                np.setIdNotaPedido(rs.getInt("idnotapedido"));
                np.setFecha(rs.getString("fecha"));
                np.setHora(rs.getString("hora"));
                np.setIdUsuario(rs.getInt("idusuario"));
                np.setIdcliente(rs.getInt("idcliente"));
                np.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                np.setEstado(rs.getInt("estado"));
                np.setTipopago(rs.getInt("tipopago"));
                np.setnOperacion(rs.getString("noperacion"));
                np.setIdcaja(rs.getInt("idcaja"));
                np.setIdFlujoCaja(rs.getInt("idflujocaja"));
            }
            rs.close();
            pst.close();
            return np;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    //metodo para obtener la ultima nota de pedido registrada
    public int ultimaNotaPedido() throws Exception{
        try {
            String sql = "select idnotapedido from notapedido order by idnotapedido desc limit 1";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt("idnotapedido");
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }
}
