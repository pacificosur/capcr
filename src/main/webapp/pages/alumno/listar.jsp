<%-- 
    Document   : listar
    Created on : 10/04/2019, 06:54:30 PM
    Author     : LabTW03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LISTAR ALUMNO</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/scriptReservacion.js"></script>
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
            <button type="button" class="btn btn-success" id="id-btn-crear-alumno"><i class="fa fa-plus"></i>&nbsp;Crear Alumno</button>
            <br/>

            <table id="idTable" class="table">
                <thead class="thead-dark">
                    <tr>
                        <td>MATRICULA</td>
                        <td>NOMBRE</td>
                        <td>GRUPO</td>
                        <td>CODIGO SEMESTRE</td>
                        <td>CODIGO CARRERA</td>
                    </tr>
                </thead>
                <c:forEach var="alumnos" items="${listaAlumnos}">
                    <tr>
                        <td><c:out value="${alumno.setMatricula}"/></td>
                        <td><c:out value="${alumno.setNombre}"/></td>
                        <td><c:out value="${alumno.setGrupo}"/></td>
                        <td><c:out value="${alumno.setCodigoSemestre}"/></td>
                        <td><c:out value="${alumno.setCodigoCarrera}"/></td>
                        <td><button type="button" class="btn btn-success class-actualizar-alumno"><i class="fa fa-edit"></i></button> </td>	
                        <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/AlumnosController?accion=eliminar&matricula=<c:out value="${alumno.matricula}"/>"><i class="fa fa-trash"></i></a> </td>				
                    </tr>
                </c:forEach>
            </table>
                    
            <!-- Modal -->
            <div class="modal fade" id="id-modal-alumno" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 style="color:blue;"><span class="glyphicon glyphicon-lock"></span></h4>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/AlumnosController?accion=crear" method="POST" role="form">
                                <div class="form-group">
                                    <input type="hidden" name="matricula" class="form-control" id="matricula" >
                                </div>

                                <div class="form-group">
                                    <label for="matricula"><span class="glyphicon glyphicon-user"></span>Matricula</label>
                                    <input type="text" name="matricula" class="form-control" id="matricula" placeholder="Ingrese la matricula del alumno">
                                </div>
                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Nombre</label>
                                    <input type="text" name="nombre" class="form-control" id="nombre" placeholder="Ingrese el nombre del alumno">
                                </div>

                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Grupo</label>
                                    <input type="text" name="grupo" class="form-control" id="grupo" placeholder="Ingrese el grupo del alumno">
                                </div>

                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Semestre</label>
                                    <input type="text" name="semestre" class="form-control" id="semestre" placeholder="Ingrese el semestre del alumno">
                                </div>
                                
                                <div class="form-group">
                                    <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Carrera</label>
                                    <input type="text" name="carrera" class="form-control" id="semestre" placeholder="Ingrese la carrera del alumno">
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
