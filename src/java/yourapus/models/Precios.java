/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.models;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author bear
 */
public class Precios  implements Serializable {

    public Precios(String ganaVisitante, String ganaLocal, String empate, String nombreCasaDeApuestas){
        this.ganaVisitante = ganaVisitante;
        this.ganaLocal = ganaLocal;
        this.empate = empate;
        this.nombreCasaDeApuestas = nombreCasaDeApuestas;
    }

    public String getGanaVisitante() {
        return ganaVisitante;
    }

    public void setGanaVisitante(String ganaVisitante) {
        this.ganaVisitante = ganaVisitante;
    }

    public String getGanaLocal() {
        return ganaLocal;
    }

    public void setGanaLocal(String ganaLocal) {
        this.ganaLocal = ganaLocal;
    }

    public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }
    


    public String getNombreCasaDeApuestas() {
        return nombreCasaDeApuestas;
    }

    public void setNombreCasaDeApuestas(String nombreCasaDeApuestas) {
        this.nombreCasaDeApuestas = nombreCasaDeApuestas;
    }
    
    
    private String ganaVisitante;
    private String ganaLocal;
    private String empate;
    
    private String nombreCasaDeApuestas;
    
    

}
