package Modelo;

/**
 *
 * @author Marce
 */
public class Configuracion {

    private int idconfiguracion;
    private double precioVip;
    private double precioGeneral;
    private double dctGeneral;
    private double dctoFamiliar;
    private int idProfuctoDefecto;

    public Configuracion() {
    }

    public Configuracion(int idconfiguracion, int idProfuctoDefecto, double precioVip, double precioGeneral, double dctGeneral, double dctoFamiliar) {
        this.idconfiguracion = idconfiguracion;
        this.idProfuctoDefecto = idProfuctoDefecto;
        this.precioVip = precioVip;
        this.precioGeneral = precioGeneral;
        this.dctGeneral = dctGeneral;
        this.dctoFamiliar = dctoFamiliar;
    }

    public int getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(int idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public int getIdProfuctoDefecto() {
        return idProfuctoDefecto;
    }

    public void setIdProfuctoDefecto(int idProfuctoDefecto) {
        this.idProfuctoDefecto = idProfuctoDefecto;
    }

    public double getPrecioVip() {
        return precioVip;
    }

    public void setPrecioVip(double precioVip) {
        this.precioVip = precioVip;
    }

    public double getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(double precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public double getDctGeneral() {
        return dctGeneral;
    }

    public void setDctGeneral(double dctGeneral) {
        this.dctGeneral = dctGeneral;
    }

    public double getDctoFamiliar() {
        return dctoFamiliar;
    }

    public void setDctoFamiliar(double dctoFamiliar) {
        this.dctoFamiliar = dctoFamiliar;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "idconfiguracion=" + idconfiguracion + ", idProfuctoDefecto=" + idProfuctoDefecto + ", precioVip=" + precioVip + ", precioGeneral=" + precioGeneral + ", dctGeneral=" + dctGeneral + ", dctoFamiliar=" + dctoFamiliar + '}';
    }
}
