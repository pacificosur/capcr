<%-- 
    Document   : reporte
    Created on : 16/06/2019, 02:48:53 PM
    Author     : Uriel
--%>

<%@page import="net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.unsis.capcr.db.ConnectionPostgreSQL"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reporte Generado</h1>
        <%
            ConnectionPostgreSQL con = new ConnectionPostgreSQL();
            Connection conn = con.conecta();
            String path = application.getRealPath("reportesPracticas.jasper");
            Map parametros = new HashMap();
            String grupo = request.getParameter("grupo");
            String practica = request.getParameter("practica");
            Date fechaInicio = null;
            Date fechaFin = null;
         
            parametros.put("varNombre_practica",practica);
            parametros.put("varGrupo",grupo);
            parametros.put("varFecha_inicio",Date.valueOf(LocalDate.of(2019,2,18)));
            parametros.put("varFecha_fin", Date.valueOf(LocalDate.of(2019,5,18)));
           
            JasperReport reporte = null;
        
       
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); // para cargar el reporte 
            byte[] bytes = JasperRunManager.runReportToPdf(reporte,parametros,conn);
            response.setContentType("application/reporte");
            String archivo = practica+ "_" +grupo+ ".pdf";
            response.addHeader("Content-disposition", "attachment; filename=" + archivo);
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
  
           
        %>
    </body>
</html>