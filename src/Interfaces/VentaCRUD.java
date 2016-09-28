
package Interfaces;

import Modelo.Venta;
import java.util.ArrayList;
import java.util.List;


public interface VentaCRUD {
    public void registrar(Venta v) throws Exception;
    public void registrarEntrada(Venta v) throws Exception;
    public void modificar(Venta v) throws Exception;
    public void eliminar(Venta v) throws Exception;
    public List<Venta> listar() throws Exception;
    
}
