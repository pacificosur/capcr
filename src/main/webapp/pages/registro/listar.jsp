<%-- 
    Document   : listar
    Created on : 24/04/2019, 03:23:51 PM
    Author     : LabTW13
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/PracticaController?accion=listar">Practica</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/RegistroController?accion=listar">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/ReservacionController?accion=listar">Reservaciones</a>
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
                        <td> CODIGO PRACTICA</td>
                        <td> MATRICULA ALUMNO</td>
                        <td> HORA ENTRADA</td>
                        <td> HORA SALIDA</td>
                        <td> FECHA</td>
                        <td> SUSTITUYE</td>
                        <td> COMENTARIO</td>
                        <td colspan=2>ACCIONES</td>
                    </tr>
                </thead>
                <c:forEach var="registro" items="${listaRegistro}">
                    <tr>
                        <td><c:out value="${registro.codigoPractica}"/></td>
                        <td><c:out value="${registro.matriculaAlumno}"/></td>
                        <td><c:out value="${registro.horaEntrada}"/></td>
                        <td><c:out value="${registro.horaSalida}"/></td>
                        <td><c:out value="${registro.fecha}"/></td>
                        <td><c:out value="${registro.sustituye}"/></td>
                        <td><c:out value="${registro.comentario}"/></td>
                        <td><button type="button" class="btn btn-success class-actualizar-registro"><i class="fa fa-edit"></i></button> </td>	
                        <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/RegistroController?accion=eliminar&idRegistro=<c:out value="${registro.codigoPractica}"/>"><i class="fa fa-trash"></i></a> </td>				
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!-- Modal -->
    </body>
</html>
