
package Interfaces;

import Modelo.ProdPromocion;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public interface ProdPromocionCRUD {
    
    public boolean registrar(ProdPromocion pp) throws Exception;

    public boolean modificar(ProdPromocion pp) throws Exception;

    public boolean eliminar(ProdPromocion pp) throws Exception;

    public List<ProdPromocion> listar() throws Exception;
    
    public ProdPromocion obtener(int id) throws Exception;
}
