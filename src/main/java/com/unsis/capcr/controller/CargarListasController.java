/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.service.AlumnoService;
import com.unsis.capcr.service.IAlumnoService;
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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LabTW12
 */
public class CargarListasController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch(accion){
            case "cargar_lista_alumno":
                listarAlumno(request,response);
                break;
            case "cargar_lista_practica":
                listarPractica(request,response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    

    private void listarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JFileChooser selector= new JFileChooser();
        selector.setDialogTitle("Archivo Excel");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".xls,.xlsx",".xls, .xls");
        selector.setFileFilter(filtro);
        int flag=selector.showOpenDialog(null);
        if(flag==JFileChooser.APPROVE_OPTION){
            
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/tablaAlumnos.jsp");
        IAlumnoService iAlumnoService = new AlumnoService();
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);       
    }
    

    private void listarPractica(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/tablaPracticas.jsp");
        IPracticaService iPracticaService =new PracticaService();
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);        
    }
}
