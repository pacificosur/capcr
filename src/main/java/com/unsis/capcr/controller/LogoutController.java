/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 07/05/2019
  Descripción: Servlet que desloguea 
  Fecha Modificación: 08/05/2019
  Tecnologias web I*/

package com.unsis.capcr.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession cerrar_sesion = request.getSession(false);
        cerrar_sesion.removeValue("user");
        cerrar_sesion.invalidate();
        response.sendRedirect("/capcr/pages/logueo/     ");
    }
}
