<%-- 
    Autor: Belisario Nazario Anselmo
    E-mail: unsis.b@gmail.com
    Fecha Creación: 04/04/2019
    Fecha Modificación: 07/05/2019
    Descripción: página principal del módulo de Usuario.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-usuario"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Crear Usuario</button>
    <br/>
    <div class="table-responsive">
        <table id="idTable" class="table table-hover" style="width:100%">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td>APELLIDO</td>
                    <td>USUARIO</td>
                    <td>CONTRASEÑA</td>
                    <td>TIPO</td>
                    <td colspan=2>ACCIONES</td>
                </tr>
            </thead>
            <tbody id="miTabla">
            <c:forEach var="usuario" items="${listaUsuario}">
                <tr>
                    <td><c:out value="${usuario.idUsuario}"/></td>
                    <td><c:out value="${usuario.nombre}"/></td>
                    <td><c:out value="${usuario.apellidos}"/></td>
                    <td><c:out value="${usuario.nombreUsuario}"/></td>
                    <td><c:out value="${usuario.contraseña}"/></td>
                    <td><c:out value="${usuario.tipo}"/></td> 
                    <td><button type="button" class="btn btn-success class-actualizar-usuario"><i class="fa fa-edit"></i></button> </td>
                    <td><a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/UsuarioController?accion=eliminar&idUsuario=<c:out value="${usuario.idUsuario}"/>"><i class="fa fa-trash"></i></a> </td>			
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
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
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/usuario/img/logo-modal-header.png" />
                <!--                <h4 style="color: forestgreen; text-align: center"><span class="fa fa-lock"></span>&nbsp Usuario</h4>-->
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/UsuarioController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idUsuario" class="form-control" id="idUsuario" >
                    </div>

                    <div class="form-group">
                        <label for="nombre"><span class="glyphicon glyphicon-user"></span>Nombre</label>
                        <input type="text" name="idNombre" class="form-control" id="idNombre" placeholder="Ingrese el nombre">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Apellido</label>
                        <input type="text" name="idApellidos" class="form-control" id="idApellidos" placeholder="Paterno    Materno">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Usuario</label>
                        <input type="text" name="idNombreUsuario" class="form-control" id="idNombreUsuario" placeholder="nuevo usuario">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Contraseña</label>
                        <input type="text" name="idContraseña" class="form-control" id="idContraseña" placeholder="Ingrese la contraseña">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Confirmar contraseña</label>
                        <input type="text" name="idContraseña2" class="form-control" id="idContraseña2" placeholder="Confirme su contraseña">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Tipo</label>
                        <input type="text" name="idTipo" class="form-control" id="idTipo" placeholder="Ingrese el tipo">
                    </div>

                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="fa fa-save"></span>&nbsp Guardar</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-danger btn-block" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>          
            </div>
        </div>
    </div>
</div>  


<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/Usuario/js/scriptUsuario.js"></script>
</body>
</html>
