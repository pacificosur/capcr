<%-- 
    Document   : reporte
    Created on : 16/06/2019, 02:48:53 PM
    Author     : Uriel
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="java.time.LocalDate"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            ConnectionPostgreSQL con = new ConnectionPostgreSQL();
            Connection conn = con.conecta();
            System.out.println("Entró al JSP");
            String path = application.getRealPath("reportesPracticas.jasper");
            Map parametros = new HashMap();
            String grupo = request.getParameter("idGrupo");
            String practica = request.getParameter("idNombrePractica");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = request.getParameter("idFechaInicio");
            String fecha2 = request.getParameter("idFechaFin");
            System.out.println("La fecha1 es "+fecha);
            System.out.println("La fecha2 es "+fecha2);
            System.out.println("Grupo "+ grupo);
            System.out.println("Practica"+practica);
            Date fechaInicio = formato.parse(request.getParameter("idFechaInicio"));
            Date fechaFin = formato.parse(request.getParameter("idFechaFin"));
            System.out.println("La fecha es:"+fechaInicio);
            System.out.println("Lafecha es"+fechaFin);
            
          
            parametros.put("varNombre_practica",practica);
            parametros.put("varGrupo",grupo);
            parametros.put("varFecha_inicio",fechaInicio);
            parametros.put("varFecha_fin", fechaFin);
           
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); // para cargar el reporte 
            byte[] bytes = JasperRunManager.runReportToPdf(reporte,parametros,conn);
            response.setContentType("application/pdf");
            String archivo = practica+ "_" +grupo+ ".pdf";
            response.addHeader("Content-disposition", "attachment; filename=" + archivo);
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
            System.out.println("Terminó el JSP");
            out.println("<h1>Reporte Generado</h1>");
  
           
        %>
    </body>
</html>