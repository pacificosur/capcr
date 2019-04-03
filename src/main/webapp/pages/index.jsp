<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto UNSIS Clínica</title>
    </head>
    <body>
        <h1>Proyecto UNSIS Clínica</h1>
        
        <form action="index.jsp" method="GET">
            <p>
                Numero: <input type="text" name="numero">
                <input type="submit" name="Enviar">
            </p>
        </form>
        
        
        <% 
            int numero = Integer.parseInt(request.getParameter("numero"));
            
            Long factorial = new Long(1);
            
            if(numero >= 0){
                for(int i = 1; i <= numero; i++){
                    factorial *= i;
                }
                out.println("<p>El esultado de " + numero + "! = " + factorial + "</p>");
            }else{
                out.println("<p>Ingrese un valor mayor igual a cero</p>");
            }
        %>
    </body>
</html>
