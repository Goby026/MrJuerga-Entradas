/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface ClienteCRUD {
      public boolean Registrar(Cliente c) throws Exception;
    public boolean Modificar(Cliente c) throws Exception;
    public void Eliminar(Cliente c) throws Exception;
    public List <Cliente> Listar() throws Exception;
}
