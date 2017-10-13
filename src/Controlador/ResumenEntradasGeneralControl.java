
package Controlador;

import Modelo.MySQLDAO.FlujoCajaDAO;
import Modelo.MySQLDAO.VentaEntradaDAO;
import Vista.ResumenEntradasGeneral;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grover
 */
public class ResumenEntradasGeneralControl implements WindowListener{

    ResumenEntradasGeneral reg;
    String usuario;
    DefaultTableModel modelo;

    public ResumenEntradasGeneralControl(ResumenEntradasGeneral reg, String usuario) {
        this.reg = reg;
        this.usuario = usuario;
        this.reg.addWindowListener(this);
    }
    
    public void titulosColumnas(){
        String cabecera[] = {"VENTA","PRODUCTO","MONTO"};
        modelo = new DefaultTableModel(null, cabecera);
        reg.tblEntradas.setModel(modelo);
    }
    
    public void LlenarTablaBuscarProductos(int idFlujoCaja, int idCaja) throws Exception {
        titulosColumnas();
        VentaEntradaDAO ppdao = new VentaEntradaDAO();

        Object[] columna = new Object[3];

        int numeroRegistros = ppdao.ultimasEntradasVendidas(idFlujoCaja, idCaja).size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ppdao.ultimasEntradasVendidas(idFlujoCaja, idCaja).get(i).getIdVenta();
            columna[1] = ppdao.ultimasEntradasVendidas(idFlujoCaja, idCaja).get(i).getProducto();
            columna[2] = ppdao.ultimasEntradasVendidas(idFlujoCaja, idCaja).get(i).getMonto();
            modelo.addRow(columna);
        }
        reg.tblEntradas.setModel(modelo);
        new ColumnasTablas().tresColumnas(reg.tblEntradas, 10, 100, 100);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource()==reg) {
            try {
                reg.txtUsuario.setText(this.usuario);
                reg.txtCaja.setText(new AbrirCajaControl().getCajaDeUsuario(this.usuario));
                int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(this.usuario), new CerrarCajaControl().getIdCaja(reg.txtCaja.getText()));
                LlenarTablaBuscarProductos(idFlujoCaja, new CerrarCajaControl().getIdCaja(reg.txtCaja.getText()));
            } catch (Exception ex) {
                Logger.getLogger(ResumenEntradasGeneralControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
