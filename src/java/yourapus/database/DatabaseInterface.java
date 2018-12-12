/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import yourapus.models.Listing;
import yourapus.models.Partido;
import yourapus.models.Precios;
import yourapus.models.Equipo;
import java.util.ArrayList;
import java.util.Arrays;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import yourapus.models.Tenista;
import yourapus.models.Usuario;

/**
 *
 * @author bear
 */
public class DatabaseInterface {
    InitialContext initial;
    DataSource datasource;
    Connection conn;
    Listing clasico;
    
    public DatabaseInterface(){
        Equipo barsa = new Equipo("barsa");
        Equipo real = new Equipo("real madrid");
        Equipo betis = new Equipo("betis");
        Equipo aleti = new Equipo("atleti");
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


        clasico = new Listing(juegoClasico, casasClasico);
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
    
public void iniciarConexion (){
    try{
    initial = new InitialContext();
    datasource = (DataSource) initial.lookup("jdbc/myDatasource");
    conn = datasource.getConnection();
    }
    catch(Exception E){
        System.out.println("impossible conectar a la BBDD");
    }
}  




public ArrayList<Equipo> getEquipos() throws SQLException{
    iniciarConexion();
    ArrayList<Equipo> equipos = new ArrayList<Equipo>();
    String query = "Select * from equipos";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        String name = rs.getString("nombre");
        System.out.println("Equipo:" + name);
        Equipo e = new Equipo(name);
        equipos.add(e);
        
    }
    conn.close();
    return equipos;
    
    
}


public ArrayList<Tenista> getTenistas() throws SQLException{
    iniciarConexion();
    ArrayList<Tenista> tenistas = new ArrayList<Tenista>();
    String query = "Select * from tenistas";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        int id = rs.getInt("id");
        String name = rs.getString("nombre");
        System.out.println("Tenista:" + name);
        Tenista t = new Tenista(id,name);
        tenistas.add(t);
        
    }
    conn.close();
    return tenistas;
    
    
}
public ArrayList<Listing> getPartidos() throws SQLException{
    iniciarConexion();
    ArrayList<Listing> lista = new ArrayList<Listing>();
    
    String query = "Select * from partidos";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        
        
        ArrayList<Precios> preciosArray = new ArrayList<Precios>();
        String local = rs.getString("local");
        String visitante = rs.getString("visitante");
        String ganaVisitante = rs.getString("Cuota3");
        String ganaLocal = rs.getString("Cuota1");
        String empate = rs.getString("Cuota2");
        String nombreCasaDeApuestas = rs.getString("casaDeApuestas");
        Precios precio = new Precios(ganaVisitante,ganaLocal,empate,nombreCasaDeApuestas);
        preciosArray.add(precio);
        
        for (int i = 0; i <= 1; i++) {
            rs.next();
            ganaVisitante = rs.getString("Cuota3");

            ganaLocal = rs.getString("Cuota1");
            empate = rs.getString("Cuota2");
            nombreCasaDeApuestas = rs.getString("casaDeApuestas");
            precio = new Precios(ganaVisitante,ganaLocal,empate,nombreCasaDeApuestas);

            preciosArray.add(precio);
                
        }
        Equipo equipo1 = new Equipo(local);
        Equipo equipo2 = new Equipo(visitante);
        Partido partido = new Partido(equipo1,equipo2);
        Listing listita = new Listing(partido,preciosArray);
        
        
        lista.add(listita);
        
        
    }
    this.partidos=lista;
    conn.close();
    return lista;
    
} 
    
    

    
  
    
   
     public ArrayList<Listing> getPartidos(String equipo) throws SQLException{
         ArrayList<Listing> partidosEquipo = new ArrayList<>();
     
         for (Listing partido : this.partidos){
            if (equipo.equalsIgnoreCase(partido.getPartido().getContrincante1().getNombre()) ||
                    equipo.equalsIgnoreCase(partido.getPartido().getContrincante2().getNombre()))
                partidosEquipo.add(partido);
                    
         }
        return partidosEquipo;
    }
    
    public Usuario getCurrentUser(){
        return this.currentUser;
    }

    Serializable getUltimosPartidos() {
        return this.ultimosPartidos;
       
    }

}
