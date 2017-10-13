/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.CajaCRUD;
import Modelo.Caja;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class CajaDAO extends Conexion implements CajaCRUD {

    @Override
    public boolean Registrar(Caja c) throws Exception {
        try {
            String sql = "INSERT INTO caja(nomcaja)VALUE (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNomCaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Caja c) throws Exception {
        try {
            String sql = ("UPDATE caja set nomcaja = ? where idcaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNomCaja());
            pst.setInt(2, c.getIdCaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Caja c) throws Exception {
        try {            
            String sql = ("delete from caja where idcaja=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, c.getIdCaja());

            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Caja> Listar() throws Exception {
        List<Caja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM caja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Caja c = new Caja();
                c.setIdCaja(res.getInt("idcaja"));
                c.setNomCaja(res.getString("nomcaja"));
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
    
    public int getIdCaja(String nomCaja) throws Exception {        
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idcaja FROM caja WHERE nomcaja = '"+nomCaja+"'");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt("idcaja");
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
