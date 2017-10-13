/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.GastosCRUD;
import Modelo.Conexion;
import Modelo.Gasto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class GastoDAO extends Conexion implements GastosCRUD {

    @Override
    public boolean Registrar(Gasto g) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO gastos(concepto,monto) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, g.getConcepto());
            pst.setDouble(2, g.getMonto());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();
           
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Gasto g) throws Exception {
        boolean b = false;

        try {
            String sql = "UPDATE gastos SET concepto = ? ,monto = ?  WHERE idgastos = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, g.getConcepto());
            pst.setDouble(2, g.getMonto());
            pst.setInt(3, g.getIdgastos());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Eliminar(Gasto g) throws Exception {
        boolean b = false;

        try {
            String sql = "DELETE FROM gastos WHERE idgastos = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, g.getIdgastos());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public List<Gasto> Listar() throws Exception {
        List<Gasto> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM gastos");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Gasto g = new Gasto();
                g.setIdgastos(res.getInt("idgastos"));
                g.setConcepto(res.getString("concepto"));
                g.setMonto(res.getDouble("monto"));
                li.add(g);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }

        return li;
    }
}
