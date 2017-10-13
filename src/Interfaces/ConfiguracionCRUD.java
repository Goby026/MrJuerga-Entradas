
package Interfaces;

import Modelo.Configuracion;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface ConfiguracionCRUD {
    public boolean Registrar(Configuracion c) throws Exception;

    public boolean Modificar(Configuracion c) throws Exception;

    public boolean Eliminar(Configuracion c) throws Exception;

    public List<Configuracion> Listar() throws Exception;    
    
}
