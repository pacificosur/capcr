/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 24/04/2019
  Fecha Modificación: 03/05/2019
  Descripción: Servlet que comprueba si el logueo es correcto
  Tecnologias web I*/

package com.unsis.capcr.controller;
import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.model.IUsuarioModel;
import com.unsis.capcr.model.UsuarioModel;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogueoController extends HttpServlet {   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out= new PrintWriter();
        IUsuarioService iuser = new UsuarioService();
        response.setContentType("Text/html");
        PrintWriter salida = response.getWriter();
        IUsuarioModel iu = new UsuarioModel();
        Usuario usr = new Usuario();
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        usr.setNombreUsuario(user);
        usr.setContraseña(password);
        if (iuser.logueo(usr)) {
            HttpSession nueva_sesion = request.getSession(true);
            nueva_sesion.setAttribute("user", user);
            int opcion=iuser.RolUsuario(usr);  
            switch(opcion){
                case 1:
                      response.sendRedirect("/capcr/pages/index.jsp");
                break;
                case 2:
                      response.sendRedirect("/capcr/pages/index.jsp");
                break;
                case 3:
                      response.sendRedirect("/capcr/pages/index.jsp");
                break;
                case 4:
                      response.sendRedirect("/capcr/pages/index.jsp");
                break;
                case 5:
                      response.sendRedirect("/capcr/pages/index.jsp");
                break;
                default:
                     response.sendRedirect("/capcr/pages/logueo/index.jsp");
                break;
            }
        } else {
            response.sendRedirect("/capcr/pages/logueo/index.jsp");
        }
    }
}
