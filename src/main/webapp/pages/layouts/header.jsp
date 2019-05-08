<%-- 
   Autores: Padilla Bustamante Uriel Gustavo
   E-mail: padilla98.upb@gmail.com  
   Fecha Creación: 02/05/2019
   Fecha Modificación: 02/05/2019
   Descripción: header plantilla
--%>
<!DOCTYPE html>
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
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/nivo-lightbox-theme/default/default.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.carousel.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/owl.theme.css" rel="stylesheet" media="screen" />
        <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/resources/img/lamp.ico" rel="shortcut icon">

        <link href="${pageContext.request.contextPath}/resources/reservacion/css/cssReservacion.css" rel="stylesheet" />



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
                        <a class="navbar-brand" href="index.jsp">
                            <img src="${pageContext.request.contextPath}/resources/img/lamp.png" alt="" width="150" height="40" />
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="#intro">Alumno</a></li>
                            <li><a href="${pageContext.request.contextPath}/PracticaController?accion=index">Práctica</a></li>
                            <li><a href="${pageContext.request.contextPath}/RegistroController?accion=index">Registro</a></li>
                            <li><a href="${pageContext.request.contextPath}/ReservacionController?accion=index">Reservaciones</a></li>
                            <li><a href="${pageContext.request.contextPath}/UsuarioController?accion=index">Usuario</a></li>
                            <li><a href="${pageContext.request.contextPath}/RolesController?accion=index">Asignar Roles</a></li>
                            <li><a href="${pageContext.request.contextPath}/pages/logueo/index.jsp">Logout</a></li><!-- Función para desloguearse-->
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>

            <!-- Section: intro -->
            <section id="intro" class="intro">
                <div class="intro-content">
                    <div class="container">