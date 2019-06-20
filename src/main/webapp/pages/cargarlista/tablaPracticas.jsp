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
<div class="cargar-practicas">
    <div class="container-table">
        <table id="idTable2 tabla-practica" class="table">
            <thead>
            <th>Código</th>
            <th>Nombre</th>
            <th>Semestre</th>
            <th>Carrera</th>
            </thead>
            <tbody id="miTabla2">
                <c:forEach var="practica" items="${listaPractica}">
                    <tr>
                        <td><c:out value="${practica.codigo}"/></td>
                        <td><c:out value="${practica.nombre}"/></td>
                        <td><c:out value="${practica.idSemestre}"/></td>
                        <td><c:out value="${practica.idCarrera}"/></td>				
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="col-md-12 text-right">
            <ul class="pagination pagination-lg pager2" id="myPager2"></ul>
        </div>
        <button type="button" class="btn btn-success marginbot-10 margintop-10" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
    </div>
</div>


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
<script>
    document.title = 'Hola!';
</script>
</body>
</html>
