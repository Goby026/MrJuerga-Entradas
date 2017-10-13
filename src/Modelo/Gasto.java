/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Adolfo
 */

public class Gasto implements Serializable {

    private Integer idgastos;
    private String concepto;
    private double monto;
    
    //Constructor vacio
    public Gasto() {
    }
    
    //Constructor con parametros
    public Gasto(Integer idgastos, String concepto, double monto) {
        this.idgastos = idgastos;
        this.concepto = concepto;
        this.monto = monto;
    }

    //Para cada atributo o parametro se le crea su GET Y SET 
    public Integer getIdgastos() {
        return idgastos;
    }

    public void setIdgastos(Integer idgastos) {
        this.idgastos = idgastos;
    }
    
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgastos != null ? idgastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gasto)) {
            return false;
        }
        Gasto other = (Gasto) object;
        if ((this.idgastos == null && other.idgastos != null) || (this.idgastos != null && !this.idgastos.equals(other.idgastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Gastos[ idgastos=" + idgastos + " ]";
    }
    
}
