<%-- 
    Document   : index
    Created on : 29/04/2019, 11:55:37 PM
    Author     : LabTW08
--%>
<%--El header se encuentra en la carpeta layouts en la carpeta pages
    El header incluye desde la etiqueta <!DOCTYPE html> hasta el segundo div dentro de Section: intro--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../pages/layouts/header.jsp"></jsp:include>
    <div class="row">
        <div class="col-lg-6">
            <div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.1s">
                <h2 class="h-ultra">CAPCR</h2>
            </div>
            <div class="wow fadeInUp" data-wow-offset="0" data-wow-delay="0.1s">
                <h4 class="h-light">Control de Acceso a Prácticas de la Clínica Robotizada</h4>
            </div>
            <div class="well well-trans">
                <div class="wow fadeInRight" data-wow-delay="0.1s">

                    <ul class="lead-list">
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Modifica tu Información</strong><br />Cambia tus datos de usuario. </span></li>
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Registro  de asistencias en menos tiempo.</strong><br />Registra las asistencias de forma rápida y sencilla.</span></li>
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Recuperación de registros.</strong><br />Recupera la información de asistencias con sólo un click.</span></li>
                    </ul>
                    <p class="text-right wow bounceIn" data-wow-delay="0.4s">
                        <a href="#boxes" class="btn btn-skin btn-lg">Leer más <i class="fa fa-angle-right"></i></a>
                    </p>
                </div>
            </div>


        </div>
        <div class="col-lg-6">
       
        </div>
    </div>
</div>
</div>
</section>

<!-- /Section: intro -->

<!-- Section: boxes -->
<section id="boxes" class="home-section paddingtop-80">

    <div class="container">
        <div class="row">
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">

                        <i class="fa fa-check fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Clínica Robotizada</h4>
                        <p>
                             Integrada por instalaciones y equipo de lo más apegados a la realidad.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">

                        <i class="fa fa-list-alt fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Hacer una reservación</h4>
                        <p>
                           Haz una reservación de una área de la Clínica Robotizada.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">
                        <i class="fa fa-user-md fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Personal Autorizado</h4>
                        <p>
                            El uso de este sistema va dirigido a los técnicos encargados de la Clínica Robotizada y personal autorizado por el administrador de CAPCR.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">

                        <i class="fa fa-hospital-o fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">CAPCR genera reportes</h4>
                        <p>
                            Además de registrar las asistencias a prácticas en la Clínica Robotizada, CAPCR genera reportes de asistencias.
                        </p>
                    </div>
                </div>
            </div>
        <%-- El footer se encuentra en la carperta layouts en la carpeta pages.
      el footer incluye dos div arriba de section y incluye todo (el footer y los archivos JavaScript) antes de donde cierra la etiqueta body
        --%> 
        <jsp:include page="../pages/layouts/footer.jsp"></jsp:include>
        </body>

        </html>

