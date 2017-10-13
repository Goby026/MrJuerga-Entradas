package Modelo;

public class NotaPedido {

    private int idNotaPedido;
    private String fecha;
    private String hora;
    private int idUsuario;
    private int idcliente;
    private int idTipoComprobante;
    private int tipopago;
    private String nOperacion;
    private int estado, idcaja, idFlujoCaja;

    public NotaPedido() {
    }

    public NotaPedido(int idNotaPedido, String fecha, String hora, int idUsuario, int idcliente,int idTipoComprobante, int tipopago, String nOperacion, int estado, int idcaja, int idFlujoCaja) {
        this.idNotaPedido = idNotaPedido;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idcliente = idcliente;
        this.idTipoComprobante = idTipoComprobante;
        this.tipopago = tipopago;
        this.nOperacion = nOperacion;
        this.estado = estado;
        this.idcaja = idcaja;
        this.idFlujoCaja = idFlujoCaja;
    }

    public int getIdNotaPedido() {
        return idNotaPedido;
    }

    public void setIdNotaPedido(int idNotaPedido) {
        this.idNotaPedido = idNotaPedido;
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

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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
        return "NotaPedido{" + "idNotaPedido=" + idNotaPedido + ", fecha=" + fecha + ", hora=" + hora + ", idUsuario=" + idUsuario + ", idcliente=" + idcliente + ", idTipoComprobante=" + idTipoComprobante + ", tipopago=" + tipopago + ", nOperacion=" + nOperacion + ", estado=" + estado + ", idcaja=" + idcaja + ", idFlujoCaja=" + idFlujoCaja + '}';
    }
}
