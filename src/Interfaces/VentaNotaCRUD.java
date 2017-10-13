
package Interfaces;

import Modelo.VentaNota;
import java.util.List;

public interface VentaNotaCRUD {
    public boolean registrar(VentaNota vn) throws Exception;

    public boolean modificar(VentaNota vn) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<VentaNota> listar() throws Exception;
    
    public VentaNota obtener(int id) throws Exception;            
    
    
}
