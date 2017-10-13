package Modelo;

public class VentaEntrada {

    int idVentaEntrada;
    int numPersonas;
    int numCovers;
    double total;
    String tipoEntrada;
    int idVenta;
    int idProd;
    String feha;

    public VentaEntrada(int idVentaEntrada, int numPersonas, int numCovers, double total, String tipoEntrada, int idVenta, int idProd, String fecha) {
        this.idVentaEntrada = idVentaEntrada;
        this.numPersonas = numPersonas;
        this.numCovers = numCovers;
        this.total = total;
        this.tipoEntrada = tipoEntrada;
        this.idVenta = idVenta;
        this.idProd = idProd;
        this.feha = fecha;
    }

    public VentaEntrada() {
    }

    public int getIdVentaEntrada() {
        return idVentaEntrada;
    }

    public void setIdVentaEntrada(int idVentaEntrada) {
        this.idVentaEntrada = idVentaEntrada;
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

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getFeha() {
        return feha;
    }

    public void setFeha(String feha) {
        this.feha = feha;
    }

    @Override
    public String toString() {
        return "VentaEntrada{" + "idVentaEntrada=" + idVentaEntrada + ", numPersonas=" + numPersonas + ", numCovers=" + numCovers + ", total=" + total + ", tipoEntrada=" + tipoEntrada + ", idVenta=" + idVenta + ", idProd=" + idProd + ", feha=" + feha + '}';
    }

}
