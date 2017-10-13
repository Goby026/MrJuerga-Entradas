
package Modelo;

/**
 *
 * @author MARCEL
 */
public class ProdPromocion {
    int idProdPromocion;
    int idProductoPresentacion;
    String nomProd;
    int cantidad;
    double precio1;
    double precio2;

    public ProdPromocion() {
    }

    public ProdPromocion(int idProdPromocion, int idProductoPresentacion, String nomProd, int cantidad, double precio1, double precio2) {
        this.idProdPromocion = idProdPromocion;
        this.idProductoPresentacion = idProductoPresentacion;
        this.nomProd = nomProd;
        this.cantidad = cantidad;
        this.precio1 = precio1;
        this.precio2 = precio2;
    }

    public int getIdProdPromocion() {
        return idProdPromocion;
    }

    public void setIdProdPromocion(int idProdPromocion) {
        this.idProdPromocion = idProdPromocion;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio1() {
        return precio1;
    }

    public void setPrecio1(double precio1) {
        this.precio1 = precio1;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    @Override
    public String toString() {
        return "ProdPromocion{" + "idProdPromocion=" + idProdPromocion + ", idProductoPresentacion=" + idProductoPresentacion + ", nomProd=" + nomProd + ", cantidad=" + cantidad + ", precio1=" + precio1 + ", precio2=" + precio2 + '}';
    }

    
}
