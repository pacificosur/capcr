<%-- 
    Autor: Rolando Pedro Gabriel
    E-mail: rolando.pedro.gabriel@gmail.com
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: página principal del módulo de Reservación.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>CLINICA - RESERVACIONES</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>

        <script src="${pageContext.request.contextPath}/resources/js/scriptReservacion.js"></script>
    </head>
    <body>
        <!-- Web Application Context Path = ${pageContext.request.contextPath} !-->
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
                <a class="navbar-brand" href="#"><i class="fa fa-home"></i>Clínica</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Alumno</i><span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Practica</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/ReservacionController?accion=home">Reservaciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Acerca de...</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown link
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>                
            </nav>

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
                        <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/ReservacionController?accion=eliminar&idReservacion=<c:out value="${reservacion.idReservacion}"/>"><i class="fa fa-trash"></i></a> </td>				
                    </tr>
                </c:forEach>
            </table>

            <!-- Modal -->
            <div class="modal fade" id="id-modal-reservacion" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span></h4>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/ReservacionController?accion=crear" method="POST" role="form">
                                <div class="form-group">
                                    <input type="hidden" name="idReservacion" class="form-control" id="idReservacion" >
                                </div>

                                <div class="form-group">
                                    <label for="area"><span class="glyphicon glyphicon-user"></span>Area</label>
                                    <input type="text" name="area" class="form-control" id="idArea" placeholder="Ingrese el area">
                                </div>
                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Responsable</label>
                                    <input type="text" name="responsableArea" class="form-control" id="idAreaResponsable" placeholder="Ingrese el responsable">
                                </div>

                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Practica</label>
                                    <input type="text" name="practica" class="form-control" id="idPractica" placeholder="Ingrese la practica">
                                </div>

                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Responsable Practica</label>
                                    <input type="text" name="responsablePractica" class="form-control" id="idPracticaResponsable" placeholder="Ingrese el responsable de la practica">
                                </div>

                                <button type="submit" class="btn btn-default btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Guardar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default btn-default btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>          
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
