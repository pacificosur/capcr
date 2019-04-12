
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.service.IReservacionService;
import com.unsis.capcr.service.ReservacionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RolesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch(accion){
            case "listar":
                listar(request,response);
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/roles/roles.jsp");
        IReservacionService iReservacionService = new ReservacionService();
        List<Reservacion> listaUsuario = iReservacionService.obtenerRegistros();
        request.setAttribute("listaUsuario", listaUsuario);
	dispatcher.forward(request, response);        
    }


}
