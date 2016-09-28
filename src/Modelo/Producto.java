
package Modelo;

import java.util.Date;

public class Producto {
    int idProducto, stock, idCategoria, idPresentacion;
    String nombre, imagen;
    double precio;
    Date fechaVencimiento;
    
    public Producto(){
    }

    public Producto(int idProducto, int stock, int idCategoria, int idPresentacion, String nombre, String imagen, double precio, Date fechaVencimiento) {
        this.idProducto = idProducto;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idPresentacion = idPresentacion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
}
