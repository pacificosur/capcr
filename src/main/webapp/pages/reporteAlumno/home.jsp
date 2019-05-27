<%-- 
  Autor: García Ramírez Pedro Eliezer
  E-mail: pg548169@gmail.com  
  Fecha Creación: 23/04/2019
  Fecha Modificación: -/-/-
--%>
<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
			} else {
				response.sendRedirect("/capcr/pages/logueo/index.jsp");
			}
		}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/fontawesome/4.7.0/css/font-awesome.min.css">
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.0.0/jquery.min.js"></script>
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
                            <a class="nav-link" href="#">Práctica por alumno</i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Practica por grupo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Acerca de...</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown link
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="drtem" href="#">Another action</a>
                                <a class="dropdown-itemopdown-item" href="#">Action</a>
                                <a class="dropdown-i" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>                
            </nav>

    </body>
</html>
