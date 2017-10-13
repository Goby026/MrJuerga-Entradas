package Modelo.MySQLDAO;

import Interfaces.VentaEntradaCRUD;
import Modelo.Conexion;
import Modelo.TablasPersonalizadas.ListaProductosGeneral;
import Modelo.VentaEntrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaEntradaDAO extends Conexion implements VentaEntradaCRUD {

    @Override
    public boolean registrar(VentaEntrada ve) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `ventaentrada`(`numPersonas`, `numCovers`, `total`, `tipoEntrada`, `venta_idventa`, `idproducto`) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, ve.getNumPersonas());
            pst.setInt(2, ve.getNumCovers());
            pst.setDouble(3, ve.getTotal());
            pst.setString(4, ve.getTipoEntrada());
            pst.setInt(5, ve.getIdVenta());
            pst.setInt(6, ve.getIdProd());
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
    public boolean modificar(VentaEntrada ve) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `ventaentrada`SET numPersonas = ?, numCovers =?, total=?,tipoEntrada=?,idproducto=?  WHERE venta_idventa=?");
            pst.setInt(1, ve.getNumPersonas());
            pst.setInt(2, ve.getNumCovers());
            pst.setDouble(3, ve.getTotal());
            pst.setString(4, ve.getTipoEntrada());
            pst.setInt(5, ve.getIdProd());
            pst.setInt(6, ve.getIdVenta());
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
    public void eliminar(VentaEntrada ve) throws Exception {
        try {
            boolean b = false;
            String sql = ("delete from ventaentrada where idventaEntrada=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ve.getIdVentaEntrada());
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
    public List<VentaEntrada> listar() throws Exception {
        List<VentaEntrada> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM ventaentrada");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VentaEntrada ve = new VentaEntrada();
                ve.setIdVentaEntrada(rs.getInt("idventaEntrada"));
                ve.setNumPersonas(rs.getInt("numPersonas"));
                ve.setNumCovers(rs.getInt("numCovers"));
                ve.setTotal(rs.getDouble("total"));
                ve.setTipoEntrada(rs.getString("tipoEntrada"));
                ve.setIdVenta(rs.getInt("venta_idventa"));
                ve.setIdProd(rs.getInt("idproducto"));
                ve.setFeha(rs.getString("fecha"));
                lista.add(ve);
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

    
    public List<ListaProductosGeneral> ultimasEntradasVendidas(int idflujocaja, int idCaja) throws Exception {
        List<ListaProductosGeneral> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select venta.idventa, producto.nombre, ventaentrada.total from venta\n"
                    + "inner join ventaentrada on venta.idventa = ventaentrada.venta_idventa\n"
                    + "inner join productopresentacion on ventaentrada.idproducto = productopresentacion.idproducto\n"
                    + "inner join producto on productopresentacion.idproducto = producto.idProducto\n"
                    + "where venta.idflujocaja = ? and venta.idcaja = ?");
            pst.setInt(1, idflujocaja);
            pst.setInt(2, idCaja);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ListaProductosGeneral ve = new ListaProductosGeneral();
                ve.setIdVenta(rs.getInt(1));
                ve.setProducto(rs.getString(2));
                ve.setMonto(rs.getInt(3));
                lista.add(ve);
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
