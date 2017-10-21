package Modelo.MySQLDAO;

import Interfaces.VentaNotaCRUD;
import Modelo.Conexion;
import Modelo.VentaNota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaNotaDAO extends Conexion implements VentaNotaCRUD {

    @Override
    public boolean registrar(VentaNota vn) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `ventanota`(`numPersonas`, `numCovers`, `total`, `tipoEntrada`, `idnotapedido`, `idprodpromocion`) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, vn.getNumPersonas());
            pst.setInt(2, vn.getNumCovers());
            pst.setDouble(3, vn.getTotal());
            pst.setString(4, vn.getTipoEntrada());
            pst.setInt(5, vn.getIdNotaPedido());
            pst.setInt(6, vn.getIdProdPromocion());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(VentaNota vn) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `ventanota`SET numPersonas = ?, numCovers =?, total=?,tipoEntrada=?,idnotapedido=?, idprodpromocion=?  WHERE idventanota=?");
            pst.setInt(1, vn.getNumPersonas());
            pst.setInt(2, vn.getNumCovers());
            pst.setDouble(3, vn.getTotal());
            pst.setString(4, vn.getTipoEntrada());
            pst.setInt(5, vn.getIdNotaPedido());
            pst.setInt(6, vn.getIdProdPromocion());
            pst.setInt(7, vn.getIdVentaNota());
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
    public boolean anular(int id) throws Exception {
        try {
            String sql = ("UPDATE `ventanota`SET numPersonas = 0, numCovers =0, total=0 WHERE idventanota=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
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
    public List<VentaNota> listar() throws Exception {
        List<VentaNota> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ventanota");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VentaNota vn = new VentaNota();
                vn.setIdVentaNota(rs.getInt("idventanota"));
                vn.setNumPersonas(rs.getInt("numPersonas"));
                vn.setNumCovers(rs.getInt("numCovers"));
                vn.setTotal(rs.getDouble("total"));
                vn.setTipoEntrada(rs.getString("tipoEntrada"));
                vn.setIdNotaPedido(rs.getInt("idnotapedido"));
                vn.setIdProdPromocion(rs.getInt("idprodpromocion"));
                lista.add(vn);
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

//    public List<VentaEntrada> ultimasEntradasVendidas(int idflujocaja) throws Exception {
//        List<VentaEntrada> lista = null;
//        try {
//            this.conectar();
//            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ventaentrada");
//            lista = new ArrayList();
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                VentaNota vn = new VentaEntrada();
//                vn.setIdVentaEntrada(rs.getInt("idventaEntrada"));
//                vn.setNumPersonas(rs.getInt("numPersonas"));
//                vn.setNumCovers(rs.getInt("numCovers"));
//                vn.setTotal(rs.getDouble("total"));
//                vn.setTipoEntrada(rs.getString("tipoEntrada"));
//                vn.setIdVenta(rs.getInt("venta_idventa"));
//                vn.setIdProd(rs.getInt("idproducto"));
//                vn.setFeha(rs.getString("fecha"));
//                lista.add(ve);
//            }
//            rs.close();
//            pst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }
    @Override
    public VentaNota obtener(int id) throws Exception {
        VentaNota vn = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from ventanota where idventanota = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                vn = new VentaNota();
                vn.setIdVentaNota(rs.getInt("idventanota"));
                vn.setNumPersonas(rs.getInt("numPersonas"));
                vn.setNumCovers(rs.getInt("numCovers"));
                vn.setTotal(rs.getDouble("total"));
                vn.setTipoEntrada(rs.getString("tipoEntrada"));
                vn.setIdNotaPedido(rs.getInt("idnotapedido"));
                vn.setIdProdPromocion(rs.getInt("idprodpromocion"));
            }
            rs.close();
            pst.close();
            return vn;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public double getTotalNotaPedido(int flujoCaja) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(ventanota.total)\n"
                    + "from notapedido\n"
                    + "inner join ventanota on notapedido.idnotapedido = ventanota.idnotapedido\n"
                    + "where notapedido.idflujocaja = ?");
            pst.setInt(1, flujoCaja);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getDouble("sum(ventanota.total)");
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return 0;
    }
}
