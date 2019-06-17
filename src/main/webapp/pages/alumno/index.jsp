<%-- 
    Document   : listar
    Created on : 10/04/2019, 06:54:30 PM
    Author     : LabTW03
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    /*Bloque de código que nusca si existe una sesión*/
    if (session != null) {
        if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
        } else {
            response.sendRedirect("/capcr/pages/logueo/index.jsp");
        }
   }
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-alumno"><i class="fa fa-plus"></i>&nbsp;Crear Alumno</button>
    <br/>
    <div class="container-table">
        <table id="idTable" class="table">
            <thead class="thead-dark">
                <tr>
                    <th>MATRÍCULA</th>
                    <th>NOMBRE</th>
                    <th>GRUPO</th>
                    <th>SEMESTRE</th>
                    <th>CARRERA</th>
                    <th colspan=2>ACCIONES</th>
                </tr>
            </thead>
            <tbody id="miTabla"> 
            <c:forEach var="alumno" items="${listaAlumno}">
                <tr>
                    <td><c:out value="${alumno.matricula}"/></td>
                    <td><c:out value="${alumno.nombre}"/></td>
                    <td><c:out value="${alumno.grupo}"/></td>
                    <td><c:out value="${alumno.codigoSemestre}"/></td>
                    <td><c:out value="${alumno.codigoCarrera}"/></td>
                    <td><button type="button" class="btn btn-success class-actualizar-alumno"><i class="fa fa-edit"></i></button> </td>	
                    <td><button type="button" class="btn btn-success class-eliminar-alumno"><i class="fa fa-trash"></i></button> </td>				
                </tr>
            </c:forEach>
            </tbody>
            
        </table>
        <div class="col-md-12 text-right">
            <ul class="pagination pagination-lg pager" id="myPager"></ul>
        </div>
    </div>


<!-- Modal -->
<div class="modal fade" id="id-modal-alumno" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center" >
                <button type="button" class="close" id="cerrar-model" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/alumno/img/logo-modal-header.png" />
            </div>

            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/AlumnosController?accion=crear" method="POST" role="form">

                    <div class="form-group">
                        <label for="matricula"><span class="glyphicon glyphicon-tag"></span>&nbsp Matrícula</label>
                        <input type="text" name="matricula" class="form-control" id="idMatricula" placeholder="Ingrese la matrícula" required pattern="[0-9]{10}" required>  
                    </div>
                    <div class="form-group">
                        <label for="nombre"><span class="glyphicon glyphicon-user"></span>&nbsp Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="idNombre" placeholder="Ingrese el nombre" required pattern= "/[A-Za-zñÑ-áéíóúÁÉÍÓÚ\s\t-]/{5-40}" >
                    </div>
                    <div class="form-group">
                        <label for="grupo"><span class="glyphicon glyphicon-home"></span>&nbsp Grupo</label>
                        <input type="text" name="grupo" class="form-control" id="idGrupo" placeholder="Ingrese el grupo" required pattern="[0-9]{3}" required>
                    </div>
                    <div class="form-group">
                        <label for="semestre"><span class="glyphicon glyphicon-road"></span>&nbsp Semestre</label>
                        <input type="text" name="semestre" class="form-control" id="idCodigoSemestre" placeholder="Ingrese el semestre" required pattern="[0-9]{2}" required>
                    </div>
                    <div class="form-group">
                        <label for="carrera"><span class="glyphicon glyphicon-heart"></span>&nbsp Carrera</label>
                        <input type="text" name="carrera" class="form-control" id="idCodigoCarrera" placeholder="Ingrese la carrera" required pattern="[0-9]{2}" required>
                    </div>
                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Guardar</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-default btn-danger btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>          
            </div>
        </div>
    </div>
</div>  





<!-- Modal Eliminar -->
<div class="modal fade" id="id-modal-alumno-eliminar" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1>¿Desea eliminar el alumno?</h1>
            </div>
            <div class="modal-body">             
                
                <form action="${pageContext.request.contextPath}/AlumnoController?accion=eliminar" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idMatricula-eliminar-no-mostrar" id="idMatricula-eliminar-no-mostrar" >                 
                    </div>
                    <div class="form-group">
                        <label for="matricula">Matrícula:</label>
                        <p id="idMatricula-eliminar-mostrar"></p>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <p id="idNombre-eliminar"></p>                       
                    </div>

                    <div class="form-group">
                        <label for="grupo">Grupo</label>
                        <p id="idGrupo-eliminar"></p>                       
                    </div>

                    <div class="form-group">
                        <label for="semestre">Semestre</label>
                        <p id="idCodigoSemestre-eliminar"></p> 
                    </div>

                    <div class="form-group">
                        <label for="carrera">Carrera</label>
                        <p id="idCodigoCarrera-eliminar"></p>                         
                    </div>
                    
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success"><span class="fa fa-trash"></span>&nbsp Eliminar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span>Cancelar</button> 
                    </div>
                </form>
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
