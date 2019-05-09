<%-- 
    Autor: Jose Benito Gomez Sanchez
    E-mail: josegomz.sa17@gmail.com 
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: página principal del módulo de Asignación de roles.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
<table id="idTable" class="table">
    <thead class="thead-dark">
        <tr>
            <td> IDUSARIO</td>
            <td> NOMBRE</td>
            <td> APELLIDOS</td>
            <td> NOMBREUSUARIO</td>
            <td> CONTRASEÑA</td>
            <td colspan=2> ROL</td>
        </tr>
    </thead>
    <c:forEach var="usuario" items="${listaUsuario}">
    
        <tr>
            <td><c:out value="${usuario.idUsuario}"/></td>
            <td><c:out value="${usuario.nombre}"/></td>
            <td><c:out value="${usuario.apellidos}"/></td>
            <td><c:out value="${usuario.nombreUsuario}"/></td>
            <td><c:out value="${usuario.contraseña}"/></td>
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

</table>
<!-- Modal -->
<div class="modal fade" id="id-modal-rol" role="dialog">
    <div class="modal-dialog">
        <!-- Contenido del moda-->
        <div class="modal-content">
            <div class="modal-header text-center" >
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/practica/img/logo-modal-header.png" />
            </div>
            <form action="${pageContext.request.contextPath}/RolesController?accion=actualizar" method="POST" role="form" id="formulario">
                <div class="modal-body">
                    <div class="form-group">
                        <input id="crearPractica" type="hidden" name="crearPractica" class="form-control">
                    </div>
                    <c:forEach var="rol" items="${listaRol}">
                        <div class="form-check">
                            <label class="form-check-label" for="radio1">
                            <input type="radio" class="form-check-input" id="radio<c:out value="${rol.idRol}"/> " name="optradio" value="<c:out value="${rol.nombre}"/>"  checked><c:out value="${rol.nombre}"/>                                        </label>
                        </div>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Asingar rol</button>
                    <button type="submit" class="btn btn-default btn-default btn-danger btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span>Cancelar</button>          
                </div>
            </form>        
        </div>
    </div>
</div>
<!-- Fin del modal -->


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/roles/js/scriptRoles.js"></script>
</body>
</html>
