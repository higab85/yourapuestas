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
//@WebFilter(filterName = "FilterLogin",urlPatterns = {"/Login"})
public class FilterLogin implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest session = (HttpServletRequest)request;
       HttpServletResponse nopasa = (HttpServletResponse)response;
       if(((String)session.getSession().getAttribute("logeado")).equals("true")){
           nopasa.sendRedirect("/yourapuestas");
           
       }
       else{
           chain.doFilter(request, response);
       }
    }

    @Override
    public void destroy() {
      
    }
    
}
