package com.unsis.capcr.controller;

import com.unsis.capcr.service.IReporteService;
import com.unsis.capcr.service.ReporteService;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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

    private void generar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reporte/index.jsp");
        IReporteService iReporteService = new ReporteService();
        String grupo = request.getParameter("idGrupo");
        String practicaNombre = request.getParameter("idNombrePractica");
        Date fechaInicio = null;
        Date fechaFin = null; 
        System.out.println("Entra al controller");
        byte[] bytes = iReporteService.generarReporte(grupo, practicaNombre, fechaInicio, fechaFin);
        
        response.setContentType("application/reporte");
        String archivo = practicaNombre+ "_" +grupo+ ".pdf";
        response.addHeader("Content-disposition", "attachment; filename=" + archivo);
        response.setContentLength(bytes.length);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        dispatcher.forward(request, response);  
    }
}
