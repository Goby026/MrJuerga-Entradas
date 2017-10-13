package Modelo.MySQLDAO;

import Interfaces.ProdPromocionCRUD;
import Modelo.Conexion;
import Modelo.ProdPromocion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class ProdPromocionDAO extends Conexion implements ProdPromocionCRUD {

    @Override
    public boolean registrar(ProdPromocion pp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `prodpromocion`(`idproductopresentacion`, `nomProd`, `cantidad`, `precio1`, `precio2`) VALUES (?,?,?,?,?)");
            pst.setInt(1, pp.getIdProductoPresentacion());
            pst.setString(2, pp.getNomProd());
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
    public boolean modificar(ProdPromocion pp) throws Exception {
        return false;

    }

    @Override
    public boolean eliminar(ProdPromocion pp) throws Exception {
        return false;

    }

    @Override
    public List<ProdPromocion> listar() throws Exception {
        List<ProdPromocion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select idprodpromocion, idproductopresentacion, nomProd, cantidad, precio1, precio2 from prodpromocion order by idprodpromocion");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProdPromocion pp = new ProdPromocion();
                pp.setIdProdPromocion(rs.getInt(1));
                pp.setIdProductoPresentacion(rs.getInt(2));
                pp.setNomProd(rs.getString(3));
                pp.setCantidad(rs.getInt(4));
                pp.setPrecio1(rs.getDouble(5));
                pp.setPrecio2(rs.getDouble(6));
                lista.add(pp);
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
    public ProdPromocion obtener(int id) throws Exception {
        return null;
    }
    
    public ProdPromocion obtener(int id, int opc) throws Exception {
        ProdPromocion pp = null;
        try {
            this.conectar();
            PreparedStatement pst = null;
            if (opc ==1) {
                 pst = this.conexion.prepareStatement("select idprodpromocion, idproductopresentacion, cantidad, precio1, precio2 from prodpromocion where idprodpromocion = ?");
            }else{
                 pst = this.conexion.prepareStatement("select idprodpromocion, idproductopresentacion, cantidad, precio1, precio2 from prodpromocion where idproductopresentacion = ?");
            }
            
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pp = new ProdPromocion();
                pp.setIdProdPromocion(rs.getInt(1));
                pp.setIdProductoPresentacion(rs.getInt(2));
                pp.setCantidad(rs.getInt(3));
                pp.setPrecio1(rs.getDouble(4));
                pp.setPrecio2(rs.getDouble(5));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return pp;
    }

    public boolean updatePrecio(double precio, int idProdPresentacion) throws Exception {
        try {
            this.conectar();
            String sql = "update prodpromocion set precio1=? where idproductopresentacion = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, precio);
            pst.setInt(2, idProdPresentacion);
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

}
