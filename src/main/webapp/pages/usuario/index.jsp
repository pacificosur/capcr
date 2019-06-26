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
    <div class="container-table">
        <table id="idTable" class="table">
            <thead>
                <tr>
                    <th style="display: none;">ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>USUARIO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody id="miTabla">
            <c:forEach var="usuario" items="${listaUsuario}">
                <tr>
                    <td style="display: none;"><c:out value="${usuario.idUsuario}"/></td>
                    <td><c:out value="${usuario.nombre}"/></td>
                    <td><c:out value="${usuario.apellidos}"/></td>
                    <td><c:out value="${usuario.nombreUsuario}"/></td>
                    <td><button type="button" class="btn btn-success class-actualizar-usuario"><i class="fa fa-edit"></i></button>
                        &nbsp&nbsp&nbsp<button type="button" class="btn btn-danger class-eliminar-usuario"><i class="fa fa-trash"></i></button> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="col-md-12 text-right">
        <ul class="pagination pagination-lg pager" id="myPager"></ul>
    </div>

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
                    <input type="hidden" name="idUsuario" class="form-control" id="idUsuario" >
                </div>

                <div class="form-group">
                    <label for="nombre"><span class="fa fa-user"></span>&nbsp NOMBRE</label>
                    <input type="text" name="idNombre" class="form-control" id="idNombre" placeholder="Ingrese el nombre" onkeypress="return soloLetras(event)" required>
                </div>

                <div class="form-group">
                    <label for="psw"><span class="fa fa-user"></span>&nbsp APELLIDOS</label>
                    <input type="text" name="idApellidos" class="form-control" id="idApellidos" placeholder="Ingrese los apellidos" onkeypress="return soloLetras(event)" required>
                </div>

                <div class="form-group">
                    <label for="psw"><span class="fa fa-user"></span>&nbsp USUARIO</label>
                    <input type="text" name="idNombreUsuario" class="form-control" id="idNombreUsuario" placeholder="Ingrese el usuario solo numeros,letras,guiones y puntos" onkeypress="return soloLetrasYnumeros(event)" required>
                </div>

                <div class="form-group">
                    <label for="psw"><span class=" fa fa-lock"></span>&nbsp CONTRASE�A</label>
                    <input type="password" name="idContrasena" class="form-control" id="idContrasena" placeholder="Ingrese la contrase�a solo numeros,letras,guiones y puntos" onkeypress="return soloLetrasYnumeros(event)" required>
                </div>

                <div class="form-group">
                    <label for="psw"><span class=" fa fa-lock"></span>&nbsp REPETIR CONTRASE�A</label>
                    <input type="password" name="idContrasena2" class="form-control" id="idContrasena2" placeholder="Confirme la contrase�a solo numeros,letras,guiones y puntos" onkeypress="return soloLetrasYnumeros(event)" required>
                </div>

                <div class="modal-footer">
                    
                    <li><a href="${pageContext.request.contextPath}/reporte">Generar</a></li>
                </div>
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

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success"><span class="fa fa-trash"></span>&nbsp Eliminar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>  
                    </div>
                </form>
            </div>
        </div>
    </div>
</div> 


<!-- Modal mensaje de contrase�as iguales -->
<div class="modal fade" id="id-modal-usuario-pwd-igual" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1 style="color: red">! Alerta � </h1>
            </div>
            <div class="modal-body">
                <div class="modal-header text-center">
                    <h1>Las contrase�as insertadas no son iguales.</h1>
                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Aceptar</button>  
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal mensaje de usuario ya existe -->
<div class="modal fade" id="id-modal-usuario-existe" role="dialog">
    <div class="modal-dialog" >
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1 style="color: red">! Alerta � </h1>
            </div>
            <div class="modal-body">
                <div class="modal-header text-center">
                    <h1>El usuario que intenta registrar ya existe.</h1>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Aceptar</button>
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
<script>
    document.title = "Usuario";
</script>
</body>
</html>
