
package Interfaces;

import Modelo.Venta;
import java.util.List;

public interface VentaCRUD {
    public boolean registrar(Venta v) throws Exception;

    public boolean modificar(Venta v) throws Exception;

    public boolean anular(int numVenta) throws Exception;

    public List<Venta> listar() throws Exception;
}
