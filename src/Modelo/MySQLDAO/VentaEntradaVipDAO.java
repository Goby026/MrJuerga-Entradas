/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.VentaEntradaVip;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class VentaEntradaVipDAO extends Conexion implements DAO<VentaEntradaVip> {

    @Override
    public boolean Registrar(VentaEntradaVip vevip) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `ventaentradavip`(`numPersonas`,`numCovers`,`total`,`tipoEntrada`,`venta_idventa`,`idproducto`) VALUES (?,?,?,?,?,?)");

//            pst.setInt(1, vevip.getIdpromocion());
            pst.setInt(1, vevip.getNumPersonas());
            pst.setInt(2, vevip.getNumCovers());
            pst.setDouble(3, vevip.getTotal());
            pst.setString(4, vevip.getTipoEntrada());
            pst.setInt(5, vevip.getIdEntradaVip());
            pst.setInt(6, vevip.getIdProd());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error asd");
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(VentaEntradaVip vevip) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentaEntradaVip> Listar() throws Exception {
        List<VentaEntradaVip> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from ventaentradavip");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VentaEntradaVip vevip = new VentaEntradaVip();
//                vevip.setIdpromocion(rs.getInt("Idpromocion"));
                vevip.setIdVentaEntradaVip(rs.getInt(1));
                vevip.setNumPersonas(rs.getInt(2));
                vevip.setNumCovers(rs.getInt(3));
                vevip.setTotal(rs.getDouble(4));
                vevip.setTipoEntrada(rs.getString(5));
                vevip.setIdEntradaVip(rs.getInt(6));
                vevip.setIdProd(rs.getInt(7));
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

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VentaEntradaVip Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
