/*
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 24/04/2019
  Fecha Modificación: 03/05/2019
Tecnologias web I
*/
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.model.IUsuarioModel;
import com.unsis.capcr.model.UsuarioModel;
import com.unsis.capcr.service.IReservacionService;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LogueoController extends HttpServlet {
    @Override
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            IUsuarioService iuser=new UsuarioService();
            response.setContentType("Text/html");
            PrintWriter salida= response.getWriter(); 
            IUsuarioModel iu= new UsuarioModel();
            Usuario usr=new Usuario();
            String user=request.getParameter("user");
            String password=request.getParameter("password");   
            usr.setNombreUsuario(user);
            usr.setContraseña(password);
            if(iuser.logueo(usr)){
                Cookie ck=new Cookie("user",user);  
                response.addCookie(ck);
                response.sendRedirect("/capcr/pages/index.jsp");

            }
            else{
                response.sendRedirect("/capcr/pages/logueo/index.jsp");
            }
            
    }
    

}
