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
        <div class="col-md-6">
            <input type="text" class="form-control form-control-lg col-md-3 input-matricula-registro" placeholder="Matricula del alumno" name="matricula" onkeypress=" return soloNumeros(event)" maxlength="10" onkeyup = "abrirModal(event)" autofocus>
        </div>
        <div class="col-md-6">
            <button type="button" class="btn btn-success boton-agregar-registro" id="id-btn-crear-registro"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Agregar</button>
        </div>
    </div>
    <table id="idTable" class="table table-hover">
        <thead class="thead-dark">
            <tr>
                <th> Nombre Alumno</th>
                <th> Matricula Alumno</th>
                <th> Práctica</th>
                <th> Hora Entrada</th>
                <th> Sustituye</th>
                <th> Finalizar</th>
            </tr>
        </thead>
        <!--        <th class="tabla-data"></th>-->
        <c:forEach var="registro" items="${listaRegistro}">
            <tr>
                <td><c:out value="${registro.nombreAlumno}"/></td>
                <td><c:out value="${registro.matriculaAlumno}"/></td>
                <td><c:out value="${registro.codigoPractica}"/></td>
                <td><c:out value="${registro.horaEntrada}"/></td>
                <td><c:out value="${registro.sustituye}"/></td>
                <td><a name="<c:out value="${registro.idRegistro}"/>" type="button" class="btn btn-cancelar-registro"><i class="fa fa-remove"></i></a>
                    <a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/RegistroController?accion=eliminar&idRegistro=<c:out value="${registro.idRegistro}"/>"><i class="fa fa-check"></i></a> </td>
                <!--<td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/RegistroController?accion=eliminar&idRegistro=<c:out value="${registro.idRegistro}"/>"><i class="fa fa-remove"></i></a> </td>-->
            </tr>
    </c:forEach>
</table>
<!-- Modal -->
<div class="modal fade" id="id-modal-registro" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/reservacion/img/logo-modal-header.png" />
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/RegistroController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idmatricula" class="form-control" id="idmatricula">
                    </div>
                    <div class="card text-center">
                        <div class="card-header">
                            <p id="txtidmatricula"></p>
                            <p id="txtidnombre"></p>
                        </div>

                        <div class="card-body">
                            <div class="form-group">    
                                <label for="nombre-practica"><span class="fa fa-building"></span>&nbsp Nombre de la Practica</label>
                                <select id="idselect" name="seleccionar-practica" class="form-control custom-select" style="border-radius: 1em;">
                                    <option selected>Practica que realiza</option>
                                </select>
                                <!--                            <input type="text" name="nombre-practica" class="form-control" id="idArea" placeholder="Nombre de la practica">-->
                            </div>
                            <div class="form-group">
                                <label for="sustituye"><span class="fa fa-user"></span>&nbsp Sustituye</label>
                                <select name="hora-sustituye" class="form-control custom-select" style="border-radius: 1em;">
                                    <option selected>Hora que sustituye</option>
                                    <option value="Biblioteca">Biblioteca</option>
                                    <option value="Tutoria">Tutoria/Asesotia</option>
                                    <option value="Libre">Libre</option>
                                </select>
                                <!--                            <input type="text" name="sustituye" class="form-control" id="idSustituye" required pattern="^[\w\.\-\s]+$" placeholder="Hora que sustituye">-->
                            </div>

                        </div>
                        <div class="card-footer text-muted">
                            <button type="submit" class="btn btn-default btn-success" id="guardaRegistro"><span class="fa fa-save"></span>&nbsp Guardar</button>
                            <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal Eliminar -->
<div class="modal fade" id="id-modal-cancelar-registro" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1>¿Está seguro de cancelar este registro?</h1>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/RegistroController?accion=actualizar" method="POST" role="form">

                    <div class="form-group">
                        <input type="hidden" name="idRegistro" class="form-control" id="idRegistro" >
                    </div>
                    <div class="form-group">
                        <h5>Escribe el motivo de cancelación</h5>
                        <textarea name="comentario" id="comentario" cols="50" rows="5"></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success" id="boton-cancelar-registro"><span class="fa fa-trash"></span>&nbsp Eliminar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>  
                    </div>
                </form>
            </div>
        </div>
    </div>
</div> 
<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>

    <script src="${pageContext.request.contextPath}/resources/registro/js/scriptRegistro.js"></script>
<script src="${pageContext.request.contextPath}/resources/registro/js/validaciones.js"></script>
</body>
</html>
