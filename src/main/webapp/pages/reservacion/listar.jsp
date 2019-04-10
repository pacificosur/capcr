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
</head>
<body>
	<h1>LISTA RESERVACIONES</h1>
	<table>
		<tr>
			<td><a href="ReservacionController?accion=home">Reservaciones</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
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
	
</body>
</html>
