/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

 @Override
    public void init(){
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/WEB-INF/creds.txt");
        
        InputStreamReader isr = new InputStreamReader(resourceAsStream);
        BufferedReader br = new BufferedReader(isr);
        
        List<String> users = new ArrayList<String>();
        String line;
        try {
            while((line = br.readLine()) != null)
                users.add(line);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        String delims = ","; 
        Map<String, String> creds = new HashMap<String, String>();
        Map<String, Integer> puntuaciones = new HashMap<String, Integer>();

        for(String user:users){
            String[] cred = user.split(delims);
            creds.put(cred[0], cred[1]);
            puntuaciones.put(cred[0], 0);
        }
        getServletContext().setAttribute("usuarios", creds);
        getServletContext().setAttribute("puntuaciones", puntuaciones);

    } 
    
    boolean correctCredentials(String username, String password){
        
        Map<String,String> creds = (Map<String,String>) getServletContext().getAttribute("usuarios");
        System.out.println("user"+username+"pass"+password+"pass2"+creds.get(username));
        if(creds.get(username) == null)
            return false;
        if(creds.get(username).equals(password))
            return true;
        return false;
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
        
        String user_submitted = request.getParameter("user");
        String password_submitted = request.getParameter("password");
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("parameterNames:");
        while(parameterNames.hasMoreElements())
            System.out.println(parameterNames.nextElement());
            
        System.out.println(parameterNames);
        if(correctCredentials(user_submitted, password_submitted)){
            request.setAttribute("user", user_submitted);

            RequestDispatcher success = request.getRequestDispatcher("LoginSuccess");
            success.forward(request, response);
            
        }else{
         //   RequestDispatcher error = request.getRequestDispatcher("/errortrace");
         //   error.forward(request, response);   
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

}
