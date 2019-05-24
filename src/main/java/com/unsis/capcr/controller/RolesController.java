
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Rol;
import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.service.IRolService;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.RolService;
import com.unsis.capcr.service.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RolesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        switch(accion){
            case "index":
                listar(request,response);
                break;
            case "asignar":
                listar(request,response);
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

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/roles/roles.jsp");
        Usuario user = new Usuario();
        user.setIdUsuario(Long.MIN_VALUE);
        
        IUsuarioService iUsuarioService = new UsuarioService();
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario); 
        
        IRolService iRolService = new RolService();
        List<Rol> listaRol = iRolService.obtenerRoles();
        request.setAttribute("listaRol", listaRol);
        
	dispatcher.forward(request, response);        
    }

    private void asignar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/roles/roles.jsp");
        
        IUsuarioService iUsuarioService = new UsuarioService();
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario); 
        
        IRolService iRolService = new RolService();
        List<Rol> listaRol = iRolService.obtenerRoles();
        request.setAttribute("listaRol", listaRol);
        
	dispatcher.forward(request, response);        
    }
}
