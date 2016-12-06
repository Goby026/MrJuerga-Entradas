/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Interfaces.ClienteCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author toshiba
 */
public class ClienteDAO extends Conexion implements ClienteCRUD {
    @Override
    public boolean Registrar(Cliente c) throws Exception {
        try {
            String sql = "INSERT INTO cliente(nombre, apellido, dni, direccion,telefono)VALUE (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.setString(3, c.getDni());
            pst.setString(4, c.getDireccion());
            pst.setString(5, c.getTelefono());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    @Override
    public boolean Modificar(Cliente c) throws Exception {
        try {
            String sql = ("UPDATE cliente set nombre = ?, apellido= ?, dni=?, direccion = ?, telefono = ? where idcliente=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.setString(3, c.getDni());
            pst.setString(4, c.getDireccion());
            pst.setString(5, c.getTelefono());
            pst.setInt(6, c.getIdcliente());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }
    @Override
    public void Eliminar(Cliente c) throws Exception {
        try {
            boolean b = false;
            String sql = ("delete from cliente where idcliente=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, c.getIdcliente());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
    }
    @Override
    public List<Cliente> Listar() throws Exception {
        List<Cliente> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Cliente c = new Cliente();
                c.setIdcliente(res.getInt("idcliente"));
                c.setNombre(res.getString("nombre"));
                c.setApellido(res.getString("apellido"));
                c.setDni(res.getString("dni"));
                c.setDireccion(res.getString("direccion"));
                c.setTelefono(res.getString("telefono"));
                li.add(c);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            this.cerrar();
        }
        return li;
    }
}