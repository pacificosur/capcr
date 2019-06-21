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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author LabTW12
 */
public class CargarListasController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "cargar_lista_alumno":
                listarAlumno(request, response);
                break;
            case "cargar_lista_practica":
                listarPractica(request, response);
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

    private void listarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/tablaAlumnos.jsp");

        String xml=request.getParameter("archivo-xml");
        System.out.println(xml);      
        List<Alumno> listaAlumno =null;
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);
    }

    private void listarPractica(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/tablaPracticas.jsp");
        
        String xml=request.getParameter("archivo-xml");
        
        List<Practica> listaPractica = null;

        request.setAttribute("listaPractica", listaPractica);
        dispatcher.forward(request, response);
    }
    private List<Alumno> obtener_listaAlumnos(){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        
        return listaAlumnos;
    }
    private List<Practica> obtener_listaPracticas(){
        ArrayList<Practica> listaPractica= new ArrayList<>();
        
        return listaPractica;
    }
}
