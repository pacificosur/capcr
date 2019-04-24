<%-- 
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 24/04/2019
  Fecha Modificación: -/-/-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logueo</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
        <style>
            body {
                    background: url('http://www.unsis.edu.mx/images/iisp2.JPG') no-repeat center center fixed;
                    -webkit-background-size: cover;
                    -moz-background-size: cover;
                    -o-background-size: cover;
                    background-size: cover;
                }

                .card {
                  width: 300px;
                }

                .nav-item .nav-link[disabled]:hover {

                }
        </style>
    </head>
    <body>
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
                          <form>
                            <div class="form-group">
                              <input type="text" name="user" class="form-control" id="user" placeholder="Usuario" required autofocus>
                            </div>

                            <div class="form-group">
                              <input type="password" name="password" class="form-control" id="password" id="Contraseña" placeholder="Password" required>
                            </div>

                            <div class="text-center pt-4">
                              <button type="submit" class="btn btn-primary">Iniciar</button>
                            </div>
                          </form>
                        </div>
                        <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="pills-register-tab">
                          <form>
                            <div class="form-group">
                              <input type="text" name="username" id="name" class="form-control" placeholder="Username" required autofocus>
                            </div>

                            <div class="form-group">
                              <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
                            </div>
                            <div class="form-group">
                              <input type="password" name="password_confirmation" id="password-confirm" class="form-control" placeholder="Confirm password" required>
                            </div>
                          </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
  </body>
</html>
