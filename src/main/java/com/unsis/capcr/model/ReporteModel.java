/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Uriel
 */
public class ReporteModel implements IReporteModel{

    @Override
    public byte[] generarReporte(String grupo, String practicaNombre, Date fechaInicio, Date fechaFin) {
     
        ConnectionPostgreSQL con = new ConnectionPostgreSQL();
        Connection conn = con.conecta();
        byte[] pdfBytes = null;
       
        String path = "src\\main\\java\\com\\unsis\\capcr\\reportes\\reportesPracticas.jasper";
        Map parametros = new HashMap();
        parametros.put("varGrupo",grupo);
        parametros.put("varFecha_inicio",fechaInicio);
        parametros.put("varFecha_fin", fechaFin);
        parametros.put("varNombre_practica", practicaNombre);
        
        
        try {
            //String path = "src\\main\\java\\com\\unsis\\capcr\\reportes\\reportesPracticas.jasper";
            InputStream reportfile = new FileInputStream(new File(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
           
        
        try {
            
            JasperPrint jprint = JasperFillManager.fillReport(path,parametros,conn); // llenado del reporte
            
            pdfBytes = JasperExportManager.exportReportToPdf(jprint);
            
        } catch (JRException ex) {
 
        }
  
           
        return pdfBytes;
    }

    @Override
    public void generarReportePorAlumno(String matricula, Date fechaInicio, Date fechaFin) {
        
    }

    @Override
    public void generarReportePorPractica(String practicaNombre, Date fechaIncio, Date fechaFin) {
       
    }
    
    
    public static void main(String[] args) {
        ReporteModel repor = new ReporteModel();
        
       //repor.generarReporte("103", "Practica1 1° semestre enfermeria", Date.valueOf(LocalDate.of(2019,2,18)),Date.valueOf(LocalDate.of(2019,6,18)));
        System.out.println("Hola");
    }
    
}
