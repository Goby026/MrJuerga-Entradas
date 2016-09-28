/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.UsuarioCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class UsuarioDAO extends Conexion implements UsuarioCRUD {

    public boolean validarUsuario(Usuario u) throws Exception {
        try {
            this.conectar();
            String sql = "Select usuario, pass from usuario where usuario = '" + u.getUsuario() + "' AND pass = '" + u.getPass() + "'";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    @Override
    public void registrar(Usuario u) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `usuario`(`nombre`, `apellido`, "
                    + "`dni`, `telefono`, `direccion`, `imagen`, `usuario`, `pass`, `idarea`) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellido());
            pst.setString(3, u.getDni());
            pst.setString(4, u.getTelefono());
            pst.setString(5, u.getDireccion());
            pst.setString(6, u.getImagen());
            pst.setString(7, u.getUsuario());
            pst.setString(8, u.getPass());
            pst.setInt(9, u.getIdArea());

            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Usuario registrado");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Usuario u) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `usuario` SET `nombre`=?,`apellido`=?,"
                    + "`dni`=?,`telefono`=?,`direccion`=?,`imagen`=?,"
                    + "`usuario`=?,`pass`=?,`idarea`=? WHERE idusuario = ?");
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellido());
            pst.setString(3, u.getDni());
            pst.setString(4, u.getTelefono());
            pst.setString(5, u.getDireccion());
            pst.setString(6, u.getImagen());
            pst.setString(7, u.getUsuario());
            pst.setString(8, u.getPass());
            pst.setInt(9, u.getIdArea());
            pst.setInt(10, u.getIdUsu());

            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Usuario modificado");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Usuario u) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
            pst.setInt(1, u.getIdUsu());

            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Usuario eliminado");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuario");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsu(rs.getInt("idusuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setDni(rs.getString("dni"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setImagen(rs.getString("imagen"));
                u.setUsuario(rs.getString("usuario"));
                u.setPass(rs.getString("pass"));
                u.setIdArea(rs.getInt("idarea"));
                lista.add(u);
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
