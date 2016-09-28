package Interfaces;

import Modelo.Usuario;
import java.util.List;

public interface UsuarioCRUD {

    public void registrar(Usuario u) throws Exception;

    public void modificar(Usuario u) throws Exception;

    public void eliminar(Usuario u) throws Exception;

    public List<Usuario> listar() throws Exception;
}
