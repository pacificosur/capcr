/*
 * Autor: Martínez García Eber
 * E-mail: berpy.1997@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del modulo registro
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.entity.Registro;
import com.unsis.capcr.model.IRegistroModel;
import com.unsis.capcr.model.RegistroModel;
import com.unsis.capcr.service.AlumnoService;
import com.unsis.capcr.service.IAlumnoService;
import com.unsis.capcr.service.IPracticaService;
import com.unsis.capcr.service.IRegistroService;
import com.unsis.capcr.service.PracticaService;
import com.unsis.capcr.service.RegistroService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class RegistroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("controler" + accion);
//        String buscarAlumno = request.getParameter("matriculaAlumno");
//
//        if (buscarAlumno != null) {
//            accion = "buscar";
//        }
        switch (accion) {
            case "index":
                index(request, response);
                break;
            case "buscar":
                //buscar(request, response, buscarAlumno);
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
            case "alumnopractica":
                obtenerAlumnoPracticas(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");

        IRegistroService iRegistroService = new RegistroService();

        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response, String matricula) throws ServletException, IOException {

        IRegistroService iRegistroService = new RegistroService();
        Registro regis = iRegistroService.obtenerRegistroPorMatricula(matricula);

        response.getWriter().write(regis.getCodigoPractica());
        response.getWriter().write(regis.getMatriculaAlumno());
        response.getWriter().write(regis.getHoraEntrada());
        response.getWriter().write(regis.getHoraSalida());
        response.getWriter().write(regis.getSustituye());

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");

        Long idRegistro = Long.parseLong(request.getParameter("idRegistro"));
        String comentario = "cancelado";

        Registro registro = new Registro();
        
        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.finalizarRegistro(idRegistro, comentario);

        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");

        Long idRegistro = Long.parseLong(request.getParameter("idRegistro"));

        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.eliminarRegistro(idRegistro);

        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);
    }

    private void obtenerAlumnoPracticas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");

        String matricula = request.getParameter("matricula");
        IAlumnoService iAlumnoService = new AlumnoService();
        Alumno alumno = iAlumnoService.obtenerAlumno(matricula);
        IPracticaService iPracticaService = new PracticaService();
        List<Practica> listaPractica = iPracticaService.getPracticaRegistro(alumno.getCodigoSemestre(), alumno.getCodigoCarrera());

        List<String> alumnoPractica = new ArrayList<>();
        alumnoPractica.add(alumno.getMatricula());
        alumnoPractica.add(alumno.getNombre());
        for (Practica practica : listaPractica) {
            alumnoPractica.add(practica.getCodigo());
            alumnoPractica.add(practica.getNombre());
        }
        for (String dato : alumnoPractica) {
            System.out.println(dato);
        }
        //  request.setAttribute("alumno", alumno);
        //request.setAttribute("practica", listaPractica);
        request.setAttribute("alumnoPractica", alumnoPractica);
        response.getWriter().write(alumnoPractica.toString());
        //dispatcher.forward(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");

        String matriculaAlumno = request.getParameter("idmatricula");
        String codigoPractica = request.getParameter("seleccionar-practica");
        String sustituye = request.getParameter("hora-sustituye");
        System.out.println(matriculaAlumno + " " + codigoPractica + " " + sustituye);

        Registro registro = new Registro();
        registro.setMatriculaAlumno(matriculaAlumno);
        registro.setCodigoPractica(codigoPractica);
        registro.setSustituye(sustituye);

        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.crearRegistro(registro);

        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);
    }

    private void reporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
