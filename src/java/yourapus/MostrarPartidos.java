/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MostrarPartidos", urlPatterns = {"/MostrarPartidos"})
public class MostrarPartidos extends HttpServlet {
    private static final int MOSTRAR_PARTIDOS=1;
    private static final int MOSTRAR_PARTIDOS_EQUIPO=2;
    private static final int MOSTRAR_PARTIDOS_TENIS=3;
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
        
        int opcion;
        
        try (PrintWriter out = response.getWriter()) {
            
            opcion = Integer.parseInt(request.getParameter("opcion"));
            
            switch(opcion){
            
                case MOSTRAR_PARTIDOS:
                    mostrarPartidos(request,response);
                    break;
                case MOSTRAR_PARTIDOS_EQUIPO:
                    mostrarPartidosEquipo(request,response);
                    break;
                case MOSTRAR_PARTIDOS_TENIS:
                    mostrarPartidosTenis(request,response);
                    break;
                    
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarPartidos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MostrarPartidos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

    private void mostrarPartidos(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void mostrarPartidosEquipo(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void mostrarPartidosTenis(HttpServletRequest request, HttpServletResponse response) {
        
    }

}