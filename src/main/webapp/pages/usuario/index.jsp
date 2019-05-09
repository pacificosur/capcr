<%-- 
    Autor: Belisario Nazario Anselmo
    E-mail: unsis.b@gmail.com
    Fecha Creaci�n: 05/04/2019
    Fecha Modificaci�n: 08/05/2019
    Descripci�n: p�gina principal del m�dulo de usuario.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-usuario"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Crear usuario</button>
    <br/>
    <div class="table-responsive">
        <table id="idTable" class="table table-hover" style="width:100%">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td>APELLIDO</td>
                    <td>USUARIO</td>
                    <td>CONTRASE�A</td>
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
                    <td><c:out value="${usuario.contrase�a}"/></td>
                    <td><c:out value="${usuario.tipo}"/></td> 
                    <td><button type="button" class="btn btn-success class-actualizar-usuario"><i class="fa fa-edit"></i></button> </td>
                    <td><button type="button" class="btn btn-danger class-eliminar-usuario"><i class="fa fa-trash"></i></button> </td>
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
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/UsuarioController?accion=crear" method="POST" role="form">

                    <div class="form-group">
                        <input type="hidden" name="idUsuario" class="form-control" id="idUsuario" >
                    </div>

                    <div class="form-group">
                        <label for="nombre"><span class="fa fa-building"></span>&nbsp NOMBRE</label>
                        <input type="text" name="idNombre" class="form-control" id="idNombre" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese el nombre">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp APELLIDOS</label>
                        <input type="text" name="idApellidos" class="form-control" id="idApellidos" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese los apellidos">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-list"></span>&nbsp USUARIO</label>
                        <input type="text" name="idNombreUsuario" class="form-control" id="idNombreUsuario" placeholder="Ingrese el usuario">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp CONTRASE�A</label>
                        <input type="password" name="idContrasena" class="form-control" id="idContrasena" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese la contrase�a">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp REPETIR CONTRASE�A</label>
                        <input type="password" name="idContrasena2" class="form-control" id="idContrasena2" required pattern="^[\w\.\-\s]+$" placeholder="Confirme la contrase�a">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp TIPO</label>
                        <input type="text" name="idTipo" class="form-control" id="idTipo" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese el tipo">
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success" ><span class="fa fa-save"></span>&nbsp Guardar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>          
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>  

<!-- Modal Eliminar -->
<div class="modal fade" id="id-modal-usuario-eliminar" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1>�Est� seguro de eliminar este usuario?</h1>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/UsuarioController?accion=eliminar" method="POST" role="form">

                    <div class="form-group">
                        <input type="hidden" name="idUsuario-eliminar" class="form-control" id="idUsuario-eliminar" >
                    </div>

                    <div class="form-group">
                        <label for="nombre">NOMBRE:</label>
                        <p id="idNombre-eliminar"></p>
                    </div>
                    <div class="form-group">
                        <label for="psw">APELLIDOS</label>
                        <p id="idApellidos-eliminar"></p>                       
                    </div>

                    <div class="form-group">
                        <label for="psw">USUARIO</label>
                        <p id="idNombreUsuario-eliminar"></p> 
                    </div>

                    <div class="form-group">
                        <label for="psw">CONTRASE�A</label>
                        <p id="idContrasena-eliminar"></p>                         
                    </div>

                    <div class="form-group">
                        <label for="psw">TIPO</label>
                        <p id="idTipo-eliminar"></p>                         
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success"><span class="fa fa-trash"></span>&nbsp Eliminar</button>
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
<script src="${pageContext.request.contextPath}/resources/usuario/js/scriptUsuario.js"></script>
</body>
</html>
