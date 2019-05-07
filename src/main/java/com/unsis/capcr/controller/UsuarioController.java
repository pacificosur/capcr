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
                crear(request, response);
                break;
            case "eliminar":
                    //eliminar(request, response);
                    break;
                case "actualizar":
                    actualizar(request, response);
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

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/home.jsp");
        dispatcher.forward(request, response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/index.jsp");
        IUsuarioService iUsuarioService = new UsuarioService();
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);
        dispatcher.forward(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/index.jsp");

        String Nombre = request.getParameter("idNombre");
        String Apellidos = request.getParameter("idApellidos");
        String idNombreUsuario = request.getParameter("idNombreUsuario");
        String idContraseña = request.getParameter("idContraseña");
        String idContraseña2 = request.getParameter("idContraseña2");
        int idTipo = Integer.parseInt(request.getParameter("idTipo").trim());
        
        Usuario usuario = new Usuario();
        usuario.setNombre(Nombre);
        usuario.setApellidos(Apellidos);
        usuario.setNombreUsuario(idNombreUsuario);
        usuario.setContraseña(idContraseña);
        usuario.setTipo(idTipo);

        IUsuarioService iUsuarioService = new UsuarioService();
        iUsuarioService.crearRegistro(usuario);

        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);
        dispatcher.forward(request, response);

    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuario/listar.jsp");
        
        Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
        String Nombre = request.getParameter("idNombre");
        String Apellidos = request.getParameter("idApellidos");
        String idNombreUsuario = request.getParameter("idNombreUsuario");
        String idContraseña = request.getParameter("idContraseña");
        String idContraseña2 = request.getParameter("idContraseña2");
        int idTipo = Integer.parseInt(request.getParameter("idTipo").trim());
        
        Usuario usuario = new Usuario();
        usuario.setNombre(Nombre);
        usuario.setApellidos(Apellidos);
        usuario.setNombreUsuario(idNombreUsuario);
        usuario.setContraseña(idContraseña);
        usuario.setTipo(idTipo);
        usuario.setIdUsuario(idUsuario);
        
        IUsuarioService iUsuarioService = new UsuarioService();
        iUsuarioService.actualizarRegistro(usuario);
        
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario);
	dispatcher.forward(request, response);        
    }
    /*
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/listar.jsp");
        
        Long idReservacion = Long.parseLong(request.getParameter("idReservacion"));
        
        IReservacionService iReservacionService = new ReservacionService();
        iReservacionService.eliminarRegistro(idReservacion);
        
        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
	dispatcher.forward(request, response);        
    }*/
    
}
