/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author bea
 */
public class VentaEntradaVip {
//    int idpromocion;
//    String producto;
//    int cantidadproducto;
//    String complemento;
//    int cantidadcomplemento;
//    double precio;
    
    int idVentaEntradaVip;
    int numPersonas;
    int numCovers;
    double total;
    String tipoEntrada;
    int idEntradaVip;
    int idProd;

    public VentaEntradaVip(int idVentaEntradaVip, int numPersonas, int numCovers, double total, String tipoEntrada, int idEntradaVip, int idProd) {
        this.idVentaEntradaVip = idVentaEntradaVip;
        this.numPersonas = numPersonas;
        this.numCovers = numCovers;
        this.total = total;
        this.tipoEntrada = tipoEntrada;
        this.idEntradaVip = idEntradaVip;
        this.idProd = idProd;
    }
    

    public VentaEntradaVip(){
        
    }

    public int getIdVentaEntradaVip() {
        return idVentaEntradaVip;
    }

    public void setIdVentaEntradaVip(int idVentaEntradaVip) {
        this.idVentaEntradaVip = idVentaEntradaVip;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public int getNumCovers() {
        return numCovers;
    }

    public void setNumCovers(int numCovers) {
        this.numCovers = numCovers;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getIdEntradaVip() {
        return idEntradaVip;
    }

    public void setIdEntradaVip(int idEntradaVip) {
        this.idEntradaVip = idEntradaVip;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }
    
    

}
