package Modelo;

public class VentaEntrada {
    int idVentaEntrada;
    int numPersonas;
    int numCovers;
    double total;
    String tipoEntrada;
    int idVenta;

    public VentaEntrada(int idVentaEntrada, int numPersonas, int numCovers, double total, String tipoEntrada, int idVenta) {
        this.idVentaEntrada = idVentaEntrada;
        this.numPersonas = numPersonas;
        this.numCovers = numCovers;
        this.total = total;
        this.tipoEntrada = tipoEntrada;
        this.idVenta = idVenta;
    }
    
    public VentaEntrada(){
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
    
    
}
