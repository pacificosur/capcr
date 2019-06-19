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
<div class="col-md-12 text-center" id="botones-cargar">
    <button type="button" class="btn btn-success" id="cargar-lista-alumno">&nbsp;Alumno</button>
    <button type="button" class="btn btn-success" id="cargar-lista-practica">&nbsp;Practica</button>
</div>

<div class="cargar-alumnos" style="display:none;">
    <div class="container-table">
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
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>	
                </tr>
            </tbody>

        </table>
        <div class="col-md-12 text-right">
            <ul class="pagination pagination-lg pager" id="myPager"></ul>
        </div>
        <button type="button" class="btn btn-success" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
    </div>
</div>

<div class="cargar-practicas" style="display:none;">
    <div class="container-table">
        <input type="file" accept=".xls, .xlsx" id="my_file_input"/>  

        <table id="idTable2 tabla-practica" class="table">
            <thead>
            <th>Código</th>
            <th>Nombre</th>
            <th>Semestre</th>
            <th>Carrera</th>
            </thead>
            <tbody id="miTabla2">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <div class="col-md-12 text-right">
            <ul class="pagination pagination-lg pager2" id="myPager2"></ul>
        </div>
        <button type="button" class="btn btn-success" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
    </div>
</div>


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
<script>

</script>
</body>
</html>
