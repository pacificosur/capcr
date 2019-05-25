/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 07/05/2019
  Fecha Modificación: 08/05/2019
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author LabTW03
 */
public class LogoutController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        HttpSession cerrar_sesion = request.getSession();
        cerrar_sesion.removeAttribute("user");
        cerrar_sesion.invalidate();
        request.getRequestDispatcher("/capcr/pages/index.jsp").forward(request, response);    /*Al hacer click en Logout nos redirecciona a la página de logueo*/   
    }


}
