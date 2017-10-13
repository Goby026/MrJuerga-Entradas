/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.ProductoCRUD;
import Modelo.Conexion;
import Modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class ProductoDAO extends Conexion implements ProductoCRUD {

    @Override
    public void registrar(Producto p) throws Exception {

    }

    @Override
    public void modificar(Producto p) throws Exception {

    }

    @Override
    public void eliminar(Producto p) throws Exception {

    }

    @Override
    public List<Producto> listar() throws Exception {
        List<Producto> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from producto");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setIdPresentacion(rs.getInt("fec_ingreso"));
                lista.add(p);
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

    public Producto obtenerProducto(int id) throws Exception {
        Producto p = new Producto();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select idProducto,nombre,fec_ingreso from producto where idproducto = " + id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setIdPresentacion(rs.getInt("fec_ingreso"));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return p;
    }
}
