package yourapus.models;


import yourapus.models.Partido;
import yourapus.models.Precios;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bear
 */
public class Listing implements Serializable {
    
    public Listing(Partido partido, ArrayList<Precios> casasDeApuestas){
        this.partido = partido;
        this.casasDeApuestas = casasDeApuestas;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public ArrayList<Precios> getCasasDeApuestas() {
        return casasDeApuestas;
    }

    public void setCasasDeApuestas(ArrayList<Precios> casasDeApuestas) {
        this.casasDeApuestas = casasDeApuestas;
    }
    
    
    private Partido partido;
    private ArrayList<Precios> casasDeApuestas;
}
