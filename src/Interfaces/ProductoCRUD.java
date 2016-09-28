package Interfaces;

import Modelo.Producto;
import java.util.List;

public interface ProductoCRUD {

    public void registrar(Producto p) throws Exception;

    public void modificar(Producto p) throws Exception;

    public void eliminar(Producto p) throws Exception;

    public List<Producto> listar() throws Exception;
}
