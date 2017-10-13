
package Modelo.MySQLDAO;

import Interfaces.UsuarioGastosCRUD;
import Modelo.Conexion;
import Modelo.UsuarioGastos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class UsuarioGastosDAO extends Conexion implements UsuarioGastosCRUD{

    @Override
    public boolean registrar(UsuarioGastos ug) throws Exception {
        try {
            String sql = "insert into usuariogastos (idGastos, idusuario, monto, fecha, hora, idflujocaja, observacion) values (?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdGastos());
            pst.setInt(2, ug.getIdUsuario());
            pst.setDouble(3, ug.getMonto());
            pst.setString(4, ug.getFecha());
            pst.setString(5, ug.getHora());
            pst.setInt(6, ug.getIdFlujoCaja());
            pst.setString(7, ug.getObservacion());
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
    public boolean modificar(UsuarioGastos ug) throws Exception {
        try {
            String sql = ("UPDATE usuariogastos set idGastos = ?, idusuario= ?, monto=?, fecha = ?, hora=?, idflujocaja = ?, observacion = ? where idUsuarioGastos=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdGastos());
            pst.setInt(2, ug.getIdUsuario());
            pst.setDouble(3, ug.getMonto());
            pst.setString(4, ug.getFecha());
            pst.setString(5, ug.getHora());
            pst.setInt(6, ug.getIdFlujoCaja());
            pst.setString(7, ug.getObservacion());
            pst.setInt(8, ug.getIdUsuarioGastos());
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
    public boolean eliminar(UsuarioGastos ug) throws Exception {
        try {
            String sql = ("delete from usuariogastos where idUsuarioGastos=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ug.getIdUsuarioGastos());
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
    public List<UsuarioGastos> listar() throws Exception {
        List<UsuarioGastos> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuariogastos");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioGastos ug = new UsuarioGastos();
                ug.setIdUsuarioGastos(rs.getInt("idUsuarioGastos"));
                ug.setIdGastos(rs.getInt("idGastos"));
                ug.setIdUsuario(rs.getInt("idusuario"));
                ug.setMonto(rs.getDouble("monto"));
                ug.setFecha(rs.getString("fecha"));
                ug.setHora(rs.getString("hora"));
                ug.setIdFlujoCaja(rs.getInt("idflujocaja"));
                ug.setObservacion(rs.getString("observacion"));
                lista.add(ug);
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
    
    public double getMontoEgresos(int idFlujoCaja) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(monto) from usuariogastos where idflujocaja = "+idFlujoCaja+"");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getDouble("sum(monto)");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
    
}
