<%-- 
    Autor: Rolando Pedro Gabriel
    E-mail: rolando.pedro.gabriel@gmail.com
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: página principal del módulo de Reservación.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <table id="idTable" class="table">
                <thead class="thead-dark">
                    <tr>
                        <td> IDUSARIO</td>
                        <td> NOMBRE</td>
                        <td> APELLIDOS</td>
                        <td> NOMBREUSUARIO</td>
                        <td> CONTRASEÑA</td>
                        <td> TIPO</td>
                     
                    </tr>
                </thead>
                <c:forEach var="usuario" items="${listaUsuarios}">
                    <tr>
                        <td><c:out value="${usuario.idReservacion}"/></td>
                        <td><c:out value="${usuario.fechaInicio}"/></td>
                        <td><c:out value="${usuario.fechaFin}"/></td>
                        <td><c:out value="${usuario.area}"/></td>
                        <td><c:out value="${usuario.responsableArea}"/></td>
                        <td><c:out value="${usuario.practica}"/></td>
                        <td><c:out value="${usuario.responsablePractica}"/></td>
                        		
                    </tr>
                </c:forEach>
            </table>


    </body>
</html>
