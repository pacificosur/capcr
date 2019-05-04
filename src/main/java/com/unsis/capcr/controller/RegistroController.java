/*
 * Autor: Martínez García Eber
 * E-mail: berpy.1997@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del modulo registro
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Registro;
import com.unsis.capcr.service.IRegistroService;
import com.unsis.capcr.service.RegistroService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "home":
                home(request, response);
                break;
            case "listar":
                listar(request, response);
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

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/home.jsp");
        dispatcher.forward(request,response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/listar.jsp");
        IRegistroService iRegistroService = new RegistroService(); 
        List<Registro>listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro",listaRegistro);
        dispatcher.forward(request,response);
    }
    
    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/listar.jsp");
        
        String matricula = request.getParameter("matriculaAlumno");
        String codigo = request.getParameter("codigoPractica");
        
        Registro registro = new Registro();
        
        registro.setMatriculaAlumno("matriculaAlumno");
        registro.setCodigoPractica("codigoPractica");
        registro.setHoraEntrada("horaEntrada");
        registro.setHoraSalida("horaSalida");
        registro.setSustituye("sustituye");
        
        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.crearRegistro(registro);
        
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
	dispatcher.forward(request, response);        
    }
    
     private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/listar.jsp");
        
        Long idRegistro = Long.parseLong(request.getParameter("cogigoPractica"));
        String area = request.getParameter("area");
        String responsableArea = request.getParameter("responsableArea");
        String practica = request.getParameter("practica");
        String responsablePractica = request.getParameter("responsablePractica");
        
        Registro registro = new Registro();
        
        registro.setMatriculaAlumno("matriculaAlumno");
        registro.setCodigoPractica("codigoPractica");
        registro.setHoraEntrada("horaEntrada");
        registro.setHoraSalida("horaSalida");
        registro.setSustituye("sustituye");
     ////hxlwhxldkjldkjlwxclkdjwlkjwdklj   
        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.actualizarRegistro(registro);
        
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
	dispatcher.forward(request, response);        
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/listar.jsp");
        
        Long idRegistro = Long.parseLong(request.getParameter("idRegistro"));
        
        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.eliminarRegistro(idRegistro);
        
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
	dispatcher.forward(request, response);        
    }
}
