/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import yourapus.models.Listing;
import yourapus.models.Partido;
import yourapus.models.Precios;
import yourapus.models.Equipo;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yourapus.models.Usuario;

/**
 *
 * @author bear
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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

//        Cookie[] cookies = request.getCookies();
//        
//        if(cookies != null){
//            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName() + " - " + cookie);
//
//                if (cookie.getName().equals("user")){ 
//                    listings = partidosFavoritos();
//                            // Pedimos a la base de datos todos los partidos
//                    getServletContext().setAttribute("cosa", "todosPartidos");
//                    request.getRequestDispatcher("/DatabaseServlet").include(request, response);
//                    break;
//                }
//                if (cookie.getName().equals("NoLogin")) {
//                    listings = partidosUltimos();
//                }
//            }
//        }
//        else{
//            System.out.println("No cookies");
//        }
        ArrayList<Listing> listings;

        Serializable usuarioSer = (Serializable) getServletContext().getAttribute("usuario");
        try{
            Usuario usuario = (Usuario) usuarioSer;
            listings = usuario.getPartidosFavoritos();
        }
        catch(NullPointerException e){
            request.setAttribute("cosa", "ultimosPartidos");
            request.getRequestDispatcher("/DatabaseServlet").include(request, response);
            listings = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
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
