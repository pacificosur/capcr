/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: implementación de la clase controladora para el módulo de 
 *              Reservación.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.service.IReservacionService;
import com.unsis.capcr.service.ReservacionService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservacionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if (accion.equals("crear") && request.getParameter("idReservacion") != null && !request.getParameter("idReservacion").equals("")) {
            accion = "actualizar";
        }
            
        try {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/index.jsp");

        IReservacionService iReservacionService = new ReservacionService();
        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
        dispatcher.forward(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/index.jsp");

        String area = request.getParameter("area");
        String responsableArea = request.getParameter("responsableArea");
        String practica = request.getParameter("practica");
        String responsablePractica = request.getParameter("responsablePractica");

        Reservacion reservacion = new Reservacion();

        reservacion.setArea(area);
        
        java.util.Date fecha = new java.util.Date(); 
        
        reservacion.setFechaInicio(new java.sql.Date(fecha.getTime()));
        reservacion.setFechaFin(new java.sql.Date(fecha.getTime()));
        
        reservacion.setResponsableArea(responsableArea);
        reservacion.setPractica(practica);
        reservacion.setResponsablePractica(responsablePractica);

        IReservacionService iReservacionService = new ReservacionService();
        iReservacionService.crearRegistro(reservacion);

        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
        dispatcher.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/index.jsp");

        Long idReservacion = Long.parseLong(request.getParameter("idReservacion"));
        String area = request.getParameter("area");
        String responsableArea = request.getParameter("responsableArea");
        String practica = request.getParameter("practica");
        String responsablePractica = request.getParameter("responsablePractica");

        Reservacion reservacion = new Reservacion();

        reservacion.setIdReservacion(idReservacion);
        reservacion.setArea(area);
        reservacion.setResponsableArea(responsableArea);
        reservacion.setPractica(practica);
        reservacion.setResponsablePractica(responsablePractica);

        IReservacionService iReservacionService = new ReservacionService();
        iReservacionService.actualizarRegistro(reservacion);

        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
        dispatcher.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/index.jsp");
        
        Long idReservacion = Long.parseLong(request.getParameter("idReservacion-eliminar"));

        IReservacionService iReservacionService = new ReservacionService();
        iReservacionService.eliminarRegistro(idReservacion);

        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
        dispatcher.forward(request, response);
    }
}
