/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class Partido {
    private String local;
    private String visitante;
    private List<Resultado> resultados;

    public Partido(String local, String visitante) {
        this.local = local;
        this.visitante = visitante;
        this.resultados = new ArrayList<>();
    }
    public void añadirResultado(Resultado resul){
        this.resultados.add(resul);
    }
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
}
