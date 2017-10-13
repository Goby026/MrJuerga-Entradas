package Modelo;

public class Venta {

    int idVenta;
    String fecha;
    String hora;
    int idUsuario;
    int idCliente;
    int idTipoComprobante;
    int tipopago;
    String nOperacion;
    int estado, idcaja, idFlujoCaja;

    public Venta() {
    }

    public Venta(int idVenta, String fecha, String hora, int idUsuario, int idCliente, int idTipoComprobante, int tipopago, String nOperacion, int estado, int idcaja, int idFlujoCaja) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idTipoComprobante = idTipoComprobante;
        this.tipopago = tipopago;
        this.nOperacion = nOperacion;
        this.estado = estado;
        this.idcaja = idcaja;
        this.idFlujoCaja = idFlujoCaja;
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

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public int getTipopago() {
        return tipopago;
    }

    public void setTipopago(int tipopago) {
        this.tipopago = tipopago;
    }

    public String getnOperacion() {
        return nOperacion;
    }

    public void setnOperacion(String nOperacion) {
        this.nOperacion = nOperacion;
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

    public int getIdFlujoCaja() {
        return idFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        this.idFlujoCaja = idFlujoCaja;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", hora=" + hora + ", idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", idTipoComprobante=" + idTipoComprobante + ", tipopago=" + tipopago + ", nOperacion=" + nOperacion + ", estado=" + estado + ", idcaja=" + idcaja + ", idFlujoCaja=" + idFlujoCaja + '}';
    }
    
    
}
