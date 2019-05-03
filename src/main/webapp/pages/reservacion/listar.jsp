<%-- 
    Autor: Rolando Pedro Gabriel
    E-mail: rolando.pedro.gabriel@gmail.com
    Fecha Creación: 04/04/2019
    Fecha Modificación: 03/05/2019
    Descripción: página principal del módulo de Reservación.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>

    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-reservacion"><i class="fa fa-plus"></i>&nbsp;Crear Registro</button>
    <br/>

    <table id="idTable" class="table">
        <thead class="thead-dark">
            <tr>
                <td> ID</td>
                <td> FECHA INICIO</td>
                <td> FECHA FIN</td>
                <td>AREA</td>
                <td>RES. AREA</td>
                <td>PRACTICA</td>
                <td>RES. PRACTICA</td>
                <td colspan=2>ACCIONES</td>
            </tr>
        </thead>
    <c:forEach var="reservacion" items="${listaReservacion}">
        <tr>
            <td><c:out value="${reservacion.idReservacion}"/></td>
            <td><c:out value="${reservacion.fechaInicio}"/></td>
            <td><c:out value="${reservacion.fechaFin}"/></td>
            <td><c:out value="${reservacion.area}"/></td>
            <td><c:out value="${reservacion.responsableArea}"/></td>
            <td><c:out value="${reservacion.practica}"/></td>
            <td><c:out value="${reservacion.responsablePractica}"/></td>
            <td><button type="button" class="btn btn-success class-actualizar-reservacion"><i class="fa fa-edit"></i></button> </td>
               <td><a type="button" class="btn btn-danger" href="${pageContext.request.contextPath}/ReservacionController?accion=eliminar&idReservacion=<c:out value="${reservacion.idReservacion}"/>"><i class="fa fa-trash"></i></a> </td>			
        </tr>
    </c:forEach>
</table>

<!-- Modal -->
<div class="modal fade" id="id-modal-reservacion" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img style="height: 90px; width: 90px; border-radius: 50px; margin-top: -50px; " src="${pageContext.request.contextPath}/pages/reservacion/img/descarga.png" />
<!--                <h4 style="color: forestgreen; text-align: center"><span class="fa fa-lock"></span>&nbsp Usuario</h4>-->
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/ReservacionController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idReservacion" class="form-control" id="idReservacion" >
                    </div>

                    <div class="form-group">
                        <label for="area"><span class="fa fa-building"></span>&nbsp Área</label>
                        <input type="text" name="area" class="form-control" id="idArea" placeholder="Ingrese el área">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp Responsable</label>
                        <input type="text" name="responsableArea" class="form-control" id="idAreaResponsable" placeholder="Ingrese el responsable">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-list"></span>&nbsp Práctica</label>
                        <input type="text" name="practica" class="form-control" id="idPractica" placeholder="Ingrese la práctica">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp Responsable Práctica</label>
                        <input type="text" name="responsablePractica" class="form-control" id="idPracticaResponsable" placeholder="Ingrese el responsable de la práctica">
                    </div>

                    <button type="submit" class="btn btn-default btn-success btn-block"><span class="fa fa-save"></span>&nbsp Guardar</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default btn-danger btn-block" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>          
            </div>
        </div>
    </div>
</div>  


<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>

    <script src="${pageContext.request.contextPath}/resources/js/scriptReservacion.js"></script>
</body>
</html>
