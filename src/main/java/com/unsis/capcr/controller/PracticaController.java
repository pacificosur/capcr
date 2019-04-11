/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.service.IPracticaService;
import com.unsis.capcr.service.PracticaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabTW08
 */
public class PracticaController extends HttpServlet {

    private IPracticaService iPracticaService =new PracticaService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion"); 
        try {
            switch(accion) {
                case "home":
                    home(request, response);
                    break;
                case "listar":
                    listar(request, response);
                    break;
                default:
                    break;
            }
        } catch (IOException | ServletException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hola post");
        doGet(request, response);
    }

     private void home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/home.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/listar.jsp");
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);        
    }
}
