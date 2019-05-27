
package com.unsis.capcr.controller;

//importacion de paquetes creados 
import com.unsis.capcr.entity.Rol;
import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.service.IRolService;
import com.unsis.capcr.service.IUsuarioService;
import com.unsis.capcr.service.RolService;
import com.unsis.capcr.service.UsuarioService;
//imporar paquetes externoss
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
    
    /**
     * carga la pagina con los datos actuales de los usuarios y los roles 
     */
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/roles/roles.jsp");
        Usuario user = new Usuario();
        user.setIdUsuario(Long.MIN_VALUE);
        //cargar la lista de los usuarios
        IUsuarioService iUsuarioService = new UsuarioService();
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario); 
        //cargar la lista de los roles
        IRolService iRolService = new RolService();
        List<Rol> listaRol = iRolService.obtenerRoles();
        request.setAttribute("listaRol", listaRol);
        
	dispatcher.forward(request, response);        
    }
    
    /**
     * recibe el nuevo parametro del rol de usuario y se modifica los datos
     * vuelve a mandar la lista de los usuarios actuales 
     */
    private void asignar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/roles/roles.jsp");
        //recibir los parametros necesarios para la obtencion de valores
        Long idUsuario= Long.parseLong(request.getParameter("idUsuario"));
        int tipo = Integer.parseInt(request.getParameter("tipoUsuario"));
        //creacion de usuario asignacion deparametros 
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setTipo(tipo);
        //cargar lista de los usuarios
        IUsuarioService iUsuarioService = new UsuarioService();
        iUsuarioService.asignarRol(usuario);
        List<Usuario> listaUsuario = iUsuarioService.obtenerUsuarios();
        request.setAttribute("listaUsuario", listaUsuario); 
        //cargar la lista de los roles
        IRolService iRolService = new RolService();
        List<Rol> listaRol = iRolService.obtenerRoles();
        request.setAttribute("listaRol", listaRol);
        //reenvia la peticion del servlet
	dispatcher.forward(request, response);        
    }
}
