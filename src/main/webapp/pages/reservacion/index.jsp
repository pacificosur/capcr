<%-- 
    Autor: Rolando Pedro Gabriel
    E-mail: rolando.pedro.gabriel@gmail.com
    Fecha Creaci�n: 04/04/2019
    Fecha Modificaci�n: 07/05/2019
    Descripci�n: p�gina principal del m�dulo de Reservaci�n.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    /*Bloque de c�digo que nusca si existe una sesi�n*/
    if (session != null) {
        if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
        } else {
            response.sendRedirect("/capcr/pages/logueo/index.jsp");
        }
    }
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<jsp:include page="../../pages/layouts/header.jsp"></jsp:include>
    <br/>
    <button type="button" class="btn btn-success" id="id-btn-crear-reservacion"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;Crear Registro</button>
    <br/>
    <div class="container-table">
        <table id="idTable" class="table">
            <thead>
                <tr>
                    <th> ID</th>
                    <th> FECHA INICIO</th>
                    <th> FECHA FIN</th>
                    <th>AREA</th>
                    <th>RES. AREA</th>
                    <th>PRACTICA</th>
                    <th>RES. PRACTICA</th>
                    <th colspan=2>ACCIONES</th>
                </tr>
            </thead>
            <tbody id="miTabla">
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
                    <td><button type="button" class="btn btn-danger class-eliminar-reservacion"><i class="fa fa-trash"></i></button> </td>			
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="col-md-12 text-right">
        <ul class="pagination pagination-lg pager" id="myPager"></ul>
    </div>  
</div>


<!-- Modal -->
<div class="modal fade" id="id-modal-reservacion" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img class="img-logo-modal-header" src="${pageContext.request.contextPath}/resources/reservacion/img/logo-modal-header.png" />
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/ReservacionController?accion=crear" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idReservacion" class="form-control" id="idReservacion" >
                    </div>

                    <div class="form-group">
                        <label for="area"><span class="fa fa-building"></span>&nbsp �rea</label>
                        <input type="text" name="area" class="form-control" id="idArea" placeholder="Ingrese el �rea">
                    </div>
                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp Responsable</label>
                        <input type="text" name="responsableArea" class="form-control" id="idAreaResponsable" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese el responsable">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-list"></span>&nbsp Pr�ctica</label>
                        <input type="text" name="practica" class="form-control" id="idPractica" placeholder="Ingrese la pr�ctica">
                    </div>

                    <div class="form-group">
                        <label for="psw"><span class="fa fa-user"></span>&nbsp Responsable Pr�ctica</label>
                        <input type="text" name="responsablePractica" class="form-control" id="idPracticaResponsable" required pattern="^[\w\.\-\s]+$" placeholder="Ingrese el responsable de la pr�ctica">
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success"><span class="fa fa-save"></span>&nbsp Guardar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>          
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>  

<!-- Modal Eliminar -->
<div class="modal fade" id="id-modal-reservacion-eliminar" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header text-center">
                <h1>�Est� seguro de eliminar este registro?</h1>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/ReservacionController?accion=eliminar" method="POST" role="form">
                    <div class="form-group">
                        <input type="hidden" name="idReservacion-eliminar" class="form-control" id="idReservacion-eliminar" >
                    </div>

                    <div class="form-group">
                        <label for="area">�rea:</label>
                        <p id="idArea-eliminar"></p>
                    </div>
                    <div class="form-group">
                        <label for="psw">Responsable</label>
                        <p id="idAreaResponsable-eliminar"></p>                       
                    </div>

                    <div class="form-group">
                        <label for="psw">Pr�ctica</label>
                        <p id="idPractica-eliminar"></p> 
                    </div>

                    <div class="form-group">
                        <label for="psw">Responsable Pr�ctica</label>
                        <p id="idPracticaResponsable-eliminar"></p>                         
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default btn-success"><span class="fa fa-trash"></span>&nbsp Eliminar</button>
                        <button type="submit" class="btn btn-default btn-danger" data-dismiss="modal"><span class="fa fa-close"></span> Cancel</button>  
                    </div>
                </form>
            </div>
        </div>
    </div>
</div> 

<%-- El footer se encuentra en la carperta layouts en la carpeta pages.
el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
--%> 
<jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/resources/reservacion/js/scriptReservacion.js"></script>
</body>
</html>
