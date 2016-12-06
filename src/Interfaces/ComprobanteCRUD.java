/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Comprobante;

import java.util.List;

/**
 *
 * @author toshiba
 */
public interface ComprobanteCRUD {

    public boolean Registrar(Comprobante c) throws Exception;

    public boolean Modificar(Comprobante c) throws Exception;

    public boolean Anular(Comprobante c) throws Exception;

    public List<Comprobante> Listar() throws Exception;

}
