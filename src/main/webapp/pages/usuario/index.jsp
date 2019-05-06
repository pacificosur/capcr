<%-- 
    Document   : index
    Created on : 29/04/2019, 11:55:37 PM
    Author     : LabTW08
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>CAPCR</title>
        <!-- css -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/cubeportfolio/css/cubeportfolio.min.css">
      <!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">-->
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.carousel.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.theme.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/img/lamp.ico" rel="shortcut icon">
        <!-- boxed bg -->
        <link id="bodybg" href="${pageContext.request.contextPath}/resources/bodybg/bg1.css" rel="stylesheet" type="text/css" />
        <!-- template skin -->
        <link id="t-colors" href="${pageContext.request.contextPath}/resources/color/default.css" rel="stylesheet">
        <!-- =======================================================
          Theme Name: Medicio
          Theme URL: https://bootstrapmade.com/medicio-free-bootstrap-theme/
          Author: BootstrapMade
          Author URL: https://bootstrapmade.com
        ======================================================= -->
    </head>
    <body id="page-top" data-spy="scroll" data-target=".navbar-custom">
        <div id="wrapper">
            <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
                <div class="top-area">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-left">Lunes - Viernes, 8am a 7pm </p>
                            </div>
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-right">Llama a +62 008 65 001</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container navigation">
                    <div class="navbar-header page-scroll">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index_.html">
                            <img src="../../resources/img/logo.png" alt="" width="150" height="40" />
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <ul class="nav navbar-nav">
                            <li ><a href="#intro">Alumno</a></li>
                            <li><a href="${pageContext.request.contextPath}/PracticaController?accion=listar">Práctica</a></li>
                            <li><a href="#doctor">Registro</a></li>
                            <li><a href="${pageContext.request.contextPath}/ReservacionController?accion=listar">Reservaciones</a></li>
                            <li class="active"><a href="${pageContext.request.contextPath}/UsuarioController?accion=index">Usuario</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">More <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="index_.html">Home CTA</a></li>
                                    <li><a href="index-form.html">Home Form</a></li>
                                    <li><a href="index-video.html">Home video</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
            <section id="intro" class="intro">
                <div class="intro-content">
                    <div class="container">

                        <br/>
                        <button type="button" class="btn btn-success" id="id-btn-crear-usuario"><i class="fa fa-plus"></i>&nbsp;Crear Usuario</button>
                        <br/>

                        <table id="idTable" class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <td>ID</td>
                                    <td>NOMBRE</td>
                                    <td>APELLIDO</td>
                                    <td>USUARIO</td>
                                    <td>CONTRASEÑA</td>
                                    <td>TIPO</td>
                                    <td colspan=2>ACCIONES</td>
                                </tr>
                            </thead>
                            <c:forEach var="usuario" items="${listaUsuario}">
                                <tr>
                                    <td><c:out value="${usuario.idUsuario}"/></td>
                                    <td><c:out value="${usuario.nombre}"/></td>
                                    <td><c:out value="${usuario.apellidos}"/></td>
                                    <td><c:out value="${usuario.nombreUsuario}"/></td>
                                    <td><c:out value="${usuario.contraseña}"/></td>
                                    <td><c:out value="${usuario.tipo}"/></td>                      	
                                    <td><button type="button" class="btn btn-success class-actualizar-usuario"><i class="fa fa-edit"></i></button> </td>	
                                    <td><a type="button" class="btn btn-success" href="${pageContext.request.contextPath}/UsuarioController?accion=eliminar&idUsuario=<c:out value="${usuario.idUsuario}"/>"><i class="fa fa-trash"></i></a> </td>				                                   
                                </tr>
                            </c:forEach>
                        </table>

                        <!-- Modal -->
                        <div class="modal fade" id="id-modal-usuario" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span></h4>
                                    </div>
                                    <div class="modal-body">
                                        <form action="${pageContext.request.contextPath}/UsuarioController?accion=crear" method="POST" role="form">
                                            
                                            <div class="form-group">
                                                <label for="nombre"><span class="glyphicon glyphicon-user"></span>Nombre</label>
                                                <input type="text" name="idNombre" class="form-control" id="idNombre" placeholder="Ingrese el nombre">
                                            </div>

                                            <div class="form-group">
                                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Apellido</label>
                                                <input type="text" name="idApellidos" class="form-control" id="idApellidos" placeholder="Paterno    Materno">
                                            </div>

                                            <div class="form-group">
                                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Usuario</label>
                                                <input type="text" name="idNombreUsuario" class="form-control" id="idNombreUsuario" placeholder="nuevo usuario">
                                            </div>

                                            <div class="form-group">
                                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Contraseña</label>
                                                <input type="text" name="idContraseña" class="form-control" id="idContraseña" placeholder="Ingrese la contraseña">
                                            </div>
                                            
                                             <div class="form-group">
                                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Confirmar contraseña</label>
                                                <input type="text" name="idContraseña2" class="form-control" id="idContraseña2" placeholder="Confirme su contraseña">
                                            </div>

                                            <div class="form-group">
                                                <label for="psw"><span class="glyphicon glyphicon-eye-open"></span>Tipo</label>
                                                <input type="text" name="idTipo" class="form-control" id="idTipo" placeholder="Ingrese el tipo">
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
                </div>
            </section>
            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Acerca de CAPCR</h5>
                                    <p>
                                        CAPCR es un sistema que registra la asistencia de prácticas de la Clínica Robotizada, también genera los reportes de asistencia de estas. 
                                    </p>
                                </div>
                            </div>
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Información</h5>
                                    <ul>
                                        <li><a href="#">Inicio</a></li>
                                        <li><a href="#">Laboratory</a></li>
                                        <li><a href="#">Medical treatment</a></li>
                                        <li><a href="#">Terms & conditions</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Medicio center</h5>
                                    <p>
                                        Nam leo lorem, tincidunt id risus ut, ornare tincidunt naqunc sit amet.
                                    </p>
                                    <ul>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-calendar-o fa-stack-1x fa-inverse"></i>
                                            </span> Lunes - Viernes, 8 am a 10 pm
                                        </li>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-phone fa-stack-1x fa-inverse"></i>
                                            </span> +62 0888 904 711
                                        </li>
                                        <li>
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
                                            </span> hello@medicio.com
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4">
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Our location</h5>
                                    <p>The Suithouse V303, Kuningan City, Jakarta Indonesia 12940</p>

                                </div>
                            </div>
                            <div class="wow fadeInDown" data-wow-delay="0.1s">
                                <div class="widget">
                                    <h5>Follow us</h5>
                                    <ul class="company-social">
                                        <li class="social-facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
                                        <li class="social-twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li class="social-google"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                        <li class="social-vimeo"><a href="#"><i class="fa fa-vimeo-square"></i></a></li>
                                        <li class="social-dribble"><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sub-footer">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6 col-lg-6">
                                <div class="wow fadeInLeft" data-wow-delay="0.1s">
                                    <div class="text-left">
                                        <p>&copy;Copyright - Medicio Theme. All rights reserved.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-6">
                                <div class="wow fadeInRight" data-wow-delay="0.1s">
                                    <div class="text-right">
                                        <div class="credits">
                                            <!--
                                              All the links in the footer should remain intact. 
                                              You can delete the links only if you purchased the pro version.
                                              Licensing information: https://bootstrapmade.com/license/
                                              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Medicio
                                            -->
                                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
        <!-- Core JavaScript Files -->
        <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery.appear.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/stellar.js"></script>
        <script src="${pageContext.request.contextPath}/resources/plugins/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/nivo-lightbox.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
        <script src="${pageContext.request.contextPath}/resources/Usuario/js/scriptUsuario.js"></script>
    </body>
</html>

