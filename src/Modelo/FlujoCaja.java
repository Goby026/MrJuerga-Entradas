package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Marce
 */
public class FlujoCaja {

    int idFlujoCaja, idUsuario, idCaja;
    String fechaInicio, horaInicio, fechaFinal, horaFinal;
    String estado;
    double ingresos, egresos, saldo, visa,master,jarras,descuadre;

    public FlujoCaja() {
    }

    public FlujoCaja(int idFlujoCaja, int idUsuario, int idCaja, String fechaInicio, String horaInicio, String fechaFinal, String horaFinal, String estado, double ingresos, double egresos, double saldo, double visa, double master, double jarras, double descuadre) {
        this.idFlujoCaja = idFlujoCaja;
        this.idUsuario = idUsuario;
        this.idCaja = idCaja;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFinal = fechaFinal;
        this.horaFinal = horaFinal;
        this.estado = estado;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.saldo = saldo;
        this.visa = visa;
        this.master = master;
        this.jarras = jarras;
        this.descuadre = descuadre;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
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

    public double getVisa() {
        return visa;
    }

    public void setVisa(double visa) {
        this.visa = visa;
    }

    public double getMaster() {
        return master;
    }

    public void setMaster(double master) {
        this.master = master;
    }

    public double getJarras() {
        return jarras;
    }

    public void setJarras(double jarras) {
        this.jarras = jarras;
    }
    
    public double getDescuadre() {
        return descuadre;
    }

    public void setDescuadre(double descuadre) {
        this.descuadre = descuadre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
