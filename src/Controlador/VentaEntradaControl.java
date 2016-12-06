package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.VentaEntradaDAO;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author g0by
 */
public class VentaEntradaControl {

    public void LlenarTabla(JTable tabla) throws Exception {

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        VentaEntradaDAO ved = new VentaEntradaDAO();

        modelo.addColumn("ID");
        modelo.addColumn("N° PERSONAS");
        modelo.addColumn("N° COVERS");
        modelo.addColumn("TOTAL");
        modelo.addColumn("TIPO ENTRADA");

        Object[] columna = new Object[5];

        int numeroRegistros = ved.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ved.listar().get(i).getIdVenta();
            columna[1] = ved.listar().get(i).getNumPersonas();
            columna[2] = ved.listar().get(i).getNumCovers();
            columna[3] = ved.listar().get(i).getTotal();
            columna[4] = ved.listar().get(i).getTipoEntrada();
            modelo.addRow(columna);
        }
    }
    
    //METODO PARA VALIDAR SI EXISTE CLIENTE SINO CREAMOS UNO LLAMADO MRJUERGA
    public boolean VerificarClientes() throws Exception{
        try {
            ClienteDAO cdao = new ClienteDAO();
            if (cdao.Listar().size()>0) {
                return true;
            }else{
                Cliente c = new Cliente();
                c.setIdcliente(1);
                c.setNombre("MRJUERGA");
                c.setApellido("HYO");
                c.setDni("12345678");
                c.setDireccion("JR. AYACUCHO 760");
                c.setTelefono("585452");
                cdao.Registrar(c);
                return false;
            }
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
    
    //REGISTRAR COMPROBANTE
    public boolean regComprobante(String fecha, String usuario, String cliente, int cantidad, double subtotal, String ruc, String direccion, String tipoDePago, double total, int tipoComprobante) throws Exception{
        try {
            Comprobante c = new Comprobante(fecha, usuario, cliente, cantidad, subtotal, ruc, direccion, tipoDePago, total, tipoComprobante);
            ComprobanteDAO cdao = new ComprobanteDAO();
            if (cdao.Registrar(c)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }        
    }
}