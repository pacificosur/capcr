/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 07/05/2019
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

public class AlumnosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        try { //este try implementa un switch case para saber el método que sera seleccionado
            switch (accion) {
                case "index":
                    index(request, response);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");
        IAlumnoService iAlumnoService = new AlumnoService();
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");

        IAlumnoService iAlumnoService = new AlumnoService();
        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        System.out.println(listaAlumno.size());

        for (Alumno alumno : listaAlumno) {
            System.out.println(alumno.getMatricula() + " " + alumno.getNombre() + " " + alumno.getGrupo() + " " + alumno.getFechaCreacion() + " " + alumno.getFechaActualizacion() + " " + alumno.getFechaEliminacion() + " " + alumno.getCodigoSemestre() + " " + alumno.getCodigoCarrera());
        }
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");

        String matricula = request.getParameter("matricula");
        String nombre = request.getParameter("nombre");
        String grupo = request.getParameter("grupo");
        String semestre = request.getParameter("semestre");
        String carrera = request.getParameter("carrera");

        Alumno alumno = new Alumno();

        alumno.setMatricula(matricula);
        alumno.setNombre(nombre);
        alumno.setGrupo(grupo);
        alumno.setCodigoSemestre(semestre);
        alumno.setCodigoCarrera(carrera);

        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.crearAlumno(alumno);

        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");

        String matricula = request.getParameter("matricula");
        String nombre = request.getParameter("nombre");
        String grupo = request.getParameter("grupo");
        String semestre = request.getParameter("semestre");
        String carrera = request.getParameter("carrera");

        Alumno alumno = new Alumno();

        alumno.setMatricula(matricula);
        alumno.setNombre(nombre);
        alumno.setGrupo(grupo);
        alumno.setCodigoSemestre(semestre);
        alumno.setCodigoCarrera(carrera);

        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.actualizarAlumno(alumno);

        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/alumno/index.jsp");

        String idAlumno = (request.getParameter("idAlumno"));

        IAlumnoService iAlumnoService = new AlumnoService();
        iAlumnoService.eliminarAlumno(idAlumno);

        List<Alumno> listaAlumno = iAlumnoService.obtenerAlumnos();
        request.setAttribute("listaAlumno", listaAlumno);
        dispatcher.forward(request, response);

    }
}
