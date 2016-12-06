/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.FlujoCaja;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface FlujoCajaCRUD {

    public boolean Registrar(FlujoCaja fc) throws Exception;

    public boolean Modificar(FlujoCaja fc) throws Exception;

    public boolean Eliminar(FlujoCaja fc) throws Exception;

    public List<FlujoCaja> Listar() throws Exception;
}
