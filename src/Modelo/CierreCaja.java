
package Modelo;

/**
 *
 * @author MARCEL
 */
public class CierreCaja {
    private String usuario;
    private String producto;
    private int cantCover;
    private double total ;

    public CierreCaja() {
    }

    public CierreCaja(String usuario, String producto, int cantCover, double total) {
        this.usuario = usuario;
        this.producto = producto;
        this.cantCover = cantCover;
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantCover() {
        return cantCover;
    }

    public void setCantCover(int cantCover) {
        this.cantCover = cantCover;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
