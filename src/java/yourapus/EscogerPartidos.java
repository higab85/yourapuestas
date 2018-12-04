/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import yourapus.models.Listing;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EscogerPartidos", urlPatterns = {"/EscogerPartidos"})
public class EscogerPartidos extends HttpServlet {

    private static final int PARTIDOS=1;
    private static final int PARTIDOS_EQUIPO=2;
    private static final int PARTIDOS_TENIS=3;
    private static final int PARTIDOS_FAVORITOS=3;

    
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
        
//        int opcion = Integer.parseInt(request.getParameter("opcion"));
        System.out.println("ESCOGERPARTIDOS");

        int opcion = 1;
        String nombrePartido = (String) request.getAttribute("nombrePartido");
        switch(opcion){
            case PARTIDOS:
                request.setAttribute("cosa", "todosPartidos");
                request.getRequestDispatcher("/DatabaseServlet").include(request, response);
                break;
            case PARTIDOS_EQUIPO:
                //
                break;
            case PARTIDOS_TENIS:
                break;

        }
        
        Enumeration<String> parametros = request.getAttributeNames();
        while(parametros.hasMoreElements()){
            System.out.println(parametros.nextElement());
        }
            
        // Pedimos a la base de datos todos los partidos
        request.setAttribute("cosa", "todosPartidos");
        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
        
        ArrayList<Listing> partidos = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
        getServletContext().setAttribute("partidos", partidos);
        RequestDispatcher rd = request.getRequestDispatcher("/mostrarpartidos");
                
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
