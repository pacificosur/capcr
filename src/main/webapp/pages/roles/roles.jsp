<%-- 
    Autor: Jose Benito Gomez Sanchez
    E-mail: josegomz.sa17@gmail.com 
    Fecha Creación: 04/04/2019
    Fecha Modificación: 11/04/2019
    Descripción: página principal del módulo de Asignación de roles.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Asignacion de Roles</title>
        <%-- css --%>
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
        <%-- boxed bg --%>
        <link id="bodybg" href="${pageContext.request.contextPath}/resources/bodybg/bg1.css" rel="stylesheet" type="text/css" />
        <%-- template skin --%>
        <link id="t-colors" href="${pageContext.request.contextPath}/resources/color/default.css" rel="stylesheet">
    </head>
    <body id="page-top" data-spy="scroll" data-target=".navbar-custom">
        <div id="wrapper">
            <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
                <div class="top-area">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-left">Monday - Saturday, 8am to 10pm </p>
                            </div>
                            <div class="col-sm-6 col-md-6">
                                <p class="bold text-right">Call us now +62 008 65 001</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container navigation">
                    <div class="navbar-header page-scroll">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.html">
                            <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="" width="150" height="40" />
                        </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#intro">Home</a></li>
                            <li><a href="#service">Service</a></li>
                            <li><a href="#doctor">Doctors</a></li>
                            <li><a href="#facilities">Facilities</a></li>
                            <li><a href="#pricing">Pricing</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="badge custom-badge red pull-right">Extra</span>More <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="index.html">Home CTA</a></li>
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
                <div class="container" style="padding:200px 0 60px;">
                    <div class="container">
                        <table id="idTable" class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <td> IDUSARIO</td>
                                    <td> NOMBRE</td>
                                    <td> APELLIDOS</td>
                                    <td> NOMBREUSUARIO</td>
                                    <td> CONTRASEÑA</td>
                                    <td colspan=4> ROL</td>
                                </tr>
                            </thead>
                            <c:forEach var="usuario" items="${listaUsuario}">
                            <tr>
                                <td><c:out value="${usuario.idUsuario}"/></td>
                                <td><c:out value="${usuario.nombre}"/></td>
                                <td><c:out value="${usuario.apellidos}"/></td>
                                <td><c:out value="${usuario.nombreUsuario}"/></td>
                                <td><c:out value="${usuario.contraseña}"/></td>
                                <td>
                                    <div class="dropdown">
                                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                            Roles
                                        </button>
                                        <div class="dropdown-menu">
                                            
                                        </div>
                                    </div>
                                </td>   		
                            </tr>
                            </c:forEach>
                            
                        </table>
                        
                        <p>hola</p>
                        <c:forEach var="rol" items="${listaRol}">
                            <p><c:out value="${rol.nombre}"/></p>
                        </c:forEach>
                    </div>
                </div>
            </section>       
                         
            <footer>

                <div class="container">
        <div class="row">
          <div class="col-sm-6 col-md-4">
            <div class="wow fadeInDown" data-wow-delay="0.1s">
              <div class="widget">
                <h5>About Medicio</h5>
                <p>
                  Lorem ipsum dolor sit amet, ne nam purto nihil impetus, an facilisi accommodare sea
                </p>
              </div>
            </div>
            <div class="wow fadeInDown" data-wow-delay="0.1s">
              <div class="widget">
                <h5>Information</h5>
                <ul>
                  <li><a href="#">Home</a></li>
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
								</span> Monday - Saturday, 8am to 10pm
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
    </body>
</html>
