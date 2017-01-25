/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author toshiba
 */
public class Anulacion {

    Date fecha;
    String hora;
    int idventaEntrada;
    int numPersonas;
    double total;

    public Anulacion(Date fecha, String hora, int idventaEntrada, int numPersonas, double total) {
        this.fecha = fecha;
        this.hora = hora;
        this.idventaEntrada = idventaEntrada;
        this.numPersonas= numPersonas;
        this.total=total;

    }
    public Anulacion(){
        
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdventaEntrada() {
        return idventaEntrada;
    }

    public void setIdventaEntrada(int idventaEntrada) {
        this.idventaEntrada = idventaEntrada;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
