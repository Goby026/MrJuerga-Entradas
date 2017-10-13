/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.EntradaGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class EntradaGeneralDAO extends Conexion implements DAO<EntradaGeneral> {

    @Override
    public boolean Registrar(EntradaGeneral p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `EntradaGeneral`(`fecha`, "
                    + "`hora`, `idusuario`, `idcliente`, `idtipocomprobante`, `estado`, `tipopago`, "
                    + "`noperacion`, `idcaja`, `idflujocaja`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdUsuario());
            pst.setInt(4, p.getIdCliente());
            pst.setInt(5, p.getIdTipoComprobante());
            pst.setInt(6, p.getEstado());
            pst.setInt(7, p.getTipopago());
            pst.setString(8, p.getnOperacion());
            pst.setInt(9, p.getIdCaja());
            pst.setInt(10, p.getIdFlujoCaja());

            if (pst.executeUpdate() > 0) {
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
    public boolean Modificar(EntradaGeneral p) throws Exception {
        try {
            String sql = "UPDATE EntradaGeneral SET fecha=?, hora=?, idusuario=?, idcliente=?, idtipocomprobante=?, estado=?, tipopago = ?,noperacion = ? ,idcaja = ? ,idflujocaja = ? WHERE idEntradaGeneral = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdUsuario());
            pst.setInt(4, p.getIdCliente());
            pst.setInt(5, p.getIdTipoComprobante());
            pst.setInt(6, p.getEstado());
            pst.setInt(7,p.getTipopago());
            pst.setString(8,p.getnOperacion());
            pst.setInt(9, p.getIdCaja());
            pst.setInt(10, p.getIdFlujoCaja());
            pst.setInt(11, p.getIdEntradaGeneral());
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
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Anular(int id) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sqlAnularVenta = "UPDATE EntradaGeneral SET estado = 0 WHERE idEntradaGeneral = "+id+"";
            String sqlAnularDetalleVenta = "UPDATE ventaentrada SET numCovers = 0, total = 0 WHERE venta_idventa = "+id+"";
            this.conectar();
            
            PreparedStatement pst = this.conexion.prepareStatement(sqlAnularVenta);
            PreparedStatement pst2 = this.conexion.prepareStatement(sqlAnularDetalleVenta);
            
            int res = pst.executeUpdate();
            int res2 = pst2.executeUpdate();
            
            if (res > 0 && res2 > 0) {
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
    public List<EntradaGeneral> Listar() throws Exception {
        List<EntradaGeneral> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from EntradaGeneral");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                EntradaGeneral v = new EntradaGeneral();
                v.setIdEntradaGeneral(rs.getInt(1));
                v.setFecha(rs.getString(2));
                v.setHora(rs.getString(3));
                v.setIdUsuario(rs.getInt(4));
                v.setIdCliente(rs.getInt(5));
                v.setIdTipoComprobante(rs.getInt(6));
                v.setEstado(rs.getInt(7));
                v.setTipopago(rs.getInt(8));
                v.setnOperacion(rs.getString(9));
                v.setIdCaja(rs.getInt(10));
                v.setIdFlujoCaja(rs.getInt(11));
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
    public EntradaGeneral Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdDeUltimaEntradaGeneralRegistrada() throws Exception{
        try {
            this.conectar();
            String sql = "SELECT idEntradaGeneral FROM EntradaGeneral ORDER BY idEntradaGeneral DESC LIMIT 1";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            if (res.next()) {
                return res.getInt(1);
            }
            
            pst.close();
            res.close();
            
        } catch (Exception e) {
            throw  e;
        }finally{
            this.cerrar();
        }
        return -1;
    }

}
