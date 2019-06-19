/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 07/05/2019
  Descripción: Servlet que desloguea 
  Fecha Modificación: 08/05/2019
  Tecnologias web I*/

package com.unsis.capcr.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // HttpSession cerrar_sesion = request.getSession(false);
        //cerrar_sesion.removeAttribute("user");
        
        //String ruta = "localhost:8080"+request.getContextPath()+"/pages/logueo/index.jsp";
        //System.out.println("ruta: " + ruta);
    // request.getRequestDispatcher(request.getContextPath()+"/pages/logueo/index.jsp").include(request, response);
        //response.sendRedirect("/capcr/pages/logueo/index.jsp");
        HttpSession cerrar_sesion = request.getSession(false);
        cerrar_sesion.removeAttribute("user");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/logueo/index.jsp");
        dispatcher.forward(request, response);
    }
}
