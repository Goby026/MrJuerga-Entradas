package Modelo.MySQLDAO;

import Interfaces.FlujoCajaCRUD;
import Modelo.Conexion;
import Modelo.FlujoCaja;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class FlujoCajaDAO extends Conexion implements FlujoCajaCRUD {

    @Override
    public boolean Registrar(FlujoCaja fc) throws Exception {
        try {
            String sql = "INSERT INTO flujocaja(fecha_inicio,hora_inicio,fecha_final, hora_final,ingresos,egresos,saldo,visa,master,jarras,descuadre,idusuario,idcaja, estado)VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setDouble(8, fc.getVisa());
            pst.setDouble(9, fc.getMaster());
            pst.setDouble(10, fc.getJarras());
            pst.setDouble(11, fc.getDescuadre());
            pst.setInt(12, fc.getIdUsuario());
            pst.setInt(13, fc.getIdCaja());
            pst.setString(14, fc.getEstado());
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
    public boolean Modificar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("UPDATE caja flujocaja SET fecha_inicio = ?,hora_inicio=?,fecha_final=? ,hora_final=? ,ingresos = ?, egresos = ?, saldo = ?,visa=?,master=?,jarras=?,descuadre = ? ,idusuario = ?, idcaja = ?, estado= ? WHERE idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setDouble(8, fc.getVisa());
            pst.setDouble(9, fc.getMaster());
            pst.setDouble(10, fc.getJarras());
            pst.setDouble(11, fc.getDescuadre());
            pst.setInt(12, fc.getIdUsuario());
            pst.setInt(13, fc.getIdCaja());
            pst.setString(14, fc.getEstado());
            pst.setInt(15, fc.getIdFlujoCaja());
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
    public boolean Eliminar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("delete from flujocaja where idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdFlujoCaja());
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
    public List<FlujoCaja> Listar() throws Exception {
        List<FlujoCaja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FlujoCaja fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));
                fc.setFechaInicio(res.getString("fecha_inicio"));
                fc.setHoraInicio(res.getString("hora_inicio"));
                fc.setFechaFinal(res.getString("fecha_final"));
                fc.setHoraFinal(res.getString("hora_final"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setVisa(res.getDouble("visa"));
                fc.setMaster(res.getDouble("master"));
                fc.setJarras(res.getDouble("jarras"));
                fc.setDescuadre(res.getDouble("descuadre"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                fc.setEstado(res.getString("estado"));
                lista.add(fc);
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

    /* METODO PARA OBTENER EL ID DE FLUJO DE CAJA PARA LA VALIDACION  */
    public int getIdFlujo(int idUsuario, int idCaja) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idflujocaja) FROM flujocaja where idusuario= " + idUsuario + " and idcaja=" + idCaja + "");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt("MAX(idflujocaja)");
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

    /* METODO PARA CARGAR LAS VENTAS DESDE QUE SE APERTURA LA CAJA */
    public double getMontoFlujo(int idFlujoCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(ventaentrada.total) from entradageneral\n"
                    + "inner join ventaentrada on entradageneral.identradageneral = ventaentrada.venta_idventa \n"
                    + "where entradageneral.idflujocaja = " + idFlujoCaja + "");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(ventaentrada.total)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA OBTENER EL MONTO VISA DESDE QUE SE APERTURA LA CAJA */
    public double getMontoVISA(int idFlujoCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 3");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(subtotal)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA OBTENER EL MONTO MASTERCARD DESDE QUE SE APERTURA LA CAJA */
    public double getMontoMASTER(int idFlujoCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 2");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(subtotal)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA ACTUALIZAR EL FLUJO DE CAJA CUANDO SE CIERRE LA CAJA */
    public boolean updateFlujoCaja(FlujoCaja fc) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `flujocaja` SET `fecha_final`='" + fc.getFechaFinal() + "', `hora_final`='" + fc.getHoraFinal() + "', `ingresos`='" + fc.getIngresos() + "', egresos = " + fc.getEgresos() + ", saldo = " + fc.getSaldo() + ",descuadre = " + fc.getDescuadre() + " ,`estado`='0' WHERE `idflujocaja`='" + fc.getIdFlujoCaja() + "'");
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

    /* METODO PARA OBTENER EL TOTAL DE BONIFICACIONES */
    public double getCantidadBonos() throws Exception {
        double cantidad = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(ventaproducto.cantidad)\n"
                    + "from caja\n"
                    + "inner join flujocaja on caja.idcaja = flujocaja.idcaja\n"
                    + "inner join usuariocaja on caja.idcaja = usuariocaja.idcaja\n"
                    + "inner join usuario on usuariocaja.idusuario = usuario.idusuario\n"
                    + "inner join venta on usuario.idusuario = venta.idusuario\n"
                    + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                    + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "where flujocaja.estado = 1 and productopresentacion.precio >= 100");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                cantidad = res.getInt("sum(ventaproducto.cantidad)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return cantidad;
    }
    
    //obtener un flujo de caja a partir de su id
    public FlujoCaja obtener(int id) throws Exception {
        FlujoCaja fc = new FlujoCaja();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja WHERE idflujocaja = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));
                fc.setFechaInicio(res.getString("fecha_inicio"));
                fc.setHoraInicio(res.getString("hora_inicio"));
                fc.setFechaFinal(res.getString("fecha_final"));
                fc.setHoraFinal(res.getString("hora_final"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setVisa(res.getDouble("visa"));
                fc.setMaster(res.getDouble("master"));
                fc.setJarras(res.getDouble("jarras"));
                fc.setDescuadre(res.getDouble("descuadre"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                fc.setEstado(res.getString("estado"));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return fc;
    }
}
