/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.database;

import java.io.Serializable;
import yourapus.models.Listing;
import yourapus.models.Partido;
import yourapus.models.Precios;
import yourapus.models.Equipo;
import java.util.ArrayList;
import java.util.Arrays;
import yourapus.models.Usuario;

/**
 *
 * @author bear
 */
public class DatabaseInterface {
    
    public DatabaseInterface(){
        Equipo barsa = new Equipo("barsa");
        Equipo real = new Equipo("real madrid");
        Equipo betis = new Equipo("betis");
        Equipo aleti = new Equipo("aleti");
        Equipo rayo = new Equipo("rayo");

        ArrayList<Equipo> contrincantes = new ArrayList<Equipo>(
            Arrays.asList(barsa, aleti, betis, rayo));

        Partido juegoClasico = new Partido(barsa, real);
        Partido juegoRealbetis = new Partido(real, betis);
        Partido juegoRealRayo = new Partido(real, rayo);

        Precios bwinClasico = new Precios("0.15", "0.34", "1.00", "bwin");
        Precios bet360Clasico = new Precios("0.10", "0.36", "0.09", "bet360");
        Precios casinoClasico = new Precios("1.16", "0.03", "1.40", "casino");
        ArrayList<Precios> casasClasico = new ArrayList<Precios>(
            Arrays.asList(bwinClasico, bet360Clasico, casinoClasico)
        );

        Precios bwinRealbetis = new Precios("0.18", "0.32", "0.54", "bwin");
        Precios bet360Realbetis = new Precios("0.20", "0.09", "0.19", "bet360");
        Precios casinoRealbetis = new Precios("1.15", "1.54", "0.69", "casino");
        ArrayList<Precios> casasRealbetis = new ArrayList<Precios>(
            Arrays.asList(bwinRealbetis, bet360Realbetis, casinoRealbetis)
        );
        
        Precios bwinRealRayo = new Precios("0.05", "0.14", "3.00", "bwin");
        Precios bet360RealRayo = new Precios("0.15", "0.26", "0.49", "bet360");
        Precios casinoRealRayo = new Precios("5.16", "0.01", "1.45", "casino");
        ArrayList<Precios> casasRealRayo = new ArrayList<Precios>(
            Arrays.asList(bwinRealRayo, bet360RealRayo, casinoRealRayo)
        );


        Listing clasico = new Listing(juegoClasico, casasClasico);
        Listing realbetis = new Listing(juegoRealbetis, casasRealbetis);
        Listing realRayo = new Listing(juegoRealRayo, casasRealRayo);


        this.partidos = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis, realRayo));
        
        this.partidosFavoritos = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis));
        
        ArrayList<Equipo> equiposFavoritos = new ArrayList<Equipo>(
                Arrays.asList(real, aleti, rayo));
        
        this.equipos = new ArrayList<Equipo>(
                Arrays.asList(real, aleti, rayo, betis));
        
        this.ultimosPartidos =new ArrayList<Listing>(
            Arrays.asList(clasico, realRayo));
        
        this.currentUser = new Usuario("Gab", "gab@gab.com", this.partidosFavoritos, equiposFavoritos);
    }
    
    ArrayList<Equipo> equipos;
    ArrayList<Listing> partidos;
    Usuario currentUser;
    ArrayList<Listing> partidosFavoritos;
    ArrayList<Listing> ultimosPartidos;

    
    public ArrayList<Equipo> getEquipos(){
        return this.equipos;
    }
    
    public ArrayList<Listing> getPartidos(){
        return this.partidos;
    }
    
    public Usuario getCurrentUser(){
        return this.currentUser;
    }

    Serializable getUltimosPartidos() {
        return this.ultimosPartidos;
       
    }

}
