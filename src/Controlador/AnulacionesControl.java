
package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.Producto;
import Modelo.MySQLDAO.ProductoDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.Venta;
import Modelo.MySQLDAO.VentaDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class AnulacionesControl {

    

    public String[] CargarDatos(int numboleta) throws Exception {
        try {
            String[] datos = new String[6];
            VentaDAO vdao = new VentaDAO();
            for (Venta v : vdao.listar()) {
                if (v.getIdVenta() == numboleta) {
                    datos[0] = String.valueOf(numboleta);
                    datos[1] = "VENTA";
                    datos[2] = String.valueOf(v.getIdcaja());
                    datos[3] = String.valueOf(v.getIdUsuario());
                    datos[4] = v.getHora();
                    datos[5] = v.getFecha();
                    return datos;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }

    //METODO PARA OBTENER EL ID DEL USUARIO QUE REALIZO LA VENTA
    public int getidUsuario(int numboleta) throws Exception {
        try {
            VentaDAO vdao = new VentaDAO();
            for (Venta v : vdao.listar()) {
                if (v.getIdVenta() == numboleta) {
                    return v.getIdUsuario();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }
    
    /*METODO PARA OBTENER EL ID DE CAJA CON SU NOMBRE*/
    public int getIdCaja(String nomCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getNomCaja().equals(nomCaja)) {
                    return c.getIdCaja();
                }
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*METODO PARA OBTENER EL ID DE USUARIO CON EL NOMBRE*/
    public int getIdUsuario(String usuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    return u.getId();
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }

    //METODO PARA OBTENER EL NOMBRE DEL USUARIO QUE REALIZO LA VENTA CON SU ID
    public String getNomUsuario(int idUsuario) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getId() == idUsuario) {
                    return u.getNombre();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }
    
    /*METODO PARA OBTENER EL NOMBRE DE CAJA CON SU ID*/
    public String getCajaConId(int idCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getIdCaja() == idCaja) {
                    return c.getNomCaja();
                }
            }
            return "NULL de getCajaConId";
        } catch (Exception e) {
            throw e;
        }
    }

    //METODO PARA OBTENER EL ID DE PRODUCTO CON NOMBRE
    public int getIdProducto(String prod) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getNombre().equals(prod)) {
                    return p.getIdProducto();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return -1;
    }

    //METODO PARA OBTENER EL ID DE PRESENTACION CON NOMBRE
//    public int getIdPresentacion(String pres) throws Exception {
//        try {
//            PresentacionDAO pdao = new PresentacionDAO();
//            for (Presentacion p : pdao.Listar()) {
//                if (p.getDescripcion().equals(pres)) {
//                    return p.getIdPresentacion();
//                }
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return -1;
//    }

    //METODO PARA OBTENER EL ID DE PRODUCTOPRESENTACION CON IDPRODUCTO E IDPRESENTACION
//    public int getIdProductoPresentacion(String pres, String prod) throws Exception {
//        try {
//            ProductoPresentacionDAO pdao = new ProductoPresentacionDAO();
//            for (ProductoPresentacion pp : pdao.listar()) {
//                if (pp.getIdProducto() == getIdProducto(prod) && pp.getIdPresentacion() == getIdPresentacion(pres)) {
//                    return pp.getIdProductoPresentacion();
//                }
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return -1;
//    }
    
//    public int getStockProducto(int idProdPresentacion) throws Exception{
//        try {
//            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
//            for (ProductoPresentacion pp : ppdao.listar()) {
//                if (pp.getIdProductoPresentacion() == idProdPresentacion) {
//                    return pp.getStock();
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return -1;
//    }
    
    public boolean getEstadoDeVenta(int numVenta) throws Exception{
        try {
            VentaDAO vdao = new VentaDAO();
            for (Venta v : vdao.listar()) {
                if (v.getIdVenta()==numVenta && v.getEstado()>0) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

//    public void sumarStock(JTable tabla) throws Exception {
//        try {
//            for (int i = 0; i < tabla.getRowCount(); i++) {
//                String producto = tabla.getValueAt(i, 0).toString();
//                String presentacion = tabla.getValueAt(i, 1).toString();
//                int idProdPresentacion = getIdProductoPresentacion(presentacion, producto);
//                int stockDeTabla = Integer.parseInt(tabla.getValueAt(i, 3).toString());
//                int nuevoStock = getStockProducto(idProdPresentacion)+ stockDeTabla;
//                
////                new VentaProductoDAO().sumarStock(idProdPresentacion, nuevoStock);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }

//    public void cargarTabla(int numVenta, JTable tabla) throws Exception {
//        try {
//            cargarTitulosTabla(tabla);
//
//            Object[] columna = new Object[5];
//
//            for (int i = 0; i < new VentaProductoDAO().getDatosTabla(numVenta).size(); i++) {
//                columna[0] = new VentaProductoDAO().getDatosTabla(numVenta).get(i).getProducto();
//                columna[1] = new VentaProductoDAO().getDatosTabla(numVenta).get(i).getPresentacion();
//                columna[2] = new VentaProductoDAO().getDatosTabla(numVenta).get(i).getPrecio();
//                columna[3] = new VentaProductoDAO().getDatosTabla(numVenta).get(i).getCantidad();
//                columna[4] = new VentaProductoDAO().getDatosTabla(numVenta).get(i).getSubtotal();
//                modeloDetalle.addRow(columna);
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }

    

}
