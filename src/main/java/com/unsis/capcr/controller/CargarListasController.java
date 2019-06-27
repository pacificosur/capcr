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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            case "cargar-alumnos":
                listarAlumno(request, response);
                break;
            case "cargar-practicas":
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/index.jsp");
        int nAlumnos = Integer.parseInt(request.getParameter("nAlumnos"));
        System.out.println("nos llegaron " + nAlumnos + " alumnos");
        for (int i = 0; i < nAlumnos; i++) {
            //recorre la lista de los alumnos
            Alumno alumno = new Alumno();
            //asignar valores 
            alumno.setMatricula(request.getParameter("matricula" + i));
            alumno.setNombre(request.getParameter("nombre" + i));
            alumno.setGrupo(request.getParameter("grupo" + i));
            alumno.setCodigoSemestre(ObtenerCodigoSemestre(request.getParameter("semestre" + i)));
            alumno.setCodigoCarrera(ObtenerCodigoCarrera(request.getParameter("carrera" + i)));
            IAlumnoService iAlumnoService = new AlumnoService();
            iAlumnoService.crearAlumno(alumno);
        }

        dispatcher.forward(request, response);
    }

    private void listarPractica(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/cargarlista/index.jsp");
        int nPracticas = Integer.parseInt(request.getParameter("nPracticas"));
        for (int i = 0; i < nPracticas; i++) {    
            String codigo = request.getParameter("codigo"+i);
            String nombre = request.getParameter("nombre"+i);
            String semestre = request.getParameter("semestre"+i);
            String carrera = request.getParameter("carrera"+i);
            Practica practica = new Practica();
            practica.setCodigo(codigo);
            practica.setNombre(nombre);
            practica.setIdSemestre(ObtenerCodigoSemestre(semestre));
            practica.setIdCarrera(ObtenerCodigoCarrera(carrera));
            IPracticaService iPracticaService = new PracticaService();
            iPracticaService.crearPractica(practica);

        }

        dispatcher.forward(request, response);
    }

    /**
     * obtiene el nombre de la carrera y regresa el codigo de ella
     *
     * @param Carrera
     * @return
     */
    private String ObtenerCodigoCarrera(String Carrera) {
        String Codigo;
        switch (Carrera.toUpperCase()) {//si la cadena entra en minusculas los pasa a mayusculas
            case "ENFERMERIA":
                Codigo = "03";
                break;
            case "ENFERMERÍA":
                Codigo = "03";
                break;
            case "ODONTOLOGIA":
                Codigo = "13";
                break;
            case "ODONTOLOGÍA":
                Codigo = "13";
                break;
            case "MEDICINA":
                Codigo = "14";
                break;
            default:
                Codigo = "00";
                break;
        }
        return Codigo;
    }

    /**
     * Recibe el parametro semestre en String regresa el codigo del semestre
     *
     * @param Semestre
     * @return
     */
    private String ObtenerCodigoSemestre(String Semestre) {
        String Codigo;
        switch (Semestre.toUpperCase()) {
            case "PRIMERO":
                Codigo = "01";
                break;
            case "SEGUNDO":
                Codigo = "02";
                break;
            case "TERCERO":
                Codigo = "03";
                break;
            case "CUARTO":
                Codigo = "04";
                break;
            case "QUINTO":
                Codigo = "05";
                break;
            case "SEXTO":
                Codigo = "06";
                break;
            case "SEPTIMO":
            case "SÉPTIMO":
                Codigo = "07";
                break;
            case "OCTAVO":
                Codigo = "08";
                break;
            case "NOVENO":
                Codigo = "09";
                break;
            case "DECIMO":
            case "DÉCIMO":
                Codigo = "10";
                break;
            default:
                Codigo = "00";
                break;
        }
        return Codigo;
    }

}
