<%-- 
    Autor: Jose Benito Gomez Sanchez
    E-mail: josegomz.sa17@gmail.com 
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: carga listas de excel y los manda a la base de datos--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- se añade la cabecera  --%>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cargar listas</title>
        <!-- css -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/cubeportfolio/css/cubeportfolio.min.css">
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.carousel.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.theme.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/img/lamp.ico" rel="shortcut icon">
        <link href="${pageContext.request.contextPath}/resources/alumno/css/cssAlumno.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/reservacion/css/cssReservacion.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/practica/css/cssPractica.css" rel="stylesheet" />
        <style>
            input{
                background: rgba(0,0,0,0);
                border:none;
            }

        </style>
        <!-- boxed bg -->
        <link id="bodybg" href="${pageContext.request.contextPath}/resources/bodybg/bg1.css" rel="stylesheet" type="text/css" />
        <!-- template skin -->
        <link id="t-colors" href="${pageContext.request.contextPath}/resources/color/default.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/css/myStyle.css" rel="stylesheet" />
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-custom" ng-controller="MyController">


        <div id="wrapper">

            <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
                <div class="top-area">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-left">Lunes - Viernes, 8 am a 7 pm </p>
                            </div>
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-right">01 (951) 57 2 41 00 Extensión 1202
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container navigation">

                    <div class="navbar-header page-scroll">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/pages/index.jsp">
                            <img src="${pageContext.request.contextPath}/resources/img/Logo_1.png" alt="" width="150" height="40" />
                        </a>
                    </div>

                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <ul class="nav navbar-nav">
                            <li><a id="link-roles" href="${pageContext.request.contextPath}/pages/cargarlista/index.jsp">Cargar lista</a></li>
                            <li><a id="link-alumno" href="${pageContext.request.contextPath}/AlumnosController?accion=index">Alumno</a></li>
                            <li><a id="link-practica" href="${pageContext.request.contextPath}/PracticaController?accion=index">Práctica</a></li>
                            <li><a id="link-registro" href="${pageContext.request.contextPath}/RegistroController?accion=index">Registro</a></li>
                            <li><a id="link-reservacion" href="${pageContext.request.contextPath}/ReservacionController?accion=index">Reservaciones</a></li>
                            <li><a id="link-reporte" href="${pageContext.request.contextPath}/ReporteController?accion=index">Reportes</a></li>
                            <li><a id="link-usuario" href="${pageContext.request.contextPath}/UsuarioController?accion=index">Usuario</a></li>
                            <li><a id="link-roles" href="${pageContext.request.contextPath}/RolesController?accion=index">Asignar Roles</a></li>
                            <li><a href="${pageContext.request.contextPath}/LogoutController">salir</a></li>

                        </ul>
                    </div>

                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>

            <!-- Section: intro -->
            <section id="intro" class="intro">
                <div class="intro-content">
                    <div class="container"></div>
                    <%-- cuerpo de la pagina --%>
                    <div class="col-md-12 text-center" id="botones-cargar">
                        <button type="button" class="btn btn-success" id="cargar-lista-alumno">&nbsp;Alumno</button>
                        <button type="button" class="btn btn-success" id="cargar-lista-practica">&nbsp;Practica</button>
                    </div>

                    <!-- ventana con la tabla para cargar la lista de alumnos -->
                    <div class="cargar-alumnos" style="display:none;">
                        <div class="container-table">
                            <div>
                                <form enctype="multipart/form-data">
                                    <input type="file" id="file">
                                    <button id="btn-cargar-alumno" class="btn btn-default btn-success" type="submit" ng-click="uploadExcel()">cargar datos</button>
                                </form>
                            </div>
                            <div>
                                <form action="${pageContext.request.contextPath}/CargarListasController?accion=cargar-alumnos" method="POST" id="listaAlumnos">
                                    <input id="numAlumnos" type="text" name="nAlumnos" style="display:none;">
                                    <div class="table-responsive">
                                        <table id="myTable" class="table">
                                            <thead>
                                                <tr>
                                                    <th>Matricula</th>
                                                    <th>Nombre</th>
                                                    <th>Grupo</th>
                                                    <th>Semestre</th>
                                                    <th>Carrera</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
                                    </div>
                                    <button type="submit" class="btn btn-default btn-success  marginbot-20 margintop-20" >Cargar lista</button>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="cargar-practicas" style="display:none;">
                        <div class="container-table">
                            <div>
                                <form enctype="multipart/form-data">
                                    <input type="file" id="file2">
                                    <button id="btn-cargar-practica" class="btn btn-default btn-success" type="submit" ng-click="uploadExcel2()">cargar datos</button>
                                </form>
                            </div>
                            <div>
                                <form action="${pageContext.request.contextPath}/CargarListasController?accion=cargar-practicas" method="POST" id="listaAlumnos">
                                     <input id="numPracticas" type="text" name="nPracticas" style="display:none;">
                                    <div class="table-responsive">
                                        <table id="myTable2" class="table">
                                            <thead>
                                                <tr>
                                                    <th>Código</th>
                                                    <th>Nombre</th>
                                                    <th>Semestre</th>
                                                    <th>Carrera</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
                                    </div>
                                    <button type="submit" class="btn btn-default btn-success marginbot-20 margintop-20" >Cargar lista</button>
                                </form>
                            </div>
                        </div>
                    </div>


                    <jsp:include page="../../pages/layouts/footer.jsp"></jsp:include>
                    <script src="${pageContext.request.contextPath}/resources/cargarlista/js/scriptListas.js"></script>
                    <script src="${pageContext.request.contextPath}/resources/cargarlista/js/angular.min.js" type="text/javascript"></script>
                    <script src="${pageContext.request.contextPath}/resources/cargarlista/js/xlsx.full.min.js" type="text/javascript"></script>
                    <script src="${pageContext.request.contextPath}/resources/cargarlista/js/customjs.js" type="text/javascript"></script>

                    </body>
                    </html>
