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
                                    <td colspan=4> ROL</td>
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
                                    <div class="dropdown">
                                        <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                                            Roles
                                        </button>
                                        <div class="dropdown-menu">
                                            <c:forEach var="rol" items="${listaRol}">
                                                <div class="form-check">
                                                    <label class="form-check-label" for="radio1">
                                                        <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked><c:out value="${rol.nombre}"/>                                        </label>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </td>   		
                            </tr>
                            </c:forEach>
                            
                        </table>
                        
                    <jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
    </body>
</html>
