<%-- 
    Autor: Jose Benito Gomez Sanchez
    E-mail: josegomz.sa17@gmail.com 
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: página principal del módulo de Asignación de roles.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    /*Bloque de código que nusca si existe una sesión*/
//		if (session != null) {
//			if (session.getAttribute("user") != null) {
//				String name = (String) session.getAttribute("user");
//			} else {
//				response.sendRedirect("/capcr/pages/logueo/index.jsp");
//			}
//		}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- se añade la cabecera  --%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

<%-- cuerpo de la pagina --%>
<table id="idTable" class="table">
    <thead class="thead-dark">
        <tr>
            <td> ID Usuario</td>
            <td> Nombre</td>
            <td> Apellidos</td>
            <td> Nombre Usuario</td>
            <td colspan=2> Rol</td>
        </tr>
    </thead>

    <%-- cargar la lista de los usuarios con su respectivo rol --%>
    <c:forEach var="usuario" items="${listaUsuario}">
        <tr>
            <td><c:out value="${usuario.idUsuario}"/></td>
            <td><c:out value="${usuario.nombre}"/></td>
            <td><c:out value="${usuario.apellidos}"/></td>
            <td><c:out value="${usuario.nombreUsuario}"/></td>
            <td>       
                <c:forEach var="rol" items="${listaRol}"> <%-- Por cada que recorre un usuario recorre toda la lista de rol para ver que rol es el que tiene--%>
                    <%-- Bloque de comparacion del tipo del usuario con el id del rol si sale un verdadero impime el nombre del rol --%>
                    <c:if test="${(usuario.tipo)==(rol.idRol)}">
                        <c:out value = "${rol.nombre}"/>
                    </c:if>   
                </c:forEach>
            </td>
            <td><button type="button" class="btn btn-success class-asignar-rol"><i class="fa fa-edit"></i></button></td>
        </tr>

    </c:forEach>
    <%--fin del listado--%>
</table>
<!-- din de la tabla  -->

<!-- Modal -->
<div class="modal fade" id="id-modal-rol" role="dialog">
    <div class="modal-dialog">
        <!-- Contenido del moda-->
        <div class="modal-content">
            <div class="modal-header text-center" >
                <button type="button" class="close" id="cerrar-model" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/roles/img/usuario.png" />
            </div>
            <form action="${pageContext.request.contextPath}/RolesController?accion=asignar" method="POST" role="form" id="formulario">
                <div class="modal-body">
                    <div id="valores-de-usuario">
                        <input id="idUsuario" type="text" name="idUsuario" value="" />
                        <input id="tipoUsuario" type="text" name="tipoUsuario" value="" />
                    </div>
                    <c:forEach var="rol" items="${listaRol}">
                        <!--<div class="form-check"> -->
                        <label class="form-check-label" for="radio<c:out value="${rol.idRol}"/>">
                            <input type="radio" class="radio<c:out value="${rol.idRol}"/>" name="optradio" >&nbsp;<c:out value="${rol.nombre}"/>         
                        </label> <br>
                        <!--</div> -->
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="modificar_rol" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Asingar rol</button>          
                </div>
            </form>
            <div class="modal-body" >
                <button type="submit" id="cancelar" class="btn btn-default btn-default btn-danger btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>Cancelar</button>
            </div>
        </div>
    </div>
</div>
<!-- Fin del modal -->


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/roles/js/scriptRoles.js"></script>
<link href="${pageContext.request.contextPath}/resources/roles/css/cssRoles.css" rel="stylesheet" />
</body>
</html>
