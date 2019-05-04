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
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Affordable monthly premium packages</strong><br />Lorem ipsum dolor sit amet, in verterem persecuti vix, sit te meis</span></li>
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Choose your favourite doctor</strong><br />Lorem ipsum dolor sit amet, in verterem persecuti vix, sit te meis</span></li>
                        <li><span class="fa fa-check fa-2x icon-success"></span> <span class="list"><strong>Only use friendly environment</strong><br />Lorem ipsum dolor sit amet, in verterem persecuti vix, sit te meis</span></li>
                    </ul>
                    <p class="text-right wow bounceIn" data-wow-delay="0.4s">
                        <a href="#" class="btn btn-skin btn-lg">Learn more <i class="fa fa-angle-right"></i></a>
                    </p>
                </div>
            </div>


        </div>
        <div class="col-lg-6">
            <div class="wow fadeInUp" data-wow-duration="2s" data-wow-delay="0.2s">
                <img src="../resources/img/clinica.jpg" class="img-responsive" alt="" />
            </div>
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
                        <h4 class="h-bold">Make an appoinment</h4>
                        <p>
                            Lorem ipsum dolor sit amet, nec te mollis utroque honestatis, ut utamur molestiae vix, graecis eligendi ne.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">

                        <i class="fa fa-list-alt fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Choose your package</h4>
                        <p>
                            Lorem ipsum dolor sit amet, nec te mollis utroque honestatis, ut utamur molestiae vix, graecis eligendi ne.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">
                        <i class="fa fa-user-md fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Help by specialist</h4>
                        <p>
                            Lorem ipsum dolor sit amet, nec te mollis utroque honestatis, ut utamur molestiae vix, graecis eligendi ne.
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-md-3">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <div class="box text-center">

                        <i class="fa fa-hospital-o fa-3x circled bg-skin"></i>
                        <h4 class="h-bold">Get diagnostic report</h4>
                        <p>
                            Lorem ipsum dolor sit amet, nec te mollis utroque honestatis, ut utamur molestiae vix, graecis eligendi ne.
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

