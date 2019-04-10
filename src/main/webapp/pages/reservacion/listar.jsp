<%-- 
    Autor: Rolando Pedro Gabriel
    E-mail: rolando.pedro.gabriel@gmail.com
    Fecha Creación: 04/04/2019
    Fecha Modificación: 10/04/2019
    Descripción: página principal del módulo de Reservación.
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CLINICA - RESERVACIONES</title>
        <link rel="stylesheet" href="webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
    <div class="container">
            <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                <a class="navbar-brand" href="#"><i class="fa fa-home"></i>Clínica</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Alumno</i><span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Practica</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../../ReservacionController?accion=listar">Reservaciones</a>
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
        
        
	<h1>LISTA RESERVACIONES</h1>
	<table>
		<tr>
			<td><a href="ReservacionController?accion=home">Reservaciones</a></td>
		</tr>
	</table>
	
	<table class="table">
            <thead class="thead-dark">
		<tr>
		 <td> ID</td>
		 <td> FECHA INICIO</td>
		 <td> FECHA FIN</td>
		 <td>AREA</td>
		 <td>RES. AREA</td>
		 <td>PRACTICA</td>
                 <td>RES. PRACTICA</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
            </thead>
		<c:forEach var="reservacion" items="${listaReservacion}">
			<tr>
				<td><c:out value="${reservacion.idReservacion}"/></td>
				<td><c:out value="${reservacion.fechaInicio}"/></td>
				<td><c:out value="${reservacion.fechaFin}"/></td>
				<td><c:out value="${reservacion.area}"/></td>
				<td><c:out value="${reservacion.responsableArea}"/></td>
				<td><c:out value="${reservacion.practica}"/></td>
                                <td><c:out value="${reservacion.responsablePractica}"/></td>
				<td><a href="#" >Editar</a></td>
				<td><a href="#" >Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
    </div>
</body>
</html>
