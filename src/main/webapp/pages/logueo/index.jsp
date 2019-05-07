<%-- 
    Document   : JSP Logueo
    Created on : 2/05/2019, 02:10:49 PM
    Author     : Pedro Eliezer García Ramírez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAPCR</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/img/lamp.ico" rel="shortcut icon">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/logueo/css/estilo1.css">
    </head>
    <body>
        <div class="container">
            <div class="container mt-5 pt-5">
                <div class="card mx-auto border-0">
                    <div class="card-header border-bottom-0 bg-transparent">
                      <ul class="nav nav-tabs justify-content-center pt-4" id="pills-tab" role="tablist">
                        <li class="nav-item">
                          <a class="nav-link active text-primary" id="pills-login-tab" data-toggle="pill" href="#pills-login" role="tab" aria-controls="pills-login"
                             aria-selected="true">Login</a>
                        </li>
                      </ul>
                    </div>
                    <div class="card-body pb-4">
                        <div class="tab-content" id="pills-tabContent">
                            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="pills-login-tab">
                                <form action="${pageContext.request.contextPath}/LogueoController" method="GET">
                                <div class="form-group">
                                  <input onkeypress="return soloLetras(event)" type="text" name="user" class="form-control" id="user" placeholder="Usuario" required autofocus>
                                </div>
                                <div class="form-group">
                                  <input onkeypress="return soloLetras(event)" type="password" name="password" class="form-control" id="password" id="Contraseña" placeholder="Contraseña" required>
                                </div>
                                <div class="text-center">
                                    <button type="submit" name="boton" class="btn btn-primary  btn-block">Iniciar</button>
                                </div>                               
                                <div class="text-center pt-2">
                                    <a href="/capcr/pages/index.jsp">Haz olvidado la contraseña</a>
                                </div>
                              </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function soloLetras(e){
               key = e.keyCode || e.which;
               tecla = String.fromCharCode(key).toLowerCase();
               letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
               especiales = "8-37-39-46";

               tecla_especial = false
               for(var i in especiales){
                    if(key == especiales[i]){
                        tecla_especial = true;
                        break;
                    }
                }

                if(letras.indexOf(tecla)==-1 && !tecla_especial){
                    return false;
                }
            }
        </script>
    </body>
</html>
