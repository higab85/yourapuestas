/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.models;

import yourapus.models.Equipo;
import java.io.Serializable;

/**
 *
 * @author bear
 */
public class Partido implements Serializable {
    
    public Partido(Equipo contrincante1, Equipo contrincante2) {
        this.contrincante1 = contrincante1;
        this.contrincante2 = contrincante2;
    }

    public Equipo getContrincante1() {
        return contrincante1;
    }

    public Equipo getContrincante2() {
        return contrincante2;
    }

    public void setContrincante1(Equipo contrincante1) {
        this.contrincante1 = contrincante1;
    }

    public void setContrincante2(Equipo contrincante2) {
        this.contrincante2 = contrincante2;
    }
    
    
    private Equipo contrincante1;
    private Equipo contrincante2;
   
}
