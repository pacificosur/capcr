<%-- 
    Document   : listar
    Created on : 10/04/2019, 06:54:30 PM
    Author     : LabTW03
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
<br/>
<button type="button" class="btn btn-success" id="id-btn-crear-alumno"><i class="fa fa-plus"></i>&nbsp;Crear Alumno</button>
<br/>
<table id="idTable" class="table">
    <thead class="thead-dark">
        <tr>
            <td>MATRICULA</td>
            <td>NOMBRE</td>
            <td>GRUPO</td>
            <td>SEMESTRE</td>
            <td>CARRERA</td>
            <td colspan=2>ACCIONES</td>
        </tr>
    </thead>
    <c:forEach var="alumnos" items="${listaAlumnos}">
        <tr>
            <td><c:out value="${alumno.Matricula}"/></td>
            <td><c:out value="${alumno.Nombre}"/></td>
            <td><c:out value="${alumno.Grupo}"/></td>
            <td><c:out value="${alumno.CodigoSemetre}"/></td>
            <td><c:out value="${alumno.CodigoCarrera}"/></td>
            <td><button type="button" class="btn btn-success class-actualizar-alumno"><i class="fa fa-edit"></i></button> </td>	
            <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/AlumnosController?accion=eliminar&idAlumno<c:out value="${alumno.Matricula}"/>"><i class="fa fa-trash"></i></a> </td>				
        </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="id-modal-alumno" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span></h4>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/AlumnosController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <label for="matricula"><span class="glyphicon glyphicon-user"></span>&nbsp Matricula</label>
                        <input type="text" name="matricula" class="form-control" id="idMatricula" placeholder="Ingrese la matricula">
                    </div>
                    <div class="form-group">
                        <label for="nombre"><span class="glyphicon glyphicon-user"></span>&nbsp Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="idNombre" placeholder="Ingrese el nombre">
                    </div>
                    <div class="form-group">
                        <label for="grupo"><span class="glyphicon glyphicon-user"></span>&nbsp Grupo</label>
                        <input type="text" name="grupo" class="form-control" id="idGrupo" placeholder="Ingrese el grupo">
                    </div>
                    <div class="form-group">
                        <label for="semestre"><span class="glyphicon glyphicon-user"></span>&nbsp Semestre</label>
                        <input type="text" name="semestre" class="form-control" id="idCodigoSemestre" placeholder="Ingrese el semestre">
                    </div>
                    <div class="form-group">
                        <label for="carrera"><span class="glyphicon glyphicon-user"></span>&nbsp Carrera</label>
                        <input type="text" name="carrera" class="form-control" id="idCodigoCarrera" placeholder="Ingrese la carrera">
                    </div>
                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Guardar</button>
                </form>
            </div>
                <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-default btn-danger btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>          
            </div>
        </div>
    </div>
 </div>  
    <%-- El footer se encuentra en la carperta layouts en la carpeta pages.
    el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body--%> 
    <jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/resources/alumno/js/scriptAlumnos.js"></script><%--lugar donde se encuentra el script encargado de la creación del alumno--%>
    </body>
</html>
