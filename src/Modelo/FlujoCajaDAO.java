package Modelo;

import Interfaces.FlujoCajaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class FlujoCajaDAO extends Conexion implements FlujoCajaCRUD {

    @Override
    public boolean Registrar(FlujoCaja fc) throws Exception {
        try {
            String sql = "INSERT INTO flujocaja(fecha_flujo,ingresos,egresos,saldo,idusuario,idcaja)VALUE (?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFecha());
            pst.setDouble(2, fc.getIngresos());
            pst.setDouble(3, fc.getEgresos());
            pst.setDouble(4, fc.getSaldo());
            pst.setInt(5, fc.getIdUsuario());
            pst.setInt(6, fc.getIdCaja());
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
    public boolean Modificar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("UPDATE caja flujocaja SET fecha_flujo = ?, ingresos = ?, egresos = ?, saldo = ?, idusuario = ?, idcaja = ? WHERE idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFecha());
            pst.setDouble(2, fc.getIngresos());
            pst.setDouble(3, fc.getEgresos());
            pst.setDouble(4, fc.getSaldo());
            pst.setInt(5, fc.getIdUsuario());
            pst.setInt(6, fc.getIdCaja());
            pst.setInt(7, fc.getIdFlujoCaja());
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
    public boolean Eliminar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("delete from flujocaja where idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdFlujoCaja());
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
    public List<FlujoCaja> Listar() throws Exception {
        List<FlujoCaja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FlujoCaja fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));
                fc.setFecha(res.getString("fecha_flujo"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                lista.add(fc);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
