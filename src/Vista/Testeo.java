/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ManejadorFechas;
import java.sql.Date;

/**
 *
 * @author MARCEL
 */
public class Testeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new ManejadorFechas().getHoraActual());
    }
    
}
