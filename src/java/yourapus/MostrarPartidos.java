/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MostrarPartidos", urlPatterns = {"/MostrarPartidos"})
public class MostrarPartidos extends HttpServlet {
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

        Contrincante barsa = new Contrincante("barsa");
        Contrincante real = new Contrincante("real madrid");
        Contrincante betis = new Contrincante("betis");
        
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
 

        ArrayList<Listing> partidos = new ArrayList<Listing>(
            Arrays.asList(clasico, realbetis));
     

        getServletContext().setAttribute("partidos", partidos);

        
        RequestDispatcher rd = request.getRequestDispatcher("/faces/partidos.xhtml");
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
