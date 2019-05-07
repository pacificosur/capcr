/*
 * Autores: Padilla Bustamante Uriel Gustavo
 *          Castro Cisneros Hiralda
 * E-mail: padilla98.upb@gmail.com  
 *         hiraldac.cisneros@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 03/05/2019
 * Descripción: implementación del modulo prácticas
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Practica;
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
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author LabTW08
 */
public class PracticaController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion"); 
        
        System.out.println("Acion----------------: " + accion + " **** crear practica:   " + request.getParameter("crearPractica"));
        
        if (accion.equals("crear") && request.getParameter("crearPractica").equals("")) {
            accion = "actualizar";
        }
        
        System.out.println("Aaaction: " + accion);
        
        try {
            switch(accion) {
                case "index":
                    listar(request, response);
                    break;
                case "reporte":
                    reporte(request, response);
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
        System.out.println("hola post");
        doGet(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/index.jsp");
        
        IPracticaService iPracticaService =new PracticaService();
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        System.out.println(listaPractica.size());
        
        for (Practica practica : listaPractica) {
             System.out.println(practica.getCodigo()+" "+practica.getNombre()+" "+practica.getIdSemestre()+" "+practica.getIdCarrera()+" "+practica.getFechaCreacion()+" "+practica.getFechaActualizacion()+" "+practica.getFechaEliminacion());
            
        }
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);        
    }
    
    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/index.jsp");
        
        String codigo= request.getParameter("codigoPractica");
        String nombre = request.getParameter("nombrePractica");
        String semestre = request.getParameter("idSemestrePractica");
        String carrera = request.getParameter("idCarreraPractica");    

        Practica practica=new Practica();
        practica.setCodigo(codigo);
        practica.setNombre(nombre);
        practica.setIdSemestre(semestre);
        practica.setIdCarrera(carrera);
               
        IPracticaService iPracticaService = new PracticaService();
        iPracticaService.crearPractica(practica);
        
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);        
    }
    
     private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/index.jsp");
        
        String codigo= request.getParameter("codigoPractica");
        String nombre = request.getParameter("nombrePractica");
        String semestre = request.getParameter("idSemestrePractica");
        String carrera = request.getParameter("idCarreraPractica");    

        Practica practica=new Practica();
        practica.setCodigo(codigo);
        practica.setNombre(nombre);
        practica.setIdSemestre(semestre);
        practica.setIdCarrera(carrera);
        
        System.out.println(practica.getCodigo()+" "+practica.getNombre()+" "+practica.getIdSemestre()+" "+practica.getIdCarrera());
        IPracticaService iPracticaService = new PracticaService();
        iPracticaService.actualizarPractica(practica);
        
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);           
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/practica/index.jsp");
        
        String codigo= request.getParameter("codigoPractica");
        
        IPracticaService iPracticaService = new PracticaService();
        iPracticaService.eliminarPractica(codigo);
        
        List<Practica> listaPractica = iPracticaService.getPracticas("0", "0");
        request.setAttribute("listaPractica", listaPractica);
	dispatcher.forward(request, response);     
    }
    
    private void reporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }
}