/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bear
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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
        
        Precios bwinRealRayo = new Precios("0.05", "0.14", "3.00", "bwin");
        Precios bet360RealRayo = new Precios("0.15", "0.26", "0.49", "bet360");
        Precios casinoRealRayo = new Precios("5.16", "0.01", "1.45", "casino");
        ArrayList<Precios> casasRealRayo = new ArrayList<Precios>(
            Arrays.asList(bwinRealRayo, bet360RealRayo, casinoRealRayo)
        );

        Precios bwinRealbetis = new Precios("0.18", "0.32", "0.54", "bwin");
        Precios bet360Realbetis = new Precios("0.20", "0.09", "0.19", "bet360");
        Precios casinoRealbetis = new Precios("1.15", "1.54", "0.69", "casino");
        ArrayList<Precios> casasRealbetis = new ArrayList<Precios>(
            Arrays.asList(bwinRealbetis, bet360Realbetis, casinoRealbetis)
        );

        Listing clasico = new Listing(juegoClasico, casasClasico);
        Listing realbetis = new Listing(juegoRealbetis, casasRealbetis);
        Listing realRayo = new Listing(juegoRealRayo, casasRealRayo);

    
    private ArrayList<Listing> partidosUltimos(){

        ArrayList<Listing> listings = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis));
        return listings;
    }
    private ArrayList<Listing> partidosFavoritos(){

        ArrayList<Listing> listings = new ArrayList<Listing>(
            Arrays.asList(realRayo, realbetis));
        return listings;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        Cookie cookieUser = null;
        Cookie cookieNoLogin = null;
        ArrayList<Listing> listings = null;
        
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " - " + cookie);

                if (cookie.getName().equals("user")){ 
                    listings = partidosFavoritos();
                    cookieUser = cookie;
                    break;
                }
                if (cookie.getName().equals("NoLogin")) {
                    listings = partidosUltimos();
                    cookieNoLogin = cookie;
                }
            }
        }
        else{
            System.out.println("No cookies");
        }
        
        getServletContext().setAttribute("listings", listings);
       
        RequestDispatcher rd = request.getRequestDispatcher("/faces/index.xhtml");
        rd.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
