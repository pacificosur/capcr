/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 07/05/2019
  Fecha Modificación: -/-/-
Tecnologias web I
*/
package com.unsis.capcr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabTW03
 */
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
          
        request.getRequestDispatcher("/capcr/pages/index.jsp").include(request, response);  
          
        Cookie ck=new Cookie("user","");  
        ck.setMaxAge(0);  
        response.addCookie(ck);  
          
        out.print("you are successfully logged out!");  
    }


}
