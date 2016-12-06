/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author toshiba
 */
public class Comprobante {

    int idcomprobante;
    String Fecha;
    String usuario;
    String cliente;
    int cantidad;
    double subTotal;
    String ruc;
    String direccion;
    String tipo_pago;
    double total;
    int idtipocomprobante;

  public Comprobante(){
      
  }

    public Comprobante(String Fecha, String usuario, String cliente, int cantidad, double subTotal, String ruc, String direccion, String tipo_pago, double total, int idtipocomprobante) {
        this.Fecha = Fecha;
        this.usuario = usuario;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.ruc = ruc;
        this.direccion = direccion;
        this.tipo_pago = tipo_pago;
        this.total = total;
        this.idtipocomprobante = idtipocomprobante;
    }

    public int getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(int idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdtipocomprobante() {
        return idtipocomprobante;
    }

    public void setIdtipocomprobante(int idtipocomprobante) {
        this.idtipocomprobante = idtipocomprobante;
    }
  
}
