
package Interfaces;

import Modelo.NotaPedido;
import java.util.List;

public interface NotaPedidoCRUD {
    public boolean registrar(NotaPedido np) throws Exception;

    public boolean modificar(NotaPedido np) throws Exception;

    public boolean anular(int id) throws Exception;

    public List<NotaPedido> listar() throws Exception;
    
    public NotaPedido obtener(int id) throws Exception;            
    
    
}
