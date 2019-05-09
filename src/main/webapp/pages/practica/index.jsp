<%-- 
    Autores: Padilla Bustamante Uriel Gustavo
             Castro Cisneros Hiralda
    E-mail: padilla98.upb@gmail.com  
            hiraldac.cisneros@gmail.com
    Fecha Creaci�n: 10/04/2019
    Fecha Modificaci�n: 03/05/2019
    Descripci�n: p�gina principal del m�dulo de Practica.
--%>
<%@ page language="java" contentType="text/html"
         %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-practica"><i class="fa fa-plus"></i>&nbsp;Crear Practica</button>
    <br/>

    <div class="table-responsive">
        <table id="idTable" class="table table-hover" style="width:100%">
        <thead class="thead-dark">
            <tr>
                <th>C�digo</th>
                <th>Nombre</th>
                <th>Id Semestre</th>
                <th>Id Carrera</th>
                <th>Fecha creaci�n</th>
                <th>Fecha Actualizaci�n</th>
                <th>Fecha Eliminaci�n</th>
                <th colspan=2>ACCIONES</th>
            </tr>
        </thead>
        <tbody id="miTabla">
    <c:forEach var="practica" items="${listaPractica}">
        <tr>
            <td><c:out value="${practica.codigo}"/></td>
            <td><c:out value="${practica.nombre}"/></td>
            <td><c:out value="${practica.idSemestre}"/></td>
            <td><c:out value="${practica.idCarrera}"/></td>
            <td><c:out value="${practica.fechaCreacion}"/></td>
            <td><c:out value="${practica.fechaActualizacion}"/></td>
            <td><c:out value="${practica.fechaEliminacion}"/></td>
            <td><button type="button" class="btn btn-success class-actualizar-practica"><i class="fa fa-edit"></i></button> </td>	
            <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/PracticaController?accion=eliminar&codigoPractica=<c:out value="${practica.codigo}"/>"><i class="fa fa-trash"></i></a> </td>				
        </tr>
    </c:forEach>
        </tbody>
</table>
 </div>
 <div class="col-md-12 text-center">
    <ul class="pagination pagination-lg pager" id="myPager"></ul>
</div>

<!-- Modal -->
<div class="modal fade" id="id-modal-practica" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center" >
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/practica/img/logo-modal-header.png" />
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/PracticaController?accion=crear" method="POST" role="form" id="formulario">
                    <div class="form-group">
                        <input id="crearPractica" type="hidden" name="crearPractica" class="form-control">
                    </div>

                    <div class="form-group"  id="grupoCodigoPractica">
                        <label for="codigoPractica"><span class="glyphicon glyphicon-user"></span>Codigo</label>
                        <input type="text" name="codigoPractica" class="form-control" id="codigoPractica" placeholder="Ingrese el codigo" required pattern="[0-9]{4}" required>
                    </div>
                    <div class="form-group">
                        <label for="nombrePractica"><span class="glyphicon glyphicon-user"></span>Nombre</label>
                        <input type="text" name="nombrePractica" class="form-control" id="nombrePractica" placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="idSemestrePractica"><span class="glyphicon glyphicon-eye-open"></span>Semestre</label>
                        <input type="text" name="idSemestrePractica" class="form-control" id="idSemestrePractica" placeholder="Ingrese el codigo del semestre" required pattern="[0-9]{2}" required>
                    </div>
                    <div class="form-group">
                        <label for="idCarreraPractica"><span class="glyphicon glyphicon-eye-open"></span>Carrera</label>
                        <input type="text" name="idCarreraPractica" class="form-control" id="idCarreraPractica" placeholder="Ingrese el codigo de carrera" required pattern="[0-9]{2}" required>
                    </div>

                    <button id="guardarPractica" type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Guardar</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-default btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>          
            </div>
        </div>
    </div>
</div>  <!-- Modal -->

<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
      el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
        --%> 
        <jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/practica/js/scriptPractica.js"></script>
</body>
</html>