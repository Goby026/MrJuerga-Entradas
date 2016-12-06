
package Modelo;

import Interfaces.UsuarioCajaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCajaDAO extends Conexion implements UsuarioCajaCRUD{

    @Override
    public boolean Registrar(UsuarioCaja uc) throws Exception {
        try {
            String sql = "insert into usuariocaja (idusuario, idcaja) values (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, uc.getIdusuario());
            pst.setInt(2, uc.getIdcaja());
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
    public boolean Modificar(UsuarioCaja uc) throws Exception {
        try {
            String sql = "update usuariocaja set idusuario=?, idcaja=? where idusuariocaja=?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, uc.getIdusuario());
            pst.setInt(2, uc.getIdcaja());
            pst.setInt(3, uc.getIdUsuarioCaja());
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
    public boolean Eliminar(UsuarioCaja uc) throws Exception {
        try {
            String sql = ("delete from usuariocaja where idusuariocaja=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, uc.getIdUsuarioCaja());
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
    public List<UsuarioCaja> Listar() throws Exception {
        List<UsuarioCaja> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuariocaja");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioCaja uc = new UsuarioCaja();
                uc.setIdUsuarioCaja(rs.getInt("idusuariocaja"));
                uc.setIdusuario(rs.getInt("idusuario"));
                uc.setIdcaja(rs.getInt("idcaja"));
                lista.add(uc);
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
    
}
