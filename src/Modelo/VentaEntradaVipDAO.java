/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.VentaEntradaVipCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class VentaEntradaVipDAO extends Conexion implements VentaEntradaVipCRUD {

    @Override
    public void registrar(VentaEntradaVip vevip) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `promocion`(`producto`, `cantidadproducto`, `complemento`, `cantidadcomplemento`, `precio`) VALUES (?,?,?,?,?)");

//            pst.setInt(1, vevip.getIdpromocion());
            pst.setInt(1, vevip.getCantidadproducto());
            pst.setString(2, vevip.getProducto());
            pst.setInt(3, vevip.getCantidadcomplemento());
            pst.setString(4, vevip.getComplemento());
            pst.setDouble(5, vevip.getPrecio());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Se registro la entrada");
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
    public void modificar(VentaEntradaVip vevip) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(VentaEntradaVip vevip) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentaEntradaVip> listar() throws Exception {
        List<VentaEntradaVip> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from promocion");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VentaEntradaVip vevip = new VentaEntradaVip();
//                vevip.setIdpromocion(rs.getInt("Idpromocion"));
                vevip.setCantidadproducto(rs.getInt("cantidadproducto"));
                vevip.setProducto(rs.getString("producto"));
                vevip.setCantidadcomplemento(rs.getInt("cantidadcomplemento"));
                vevip.setComplemento(rs.getString("complemento"));
                vevip.setPrecio(rs.getDouble("precio"));
                lista.add(vevip);
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
