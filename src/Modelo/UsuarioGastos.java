
package Modelo;

/**
 *
 * @author Marce
 */
public class UsuarioGastos {
    int idUsuarioGastos, idGastos, idUsuario, idFlujoCaja;
    double monto;
    String fecha, hora, observacion;

    public UsuarioGastos() {
    }

    public UsuarioGastos(int idUsuarioGastos, int idGastos, int idUsuario, int idFlujoCaja, double monto, String fecha, String hora, String observacion) {
        this.idUsuarioGastos = idUsuarioGastos;
        this.idGastos = idGastos;
        this.idUsuario = idUsuario;
        this.idFlujoCaja = idFlujoCaja;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
    }

    public int getIdUsuarioGastos() {
        return idUsuarioGastos;
    }

    public void setIdUsuarioGastos(int idUsuarioGastos) {
        this.idUsuarioGastos = idUsuarioGastos;
    }

    public int getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(int idGastos) {
        this.idGastos = idGastos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdFlujoCaja() {
        return idFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        this.idFlujoCaja = idFlujoCaja;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
