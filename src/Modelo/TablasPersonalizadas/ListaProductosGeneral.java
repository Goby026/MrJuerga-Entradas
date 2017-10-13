
package Modelo.TablasPersonalizadas;

/**
 *
 * @author Grover
 */
public class ListaProductosGeneral {
    int idVenta;
    String producto;
    double monto;

    public ListaProductosGeneral() {
    }

    public ListaProductosGeneral(int idVenta, String producto, double monto) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.monto = monto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "ListaProductosGeneral{" + "idVenta=" + idVenta + ", producto=" + producto + ", monto=" + monto + '}';
    }
    
    
}
