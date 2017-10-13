package Modelo;

public class VentaNota {

    int idVentaNota;
    int numPersonas;
    int numCovers;
    double total;
    String tipoEntrada;
    int idNotaPedido;
    int idProdPromocion;

    public VentaNota() {
    }

    public VentaNota(int idVentaNota, int numPersonas, int numCovers, double total, String tipoEntrada, int idNotaPedido, int idProdPromocion) {
        this.idVentaNota = idVentaNota;
        this.numPersonas = numPersonas;
        this.numCovers = numCovers;
        this.total = total;
        this.tipoEntrada = tipoEntrada;
        this.idNotaPedido = idNotaPedido;
        this.idProdPromocion = idProdPromocion;
    }

    public int getIdVentaNota() {
        return idVentaNota;
    }

    public void setIdVentaNota(int idVentaNota) {
        this.idVentaNota = idVentaNota;
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

    public int getIdNotaPedido() {
        return idNotaPedido;
    }

    public void setIdNotaPedido(int idNotaPedido) {
        this.idNotaPedido = idNotaPedido;
    }

    public int getIdProdPromocion() {
        return idProdPromocion;
    }

    public void setIdProdPromocion(int idProdPromocion) {
        this.idProdPromocion = idProdPromocion;
    }

    @Override
    public String toString() {
        return "VentaNota{" + "idVentaNota=" + idVentaNota + ", numPersonas=" + numPersonas + ", numCovers=" + numCovers + ", total=" + total + ", tipoEntrada=" + tipoEntrada + ", idNotaPedido=" + idNotaPedido + ", idProdPromocion=" + idProdPromocion + '}';
    }
    
}
