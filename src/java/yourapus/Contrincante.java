/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;
import java.io.Serializable;


/**
 *
 * @author bear
 */

public class Contrincante implements Serializable {


    private enum Juego {
    FUTBOL, TENIS
    }
    
    public Contrincante(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    private String nombre;

    
}
