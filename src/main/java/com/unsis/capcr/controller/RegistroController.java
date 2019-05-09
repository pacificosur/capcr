/*
 * Autor: Martínez García Eber
 * E-mail: berpy.1997@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del modulo registro
 */
package com.unsis.capcr.controller;

import com.unsis.capcr.entity.Registro;
import com.unsis.capcr.model.IRegistroModel;
import com.unsis.capcr.model.RegistroModel;
import com.unsis.capcr.service.IRegistroService;
import com.unsis.capcr.service.RegistroService;
import java.io.IOException;
import java.io.PrintWriter;
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
        String buscarAlumno = request.getParameter("matriculaAlumno");
        
        if(buscarAlumno != null){
            accion = "buscar";
        }
        switch (accion) {
            case "index":
                index(request, response);
                break;
            case "buscar":
                buscar(request, response, buscarAlumno);
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        dispatcher.forward(request,response);
        
        IRegistroService iRegistroService =new RegistroService();
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        System.out.println(listaRegistro.size());
        
        for (Registro registro : listaRegistro) {
             System.out.println(registro.getCodigoPractica()+" "+registro.getMatriculaAlumno()+" "+registro.getHoraEntrada()+" "+registro.getHoraSalida()+" "+registro.getSustituye());
        }
        
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);
    }
    
    private void buscar(HttpServletRequest request, HttpServletResponse response, String matricula) throws ServletException, IOException {
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        dispatcher.forward(request,response);*/
        
        IRegistroService iRegistroService =new RegistroService();
        Registro regis = iRegistroService.obtenerRegistroPorMatricula(matricula);
        //System.out.println("---> + " + listaRegistro.getCodigoPractica());
        /*System.out.println(listaRegistro.size());
        
        for (Registro registro : listaRegistro) {
             System.out.println(registro.getCodigoPractica()+" "+registro.getMatriculaAlumno()+" "+registro.getHoraEntrada()+" "+registro.getHoraSalida()+" "+registro.getSustituye());
        }
        
        request.setAttribute("listaRegistro", listaRegistro);
        dispatcher.forward(request, response);*/
        response.getWriter().write(regis.getCodigoPractica());
        response.getWriter().write(regis.getMatriculaAlumno());
        response.getWriter().write(regis.getHoraEntrada());
        response.getWriter().write(regis.getHoraSalida());
        response.getWriter().write(regis.getSustituye());
        
    }
/*
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        IRegistroService iRegistroService = new RegistroService(); 
        List<Registro>listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro",listaRegistro);
        dispatcher.forward(request,response);
    }
*/    
    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        
        //String matricula = request.getParameter("matriculaAlumno");
        
        //Registro registro = new Registro();
        /*
        registro.setMatriculaAlumno("matriculaAlumno");
        registro.setCodigoPractica("codigoPractica");
        registro.setHoraEntrada("horaEntrada");
        registro.setHoraSalida("horaSalida");
        registro.setSustituye("sustituye");*/
        
        //IRegistroService iRegistroService = new RegistroService();
        //iRegistroService.crearRegistro(registro);
        
        IRegistroService iRegistroService = new RegistroService();
        response.setContentType("Text/html");
        PrintWriter salida= response.getWriter();
        IRegistroModel ir= new RegistroModel();
        Registro regis=new Registro();
        String Matricula= request.getParameter("matricula");
        regis.setMatriculaAlumno(Matricula);
        
        /*
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
	dispatcher.forward(request, response);        */
    }
    
     private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/registro/index.jsp");
        
        Long idRegistro = Long.parseLong(request.getParameter("idRegistro"));
        
        IRegistroService iRegistroService = new RegistroService();
        iRegistroService.eliminarRegistro(idRegistro);
        
        List<Registro> listaRegistro = iRegistroService.obtenerRegistros();
        request.setAttribute("listaRegistro", listaRegistro);
	dispatcher.forward(request, response);        
    }
    
    private void reporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }
}
