/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/04/2019
 * Descripción: implementación de la clase controladora para el módulo de 
 *              Usuario.
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "home":
                home(request, response);
                break;
            case "index":
                index(request, response);
                break;
            case "crear":
                System.out.println("Hola ");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/home.jsp");
        dispatcher.forward(request,response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/index.jsp");
        IUsuarioService iUsuarioService = new UsuarioService(); 
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario",listaUsuario);
        dispatcher.forward(request,response);
    }
    
    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/index.jsp");
        
        String Nombre = request.getParameter("idNombre");
        String Apellidos = request.getParameter("idApellidos");
        String idUsuario = request.getParameter("idUsuario");
        String idNombreUsuario = request.getParameter("idNombre");
        String idContraseña = request.getParameter("idContraseña");
        String idCntraseña2 = request.getParameter("idContraseña2");
        String idTipo = request.getParameter("idTipo");
       
        Usuario usuario = new Usuario();
 
            
    }
}
