
package Modelo;

/**
 *
 * @author Marce
 */
public class UsuarioCaja {
    int idUsuarioCaja, idusuario, idcaja;

    public UsuarioCaja() {
    }

    public UsuarioCaja(int idUsuarioCaja, int idusuario, int idcaja) {
        this.idUsuarioCaja = idUsuarioCaja;
        this.idusuario = idusuario;
        this.idcaja = idcaja;
    }

    public int getIdUsuarioCaja() {
        return idUsuarioCaja;
    }

    public void setIdUsuarioCaja(int idUsuarioCaja) {
        this.idUsuarioCaja = idUsuarioCaja;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }
    
    
}
