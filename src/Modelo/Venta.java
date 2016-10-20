
package Modelo;


public class Venta {
    int idVenta;
    String fecha;
    String hora;
    int idUsuario;
    int idCliente;
    int idComprobante;
    int estado;
    int idcaja;

    public Venta(String fecha, String hora, int idUsuario, int idCliente, int idComprobante, int estado, int idcaja) {
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idComprobante = idComprobante;
        this.estado = estado;
        this.idcaja = idcaja;
    }
    
    public Venta(){
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }
    
    
}
