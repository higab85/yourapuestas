/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourapus.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diegoechaure
 */
@WebFilter(filterName = "FilterLogin",urlPatterns = {"/faces/login.xhtml"})
public class FilterLogin implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest session = (HttpServletRequest)request;
       HttpServletResponse nopasa = (HttpServletResponse)response;
       try{
        if(((String)session.getSession().getAttribute("session")).equals("yes")){
            nopasa.sendRedirect("/yourapuestas");
            System.out.println("Not on my watch");

        }
        else{
             System.out.println("Go now");
            chain.doFilter(request, response);
        }
       }catch (NullPointerException e){
            System.out.println("No attribute");
            chain.doFilter(request, response);
        }
    }
    

    @Override
    public void destroy() {
      
    }
    
}
