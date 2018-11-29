/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author bear
 */
public class Usuario implements Serializable {
    
    
    public Usuario(String nombre, String email, ArrayList<Listing> partidosFavoritos, ArrayList<Equipo> equiposFavoritos) {
        this.nombre = nombre;
        this.email = email;
        this.partidosFavoritos = partidosFavoritos;
        this.equiposFavoritos = equiposFavoritos;
    }
    
    String nombre;
    String email;
    
    ArrayList <Listing> partidosFavoritos;
    ArrayList <Equipo> equiposFavoritos;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Listing> getPartidosFavoritos() {
        return partidosFavoritos;
    }

    public void setPartidosFavoritos(ArrayList<Listing> partidosFavoritos) {
        this.partidosFavoritos = partidosFavoritos;
    }

    public ArrayList<Equipo> getEquiposFavoritos() {
        return equiposFavoritos;
    }

    public void setEquiposFavoritos(ArrayList<Equipo> equiposFavoritos) {
        this.equiposFavoritos = equiposFavoritos;
    }

}
