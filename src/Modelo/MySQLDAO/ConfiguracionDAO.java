/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.ConfiguracionCRUD;
import Modelo.Conexion;
import Modelo.Configuracion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class ConfiguracionDAO extends Conexion implements ConfiguracionCRUD {

    @Override
    public boolean Registrar(Configuracion c) throws Exception {
        try {
            String sql = "INSERT INTO configuracion(preciovip,preciogeneral,dctogeneral, dctofamiliar, idproductodefecto)VALUE (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, c.getPrecioVip());
            pst.setDouble(2, c.getPrecioGeneral());
            pst.setDouble(3, c.getDctGeneral());
            pst.setDouble(4, c.getDctoFamiliar());
            pst.setInt(5, c.getIdProfuctoDefecto());
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
    public boolean Modificar(Configuracion c) throws Exception {
        try {
            String sql = ("UPDATE configuracion SET preciovip = ?,preciogeneral=?,dctogeneral=? ,dctofamiliar=?, idproductodefecto = ? WHERE idconfiguracion = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, c.getPrecioVip());
            pst.setDouble(2, c.getPrecioGeneral());
            pst.setDouble(3, c.getDctGeneral());
            pst.setDouble(4, c.getDctoFamiliar());
            pst.setInt(5, c.getIdProfuctoDefecto());
            pst.setInt(6, c.getIdconfiguracion());
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
    public boolean Eliminar(Configuracion c) throws Exception {
        try {
            String sql = ("DELETE FROM configuracion WHERE idconfiguracion = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, c.getIdconfiguracion());
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
    public List<Configuracion> Listar() throws Exception {
        List<Configuracion> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idconfiguracion, preciovip, preciogeneral, dctogeneral, dctofamiliar FROM configuracion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Configuracion c = new Configuracion();
                c.setIdconfiguracion(res.getInt("idconfiguracion"));
                c.setPrecioVip(res.getDouble("preciovip"));
                c.setPrecioGeneral(res.getDouble("preciogeneral"));
                c.setDctGeneral(res.getDouble("dctogeneral"));
                c.setDctoFamiliar(res.getDouble("dctofamiliar"));
                lista.add(c);
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
    
    public Configuracion Obtener(int id) throws Exception{
        Configuracion c = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM configuracion WHERE idconfiguracion = ?";            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                c = new Configuracion();
                c.setIdconfiguracion(res.getInt(1));
                c.setPrecioVip(res.getDouble(2));
                c.setPrecioGeneral(res.getDouble(3));
                c.setDctGeneral(res.getDouble(4));
                c.setDctoFamiliar(res.getDouble(5));
                c.setIdProfuctoDefecto(res.getInt(6));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return c;
    }

    //METODO PARA OBTENER EL PRECIO DE ENTRADA
    public double getPrecios(int opc) throws Exception {
        try {
            this.conectar();
            if (opc == 1) {
                PreparedStatement pst = this.conexion.prepareStatement("SELECT preciogeneral FROM configuracion WHERE idconfiguracion = 1");
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    return res.getDouble("preciogeneral");
                }
                pst.close();
                res.close();
            } else {
                PreparedStatement pst = this.conexion.prepareStatement("SELECT preciovip FROM configuracion WHERE idconfiguracion = 1");
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    return res.getDouble("preciovip");
                }
                pst.close();
                res.close();
            }

        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    //METODO PARA OBTENER EL PRECIO DE ENTRADA
    public int getProductoDefecto() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproductodefecto FROM configuracion WHERE idconfiguracion = 1");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt("idproductodefecto");
            }
            pst.close();
            res.close();

        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return -1;
    }
}
