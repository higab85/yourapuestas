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
import yourapus.models.Equipo;
import yourapus.models.Tenista;

@WebServlet(name = "EscogerPartidos", urlPatterns = {"/EscogerPartidos"})
public class EscogerPartidos extends HttpServlet {

    private static final int PARTIDOS = 1;
    private static final int EQUIPOS = 2;
    private static final int VER_PARTIDOS_EQUIPO =3;
    private static final int TENISTAS = 4;
    private static final int PARTIDOS_TENIS = 6;
    private static final int PARTIDOS_FAVORITOS = 5;

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

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        switch (opcion) {
            case PARTIDOS:
                mostrarPartidos(request, response);
                break;

            case EQUIPOS:
                mostrarEquipos(request, response);
                break;
                
            case VER_PARTIDOS_EQUIPO:
                mostrarPartidosEquipo(request, response);
                break;
                
            case TENISTAS:
                mostrarTenistas(request, response);
                break;  
                
                
            case PARTIDOS_TENIS:
                mostrarPartidosTernis(request,response);
                break;

        }

//        Enumeration<String> parametros = request.getAttributeNames();
//        while(parametros.hasMoreElements()){
//            System.out.println(parametros.nextElement());
//        }
        // Pedimos a la base de datos todos los partidos
//        request.setAttribute("cosa", "todosPartidos");
//        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
//
//        ArrayList<Listing> partidos = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
//        getServletContext().setAttribute("partidos", partidos);
//        RequestDispatcher rd = request.getRequestDispatcher("/mostrarpartidos");
//
//        rd.forward(request, response);
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

    private void mostrarPartidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Utiliza DataBaseServlet para recuperar informacion de la bbdd
        request.setAttribute("cosa", "todosPartidos");
        // include -- procesa el contenido de la servlet, pero esta no genera nada en este caso.
        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
        // recupera el atributo cosa que se lo ha dejado databaseservlet en el contexto
        ArrayList<Listing> partidos = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
        // carga en el contexto los partidos (clave/valor) para que los procese la vista como partidos
        getServletContext().setAttribute("partidos", partidos);
        RequestDispatcher rd = request.getRequestDispatcher("/faces/partidos.xhtml");
        // rd.forward-->Carga el recurso, que es la vista y le pasa los partidos a partir de un atributo 
        //(partidos). Y lo muestra por pantalla.
        rd.forward(request, response);
    }

    private void mostrarEquipos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cosa", "equipos");
        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) getServletContext().getAttribute("cosa");
        getServletContext().setAttribute("equipos", equipos);

        RequestDispatcher rd = request.getRequestDispatcher("/faces/equipos.xhtml");
        rd.forward(request, response);
    }

    private void mostrarPartidosEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nombreEquipo = (String) request.getParameter("nombreEquipo");
        request.setAttribute("cosa", "PartidosEquipo");
        request.setAttribute("equipo", nombreEquipo);
        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
        ArrayList<Listing> partidos = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
        if(partidos==null || partidos.size()==0)
            throw new ServletException("El equipo " + nombreEquipo + " no tiene partidos" );
        getServletContext().setAttribute("partidos", partidos);
        RequestDispatcher rd = request.getRequestDispatcher("/faces/partidos.xhtml");
        rd.forward(request, response);
    }

    private void mostrarTenistas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina;
        
        try {
            request.setAttribute("cosa", "tenistas");
            request.getRequestDispatcher("/DatabaseServlet").include(request, response);
            ArrayList<Tenista> tenistas = (ArrayList<Tenista>) getServletContext().getAttribute("cosa");
            getServletContext().setAttribute("tenistas", tenistas);
            pagina = "/faces/tenistas.xhtml";
            
        } catch (Exception e){
            pagina = "404error.hml";
        }

        RequestDispatcher rd = request.getRequestDispatcher(pagina);
        rd.forward(request, response);
    }

    private void mostrarPartidosTernis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //Utiliza DataBaseServlet para recuperar informacion de la bbdd
        request.setAttribute("cosa", "todosPartidosTenis");
        // include -- procesa el contenido de la servlet, pero esta no genera nada en este caso.
        request.getRequestDispatcher("/DatabaseServlet").include(request, response);
        // recupera el atributo cosa que se lo ha dejado databaseservlet en el contexto
        ArrayList<Listing> partidos = (ArrayList<Listing>) getServletContext().getAttribute("cosa");
        // carga en el contexto los partidos (clave/valor) para que los procese la vista como partidos
        getServletContext().setAttribute("partidosTenis", partidos);
        RequestDispatcher rd = request.getRequestDispatcher("/faces/todosPartidosTenis.xhtml");
        // rd.forward-->Carga el recurso, que es la vista y le pasa los partidos a partir de un atributo 
        //(partidos). Y lo muestra por pantalla.
        rd.forward(request, response);
    }

}
