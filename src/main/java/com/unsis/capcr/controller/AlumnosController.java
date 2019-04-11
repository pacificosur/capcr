/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del CRUD para el módulo de Alumnos.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.service.AlumnoService;
import com.unsis.capcr.service.IAlumnoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabTW06
 */
public class AlumnosController extends HttpServlet {
private IAlumnoService iAlumnoService = new AlumnoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
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
    private void home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Alumno/alumnoHome.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Alumno/listar.jsp");
        List<Alumno> listaAlumno = iAlumnoService.ObtenerAlumno();
        request.setAttribute("listaAlumno", listaAlumno);
	dispatcher.forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}
