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
    <div class="container-files margintop-20">
        <p class="text-center">Lista de alumnos</p>
        <form action="${pageContext.request.contextPath}/CargarListasController?accion=cargar_lista_alumno" method="POST" role="form" id="formulario" >
            <input type="file" accept="xls,xlsx" id="input-file-practica" name="archivo-xml">
            <button type="submit" class="btn btn-default btn-success btn-block">Cargar lista</button>
        </form>
    </div>
</div>

<div class="cargar-practicas" style="display:none;">
    <div class="container-files margintop-20">
        <p class="text-center">Lista de prácticas</p>
        <form action="${pageContext.request.contextPath}/CargarListasController?accion=cargar_lista_practica" method="POST" role="form" id="formulario">
            <input type="file" accept="xls,xlsx" id="input-file-practica" name="archivo-xml">
            <button type="submit" class="btn btn-default btn-success btn-block">Cargar lista</button>
        </form>
    </div>
</div>


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
</body>
</html>
