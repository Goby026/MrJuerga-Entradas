package Interfaces;

import Modelo.UsuarioCaja;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface UsuarioCajaCRUD {

    public boolean Registrar(UsuarioCaja uc) throws Exception;

    public boolean Modificar(UsuarioCaja uc) throws Exception;

    public boolean Eliminar(UsuarioCaja uc) throws Exception;

    public List<UsuarioCaja> Listar() throws Exception;
}
