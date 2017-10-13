
package Controlador;

import Modelo.MySQLDAO.ProdPromocionDAO;
import Vista.VipNotaPedido;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grover
 */
public class VipNotaPedidoControl implements WindowListener, MouseListener{

    VipNotaPedido vnp;
    

    public VipNotaPedidoControl(VipNotaPedido vnp) {
        this.vnp = vnp;
        this.vnp.addWindowListener(this);
        this.vnp.tblBox.addMouseListener(this);
    }
    
    
    
    
    
    /* EVENTOS DE VENTANA */
    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource() == vnp) {
            try {
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
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
    
    /* EVENTOS DE MOUSE */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vnp.tblBox) {
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
