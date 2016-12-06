
package Modelo;

/**
 *
 * @author Marce
 */
public class Caja {
    int idCaja;
    String nomCaja;

    public Caja() {
    }

    public Caja(int idCaja, String nomCaja) {
        this.idCaja = idCaja;
        this.nomCaja = nomCaja;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getNomCaja() {
        return nomCaja;
    }

    public void setNomCaja(String nomCaja) {
        this.nomCaja = nomCaja;
    }
}
