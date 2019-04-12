/*
 * Autor: Padilla Bustamante Uriel Gustavo
 * E-mail: padilla98.upb@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del modulo prácticas
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
        
        IPracticaService iPracticaService =new PracticaService();
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        System.out.println(listaPractica.size());
        
        for (Practica practica : listaPractica) {
             System.out.println(practica.getCodigo()+" "+practica.getNombre()+" "+practica.getIdSemestre()+" "+practica.getIdCarrera()+" "+practica.getFechaCreacion()+" "+practica.getFechaActualizacion()+" "+practica.getFechaEliminacion());
            
        }
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);        
    }
}
