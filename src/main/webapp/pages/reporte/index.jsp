<%-- 
    Document   : index
    Created on : 19/06/2019, 02:34:06 PM
    Author     : BELI
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-usuario"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Generar reporte</button>
    <br/>
    
<div class="col-md-12 text-center">
    <ul class="pagination pagination-lg pager" id="myPager"></ul>
</div>

<!-- Modal -->
<div class="modal fade" id="id-modal-usuario" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/usuario/img/usuario.png" />
            </div>
            <div class="modal-body">
                
                <div class="form-group">
                    <label for="semestre"><span class="fa fa-user"></span>&nbsp Semestre</label>
                    <input type="text" name="idSemestre" class="form-control" id="idSemestre" placeholder="Ingrese el semestre" required>
                </div>

                <div class="form-group">
                    <label for="NombrePractica"><span class="fa fa-user"></span>&nbsp Nombre de practica</label>
                    <input type="text" name="idNombrePractica" class="form-control" id="idNombrePractica" placeholder="Ingrese el nombre de la practica" required>
                </div>

                <div class="form-group">
                    <label for="Grupo"><span class="fa fa-user"></span>&nbsp Grupo</label>
                    <input type="text" name="idGrupo" class="form-control" id="idGrupo" placeholder="Ingrese el grupo" required>
                </div>

                <div class="form-group">
                    <label for="FechaInicio"><span class=" fa fa-lock"></span>&nbsp Fecha Inicio</label>
                    <input type="text" name="idFechaInicio" class="form-control" id="idFechaInicio" placeholder="Ingrese la fecha de inicio de parcial." required>
                </div>

                <div class="form-group">
                    <label for="FechaFin"><span class=" fa fa-lock"></span>&nbsp Fecha Fin</label>
                    <input type="text" name="idFechaFin" class="form-control" id="idFechaFin" placeholder="Ingrese la fecha de fin del parcial" required>
                </div>

                <div class="modal-footer">
                    <button type="button" id="boton-enviar-datos" class="btn btn-default btn-success" ><span class="fa fa-save"></span>&nbsp Generar</button>
                    <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>          
                </div>
            </div>
        </div>
    </div>
</div>  





<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/resources/usuario/css/cssUsuario.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/usuario/js/scriptUsuario.js"></script>
<script src="${pageContext.request.contextPath}/resources/usuario/js/validaciones.js"></script>
</body>
</html>


