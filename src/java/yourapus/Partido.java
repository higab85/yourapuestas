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
public class Partido implements Serializable {
    
    Partido(Contrincante contrincante1, Contrincante contrincante2) {
        this.contrincante1 = contrincante1;
        this.contrincante2 = contrincante2;
    }

    public Contrincante getContrincante1() {
        return contrincante1;
    }

    public Contrincante getContrincante2() {
        return contrincante2;
    }

    public void setContrincante1(Contrincante contrincante1) {
        this.contrincante1 = contrincante1;
    }

    public void setContrincante2(Contrincante contrincante2) {
        this.contrincante2 = contrincante2;
    }
    
    
    private Contrincante contrincante1;
    private Contrincante contrincante2;
   
}
