/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MARCEL
 */
public class EntradaGeneral {
    private int idEntradaGeneral;
    private String fecha;
    private String hora;
    private int idUsuario;
    private int idCliente;
    private int idTipoComprobante;
    private int estado;
    private int tipopago;
    private String nOperacion;
    private int idCaja;
    private int idFlujoCaja;

    public EntradaGeneral() {
    }

    public EntradaGeneral(int idEntradaGeneral, String fecha, String hora, int idUsuario, int idCliente, int idTipoComprobante, int estado, int tipopago, String nOperacion, int idCaja, int idFlujoCaja) {
        this.idEntradaGeneral = idEntradaGeneral;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idTipoComprobante = idTipoComprobante;
        this.estado = estado;
        this.tipopago = tipopago;
        this.nOperacion = nOperacion;
        this.idCaja = idCaja;
        this.idFlujoCaja = idFlujoCaja;
    }

    public int getIdEntradaGeneral() {
        return idEntradaGeneral;
    }

    public void setIdEntradaGeneral(int idEntradaGeneral) {
        this.idEntradaGeneral = idEntradaGeneral;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdFlujoCaja() {
        return idFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        this.idFlujoCaja = idFlujoCaja;
    }

    @Override
    public String toString() {
        return "EntradaGeneral{" + "idEntradaGeneral=" + idEntradaGeneral + ", fecha=" + fecha + ", hora=" + hora + ", idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", idTipoComprobante=" + idTipoComprobante + ", estado=" + estado + ", tipopago=" + tipopago + ", nOperacion=" + nOperacion + ", idCaja=" + idCaja + ", idFlujoCaja=" + idFlujoCaja + '}';
    }
    
}
