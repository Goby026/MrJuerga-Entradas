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
    String producto;
    int cantidadproducto;
    String complemento;
    int cantidadcomplemento;
    double precio;
    
    public VentaEntradaVip( String producto, int cantidadproducto, String complemento , int cantidadcomplemento, double precio){
//        this.idpromocion=idpromocion;
        this. producto=producto;
        this.cantidadproducto=cantidadproducto;
        this.complemento=complemento;
        this.cantidadcomplemento=cantidadcomplemento;
        this.precio=precio;
              
        
    }
    public VentaEntradaVip(){
        
    }

 

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCantidadcomplemento() {
        return cantidadcomplemento;
    }

    public void setCantidadcomplemento(int cantidadcomplemento) {
        this.cantidadcomplemento = cantidadcomplemento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
