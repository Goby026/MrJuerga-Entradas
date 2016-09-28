
package Interfaces;

import Modelo.VentaEntrada;
import java.util.List;


public interface VentaEntradaCRUD {
    public void registrar(VentaEntrada ve) throws Exception;
    public void registrarEntrada(VentaEntrada ve) throws Exception;
    public void modificar(VentaEntrada ve) throws Exception;
    public void eliminar(VentaEntrada ve) throws Exception;
    public List<VentaEntrada> listar() throws Exception;
}
