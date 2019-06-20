<%-- 
    Autor: Jose Benito Gomez Sanchez
    E-mail: josegomz.sa17@gmail.com 
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: carga listas de excel y los manda a la base de datos
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- se añade la cabecera  --%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

<%-- cuerpo de la pagina --%>
<div class="cargar-alumnos">
    <div class="container-table">
        <form action="${pageContext.request.contextPath}/RolesController?accion=asignar" method="POST" role="form" id="formulario">
            <table id="idTable" class="table">
                <thead>
                    <tr>
                        <th>MATRÍCULA</th>
                        <th>NOMBRE</th>
                        <th>GRUPO</th>
                        <th>SEMESTRE</th>
                        <th>CARRERA</th>
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
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            <div class="col-md-12 text-right">
                <ul class="pagination pagination-lg pager" id="myPager"></ul>
            </div>
            <button type="button" class="btn btn-success marginbot-10 margintop-10" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
        </form>
    </div>
</div>

<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
</body>
</html>
