/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
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
    private IReservacionService iReservacionService = new ReservacionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hola get");
        String accion = request.getParameter("accion");
        
        try {
            switch(accion) {
                case "home":
                    home(request, response);
                    break;
                case "listar":
                    listar(request, response);
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
    
    private void home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/home.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reservacion/listar.jsp");
        List<Reservacion> listaReservacion = iReservacionService.obtenerRegistros();
        request.setAttribute("listaReservacion", listaReservacion);
	dispatcher.forward(request, response);        
    }
}


/*

Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("Conexión Establecida");


<dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-web-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.1</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
            
        <dependency>
            <groupId>postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>9.1-901-1.jdbc4</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
        <!--        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>-->
        
        <!-- https://mvnrepository.com/artifact/org.webjars/bootstrap -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>4.2.1</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.webjars.bower/jquery -->
        <dependency>
            <groupId>org.webjars.bower</groupId>
            <artifactId>jquery</artifactId>
            <version>3.3.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.webjars.bower/fontawesome -->
        <dependency>
            <groupId>org.webjars.bower</groupId>
            <artifactId>fontawesome</artifactId>
            <version>4.7.0</version>
        </dependency>
*/