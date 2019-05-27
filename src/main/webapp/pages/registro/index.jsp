<%-- 
    Autores: Martínez García Eber
    E-mail: hebber.garcia.1997@gmail.com
    Fecha Creación: 10/04/2019
    Fecha Modificación: 03/05/2019
    Descripción: página principal del módulo de Registro.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
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
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

<div class="row">
    <div class="col-md-6">
        <input type="text" class="form-control form-control-lg col-md-3 input-matricula-registro" placeholder="Matricula del alumno" name="matricula">
    </div>
    <div class="col-md-6">
        <button type="button" class="btn btn-info boton-agregar-registro">Agregar</button>
    </div>
    
    <div>
        
    </div>
    
</div>
<table id="idTable" class="table table-hover">
    <thead class="thead-dark">
        <tr>
            <td> Codigo Practica</td>
            <td> Matricula Alumno</td>
            <td> Hora Entrada</td>
            <td> Hora Salida</td>
            <td> Fecha</td>
            <td> Sustituye</td>
            <td> Comentario</td>
        </tr>
    </thead>
    <th class="tabla-data"></th>
    <c:forEach var="registro" items="${listaRegistro}">
        <tr>
            <td><c:out value="${registro.matriculaAlumno}"/></td>
            <td><c:out value="${registro.codigoPractica}"/></td>
            <td><c:out value="${registro.horaEntrada}"/></td>
            <td><c:out value="${registro.horaSalida}"/></td>
            <td><c:out value="${registro.sustituye}"/></td>
            <td><button type="button" class="btn btn-danger class-eliminar-registro"><i class="fa fa-trash"></i></button> </td>
            <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/RegistroController?accion=eliminar&matriculaAlumno=<c:out value="${registro.matriculaAlumno}"/>"><i class="fa fa-trash"></i></a> </td>				
        </tr>
    </c:forEach>
</table>
 <!-- Modal -->


<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>

    <script src="${pageContext.request.contextPath}/resources/registro/js/scriptRegistro.js"></script>
</body>
</html>