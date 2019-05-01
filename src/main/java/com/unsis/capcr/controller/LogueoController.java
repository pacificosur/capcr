/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.model.IUsuarioModel;
import com.unsis.capcr.model.UsuarioModel;
import com.unsis.capcr.service.IReservacionService;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.ReservacionService;
import com.unsis.capcr.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



public class LogueoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            IUsuarioService iuser=new UsuarioService();
            response.setContentType("Text/html");
            PrintWriter salida= response.getWriter(); 
            IUsuarioModel iu= new UsuarioModel();
            Usuario usr=new Usuario();
            
            String validar;
            String user=request.getParameter("user");
            String password=request.getParameter("password");
            System.out.println(user+"  "+password);
            usr.setNombreUsuario(user);
            usr.setContraseña(password);
            if(iuser.logueo(usr)){
                validar="Exitoso ";
            }
            else{
                validar="Error";
            }
            System.out.println(validar);
            //JOptionPane.showMessageDialog(null,validar);
    }
    

}
