
package Modelo;

/**
 *
 * @author Marce
 */
public class FlujoCaja {
    int idFlujoCaja, idUsuario, idCaja;
    String fecha;
    double ingresos, egresos, saldo;

    public FlujoCaja() {
    }

    public FlujoCaja(int idFlujoCaja, int idUsuario, int idCaja, String fecha, double ingresos, double egresos, double saldo) {
        this.idFlujoCaja = idFlujoCaja;
        this.idUsuario = idUsuario;
        this.idCaja = idCaja;
        this.fecha = fecha;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.saldo = saldo;
    }

    public int getIdFlujoCaja() {
        return idFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        this.idFlujoCaja = idFlujoCaja;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public double getEgresos() {
        return egresos;
    }

    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
