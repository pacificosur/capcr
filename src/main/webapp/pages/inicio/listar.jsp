<%-- 

--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    /*Bloque de c�digo que nusca si existe una sesi�n*/
    if (session != null) {
        if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
        } else {
            response.sendRedirect("/capcr/pages/logueo/index.jsp");
        }
    }
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>CLINICA - RESERVACIONES</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/scriptReservacion.js"></script>
    </head>
    <body>
        <!-- Web Application Context Path = ${pageContext.request.contextPath} !-->
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                <a class="navbar-brand" href="#"><i class="fa fa-home"></i>Cl�nica</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Alumno</i><span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/inicioController?accion=home">Practica</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Reservaciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Acerca de...</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown link
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>                
            </nav>

            <br/>
            <button type="button" class="btn btn-success" id="id-btn-crear-reservacion"><i class="fa fa-plus"></i>&nbsp;Crear Registro</button>
            <br/>



    </body>
</html>
