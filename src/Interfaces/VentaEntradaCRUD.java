
package Interfaces;

import Modelo.VentaEntrada;
import java.util.List;


public interface VentaEntradaCRUD {
    public boolean registrar(VentaEntrada ve) throws Exception;
    public boolean modificar(VentaEntrada ve) throws Exception;
    public void eliminar(VentaEntrada ve) throws Exception;
    public List<VentaEntrada> listar() throws Exception;
}
