/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.VentaEntradaVip;
import java.util.List;

/**
 *
 * @author USER
 */
public interface VentaEntradaVipCRUD {
    public void registrar(VentaEntradaVip vevip) throws Exception;
    public void modificar(VentaEntradaVip vevip) throws Exception;
    public void eliminar(VentaEntradaVip vevip) throws Exception;
    public List<VentaEntradaVip> listar() throws Exception;
}
