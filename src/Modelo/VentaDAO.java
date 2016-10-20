package Modelo;

import Interfaces.VentaCRUD;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gaby
 */
public class VentaDAO extends Conexion implements VentaCRUD {

    @Override
    public void registrar(Venta v) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("insert into venta(fecha, hora,idusuario, idcliente, idcomprobante,estado, idcaja ) values (?,?,?,?,?,?,?)");
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getIdcaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Se registro la venta");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error asd");
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Venta v) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("update venta(fecha, hora,idusuario, idcliente, idcomprobante,estado, idcaja ) values (?,?,?,?,?,?,?)");
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getIdcaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Se registro la venta");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error asd");
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Venta v) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from venta");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("idventa"));
                v.setFecha(rs.getDate("fecha").toString());
                v.setHora(rs.getString("hora"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setIdComprobante(rs.getInt("idcomprobante"));
                lista.add(v);
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
    public void registrarEntrada(Venta v) throws Exception {
        
    }

}
