/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.ComprobanteCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class ComprobanteDAO extends Conexion implements ComprobanteCRUD {

    @Override
    public boolean Registrar(Comprobante c) throws Exception {
        try {
            String sql = "INSERT INTO comprobante(fecha, usuario, cliente, cantidad,sub_total,ruc,direccion,tipo_pago,total,idtipocomprobante)VALUES (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getFecha());
            pst.setString(2, c.getUsuario());
            pst.setString(3, c.getCliente());
            pst.setInt(4, c.getCantidad());
            pst.setDouble(5, c.getSubTotal());
            pst.setString(6, c.getRuc());
            pst.setString(7, c.getDireccion());
            pst.setString(8, c.getTipo_pago());
            pst.setDouble(9, c.getTotal());
            pst.setInt(10, c.getIdtipocomprobante());
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
    public boolean Modificar(Comprobante c) throws Exception {
        try {
            String sql = "UPDATE comprobante SET fecha = ?, usuario= ?, cliente = ?, cantidad = ?, subtotal = ?, ruc = ?, direccion = ?, tipo_pago = ?, total = ?, idtipocomprobante = ? WHERE idcomprobante = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getFecha());
            pst.setString(2, c.getUsuario());
            pst.setString(3, c.getCliente());
            pst.setInt(4, c.getCantidad());
            pst.setDouble(5, c.getSubTotal());
            pst.setString(6, c.getRuc());
            pst.setString(7, c.getDireccion());
            pst.setString(8, c.getTipo_pago());
            pst.setDouble(9, c.getTotal());
            pst.setInt(10, c.getIdtipocomprobante());
            pst.setInt(11, c.getIdcomprobante());
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
    public boolean Anular(Comprobante c) throws Exception {
        try {
            //String sql = "UPDATE comprobante SET fecha = ?, usuario= ?, cliente = ?, cantidad = ?, subtotal = ?, ruc = ?, direccion = ?, tipo_pago = ?, total = ?, idtipocomprobante = ? WHERE idcomprobante = ?";
            String sql = "UPDATE comprobante SET cantidad = 0, subtotal = 0, total = 0 WHERE idcomprobante = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
//            pst.setString(1, c.getFecha());
//            pst.setString(2, c.getUsuario());
//            pst.setString(3, c.getCliente());
//            pst.setInt(4, c.getCantidad());
//            pst.setDouble(5, c.getSubTotal());
//            pst.setString(6, c.getRuc());
//            pst.setString(7, c.getDireccion());
//            pst.setString(8, c.getTipo_pago());
//            pst.setDouble(9, c.getTotal());
//            pst.setInt(10, c.getIdtipocomprobante());
//            pst.setInt(11, c.getIdcomprobante());
            
            pst.setInt(1, c.getIdcomprobante());
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
    public List<Comprobante> Listar() throws Exception {
        List<Comprobante> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from comprobante");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Comprobante c = new Comprobante();
                c.setIdcomprobante(rs.getInt("idcomprobante"));
                c.setFecha(rs.getString("fecha"));
                c.setUsuario(rs.getString("usuario"));
                c.setCliente(rs.getString("cliente"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setSubTotal(rs.getDouble("sub_total"));
                c.setRuc(rs.getString("ruc"));
                c.setDireccion(rs.getString("direccion"));
                c.setTipo_pago(rs.getString("tipo_pago"));
                c.setTotal(rs.getDouble("total"));
                c.setIdtipocomprobante(rs.getInt("idtipocomprobante"));
                lista.add(c);
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
