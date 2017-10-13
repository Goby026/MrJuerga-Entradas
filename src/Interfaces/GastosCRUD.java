/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Gasto;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface GastosCRUD {
    
    public boolean Registrar(Gasto g)throws Exception;
    public boolean Modificar(Gasto g)throws Exception;
    public boolean Eliminar(Gasto g)throws Exception;
    public List<Gasto> Listar()throws Exception;
}

