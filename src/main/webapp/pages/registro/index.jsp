<%-- 
    Autores: Martínez García Eber
    E-mail: hebber.garcia.1997@gmail.com
    Fecha Creación: 10/04/2019
    Fecha Modificación: 03/05/2019
    Descripción: página principal del módulo de Registro.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

<div class="row">
    <div class="col-lg-5">
        <input type="text" class="form-control form-control-lg col-md-3" placeholder="Matricula del alumno" name="text3">
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
    <c:forEach var="registro" items="${listaRegistro}">
        <tr>
            <td><c:out value="${practica.codigo}"/></td>
            <td><c:out value="${practica.nombre}"/></td>
            <td><c:out value="${practica.idSemestre}"/></td>
            <td><c:out value="${practica.idCarrera}"/></td>
            <td><c:out value="${practica.fechaCreacion}"/></td>
            <td><c:out value="${practica.fechaActualizacion}"/></td>
            <td><c:out value="${practica.fechaEliminacion}"/></td>
            <td><button type="button" class="btn btn-success class-actualizar-registro"><i class="fa fa-edit"></i></button> </td>	
            <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/RegistroController?accion=eliminar&matriculaAlumno=<c:out value="${registro.matriculaAlumno}"/>"><i class="fa fa-trash"></i></a> </td>				
        </tr>
    </c:forEach>
</table>
 <!-- Modal -->
<div class="modal fade" id="id-modal-reservacion" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span></h4>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/ReservacionController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idReservacion" class="form-control" id="idReservacion" >
                    </div>

                    <div class="form-group">
                        <label for="area"><span class="glyphicon glyphicon-user"></span>Area</label>
                        <input type="text" name="area" class="form-control" id="idArea" placeholder="Ingrese el area">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Responsable</label>
                        <input type="text" name="responsableArea" class="form-control" id="idAreaResponsable" placeholder="Ingrese el responsable">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Practica</label>
                        <input type="text" name="practica" class="form-control" id="idPractica" placeholder="Ingrese la practica">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Responsable Practica</label>
                        <input type="text" name="responsablePractica" class="form-control" id="idPracticaResponsable" placeholder="Ingrese el responsable de la practica">
                    </div>

                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Guardar</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-default btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>          
            </div>
        </div>
    </div>
</div>  

<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>

    <script src="${pageContext.request.contextPath}/resources/js/scriptReservacion.js"></script>
</body>
</html>