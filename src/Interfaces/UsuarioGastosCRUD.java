/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.UsuarioGastos;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface UsuarioGastosCRUD {
    public boolean registrar(UsuarioGastos ug) throws Exception;

    public boolean modificar(UsuarioGastos ug) throws Exception;

    public boolean eliminar(UsuarioGastos ug) throws Exception;

    public List<UsuarioGastos> listar() throws Exception;
}
