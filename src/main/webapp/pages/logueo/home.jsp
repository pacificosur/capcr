<%-- 
    Document   : home
    Created on : 2/05/2019, 02:10:49 PM
    Author     : LabTW03
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logueo</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                    </div>
                </div>
            </div>
        </div>
        </div>

       
  </body>
</html>
