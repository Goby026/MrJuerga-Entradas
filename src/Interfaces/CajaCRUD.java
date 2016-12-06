
package Interfaces;

import Modelo.Caja;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface CajaCRUD {
    public boolean Registrar(Caja c) throws Exception;
    public boolean Modificar(Caja c)throws Exception;
    public boolean Eliminar(Caja c)throws Exception;
    public List<Caja>Listar()throws Exception;
}
