/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: implementación del CRUD para el módulo de Alumnos.
 */

package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Alumno;
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
                case "crear":
                    crear(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                case "actualizar":
                    actualizar(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumno();
        request.setAttribute("listaAlumno", listaAlumno);
	dispatcher.forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        
        String  matricula = request.getParameter("matricula");
        String  nombre = request.getParameter("nombre");
        String  grupo = request.getParameter("grupo");
        String  semestre = request.getParameter("semestre");
        String  carrera = request.getParameter("carrera");
        
        Alumno alumno = new Alumno();
        
        alumno.setMatricula(matricula);
        alumno.setNombre(nombre);
        alumno.setGrupo(grupo);  
        alumno.setCodigoSemestre(semestre);
        alumno.setCodigoCarrera(carrera);
        
        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.crearAlumno(alumno);
        
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumno();
        request.setAttribute("listaAlumno", listaAlumno);
	dispatcher.forward(request, response);     
    }          

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        
        String  matricula = request.getParameter("matricula");
        String  nombre = request.getParameter("nombre");
        String  grupo = request.getParameter("grupo");
        String  semestre = request.getParameter("semestre");
        String  carrera = request.getParameter("carrera");
        
        Alumno alumno = new Alumno();
        
        alumno.setMatricula(matricula);
        alumno.setNombre(nombre);
        alumno.setGrupo(grupo);  
        alumno.setCodigoSemestre(semestre);
        alumno.setCodigoCarrera(carrera);
        
        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.actualizarAlumno(alumno);
        
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumno();
        request.setAttribute("listaAlumno", listaAlumno);
	dispatcher.forward(request, response);
    }    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        
        Long idAlumno = Long.parseLong(request.getParameter("idAlumno"));
        
        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.eliminarAlumno(idAlumno);
        
        List<Alumno> listaReservacion = iAlumnoService.obtenerAlumno();
        request.setAttribute("listaAlumno", listaAlumno);
	dispatcher.forward(request, response);        
    
    }
        
    
    
}
