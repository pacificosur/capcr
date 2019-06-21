package com.unsis.capcr.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

public class ReporteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        

        if (accion.equals("crear") && request.getParameter("idUsuario") != null && !request.getParameter("idUsuario").equals("")) {
            accion = "actualizar";
        }
        switch (accion) {
            case "index":
                index(request, response);
                break;
            case "generar":
                generar(request, response);
                break; 
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reporte/index.jsp");
        dispatcher.forward(request, response);
    }

    private void generar(HttpServletRequest request, HttpServletResponse response) {
        
    }
}
