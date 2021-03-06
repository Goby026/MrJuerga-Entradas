/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.CierreCaja;
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

    //METODO PARA REGISTRAR ENTRADAS GENERAL DE SERIE 006
    public boolean RegistrarEntrada2(EntradaGeneral p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `EntradaGeneral2`(`fecha`, "
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
            pst.setInt(7, p.getTipopago());
            pst.setString(8, p.getnOperacion());
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
            String sqlAnularVenta = "UPDATE EntradaGeneral SET estado = 0 WHERE idEntradaGeneral = " + id + "";
            String sqlAnularDetalleVenta = "UPDATE ventaentrada SET numCovers = 0, total = 0 WHERE venta_idventa = " + id + "";
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

    public boolean AnularEntradaGeneral2(int id) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sqlAnularVenta = "UPDATE EntradaGeneral2 SET estado = 0 WHERE idEntradaGeneral2 = " + id + "";
            String sqlAnularDetalleVenta = "UPDATE ventaentrada2 SET numCovers = 0, total = 0 WHERE venta_idventa = " + id + "";
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

    public List<EntradaGeneral> ListarEntradaGeneral2() throws Exception {
        List<EntradaGeneral> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from EntradaGeneral2");
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
        EntradaGeneral v = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from EntradaGeneral where identradageneral = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                v = new EntradaGeneral();
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
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return v;
    }

    public EntradaGeneral ObtenerEntradaGeneral2(int id) throws Exception {
        EntradaGeneral v = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from EntradaGeneral2 where identradageneral2 = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                v = new EntradaGeneral();
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
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return v;
    }

    public int getIdDeUltimaEntradaGeneralRegistrada() throws Exception {
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
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    public int getIdDeUltimaEntradaGeneral2Registrada() throws Exception {
        try {
            this.conectar();
            String sql = "SELECT idEntradaGeneral2 FROM EntradaGeneral2 ORDER BY idEntradaGeneral2 DESC LIMIT 1";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return res.getInt(1);
            }

            pst.close();
            res.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    //metodo para contar las filas para la impresion del reporte de cierre de entrada general
    public List<CierreCaja> numRegistrosCierre(int idFlujoCaja) throws Exception {
        List<CierreCaja> lista = null;
        CierreCaja v = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select usuario.usuario, producto.nombre, sum(ventaentrada.numCovers) as cantcover, sum(ventaentrada.total) as total\n"
                    + "from entradageneral\n"
                    + "inner join ventaentrada on entradageneral.identradageneral = ventaentrada.venta_idventa\n"
                    + "inner join productopresentacion on ventaentrada.idproducto = productopresentacion.idproductopresentacion\n"
                    + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                    + "inner join usuario on entradageneral.idusuario = usuario.idusuario\n"
                    + "where entradageneral.idflujocaja = ? \n"
                    + "group by producto.nombre");
            
            pst.setInt(1, idFlujoCaja);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                v = new CierreCaja();
                v.setUsuario(rs.getString(1));
                v.setProducto(rs.getString(2));
                v.setCantCover(rs.getInt(3));
                v.setTotal(rs.getDouble(4));
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

}
