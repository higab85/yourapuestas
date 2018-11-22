/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author bear
 */
public class DatabaseInterface {
    
    public DatabaseInterface(){
        Contrincante barsa = new Contrincante("barsa");
        Contrincante real = new Contrincante("real madrid");
        Contrincante betis = new Contrincante("betis");
        Contrincante aleti = new Contrincante("aleti");
        Contrincante rayo = new Contrincante("rayo");

        ArrayList<Contrincante> contrincantes = new ArrayList<Contrincante>(
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
    }
    
    ArrayList<Listing> partidos;
    
    public ArrayList<Listing> getPartidos(){
        return this.partidos;
    }
    
}
