/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.database;

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

        Listing clasico = new Listing(juegoClasico, casasClasico);
        Listing realbetis = new Listing(juegoRealbetis, casasRealbetis);


        this.partidos = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis));
        
        ArrayList<Listing> partidosFavoritos = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis));
        
        ArrayList<Equipo> equiposFavoritos = new ArrayList<Equipo>(
                Arrays.asList(real, aleti, rayo));
        
        this.currentUser = new Usuario("Gab", "gab@gab.com", partidosFavoritos, equiposFavoritos);
    }
    
    ArrayList<Listing> partidos;
    Usuario currentUser;
    
    public ArrayList<Listing> getPartidos(){
        return this.partidos;
    }
    
    public Usuario getCurrentUser(){
        return this.currentUser;
    }
}
