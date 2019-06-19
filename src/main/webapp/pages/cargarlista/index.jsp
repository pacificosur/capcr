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
        <div class="fileUpload btn btn--browse">
            <span>Seleccionar archivo</span>
            <input id="uploadBtnAlumno" type="file" class="upload" accept=".xls, .xlsx" />
        </div>
        <input type="file">
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
        <button type="button" class="btn btn-success marginbot-10 margintop-10" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
    </div>
</div>

<div class="cargar-practicas" style="display:none;">
    <div class="container-table">
        <div class="fileUpload btn btn--browse">
            <span>Seleccionar archivo</span>
            <input id="uploadBtnPractica" type="file" class="upload" accept=".xls, .xlsx" />
        </div>
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
        <button type="button" class="btn btn-success marginbot-10 margintop-10" id="cargar-lista-alumno">&nbsp;Cargar lista</button>
    </div>
</div>


<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.7.7/xlsx.core.min.js"></script>  
<script src="https://cdnjs.cloudflare.com/ajax/libs/xls/0.7.4-a/xls.core.min.js"></script> 


<script>
document.getElementById("uploadBtnAlumno").onchange = function () {
    //document.getElementById("uploadFile").value = this.value;
    alert("archivo que contiene la lista de alumnos es: "+this.value);
};

document.getElementById("uploadBtnPractica").onchange = function () {
    //document.getElementById("uploadFile").value = this.value;
    alert("archivo que contiene la lista de practicas es: "+this.value);
};

</script>

</body>
</html>
