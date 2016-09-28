package Modelo;

import Interfaces.VentaEntradaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaEntradaDAO extends Conexion implements VentaEntradaCRUD{

    @Override
    public void registrar(VentaEntrada ve) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO `ventaentrada`(`numPersonas`, `numCovers`, `total`, `tipoEntrada`, `venta_idventa`) VALUES (?,?,?,?,?)");
            pst.setInt(1, ve.getNumPersonas());
            pst.setInt(2, ve.getNumCovers());
            pst.setDouble(3, ve.getTotal());
            pst.setString(4, ve.getTipoEntrada());
            pst.setInt(5, ve.getIdVenta());
            int res = pst.executeUpdate();
            if (res > 0) {
                System.out.println("Se registro la entrada");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error asd");
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void registrarEntrada(VentaEntrada ve) throws Exception {
        
    }

    @Override
    public void modificar(VentaEntrada ve) throws Exception {
        
    }

    @Override
    public void eliminar(VentaEntrada ve) throws Exception {
        
    }

    @Override
    public List<VentaEntrada> listar() throws Exception {
        List<VentaEntrada> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from ventaentrada");
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
