/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.model.IReporteModel;
import com.unsis.capcr.model.ReporteModel;
import java.sql.Date;

/**
 *
 * @author Uriel
 */
public class ReporteService implements IReporteService{

    IReporteModel iReporteModel = new ReporteModel();
    
    @Override
    public byte[] generarReporte(String grupo, String practicaNombre, Date fechaInicio, Date fechaFin, String path) {
       return iReporteModel.generarReporte(grupo, practicaNombre, fechaInicio, fechaFin,path);
    }

    @Override
    public void generarReportePorAlumno(String matricula, Date fechaInicio, Date fechaFin) {
        iReporteModel.generarReportePorAlumno(matricula, fechaInicio, fechaFin);
    }

    @Override
    public void generarReportePorPractica(String practicaNombre, Date fechaIncio, Date fechaFin) {
        iReporteModel.generarReportePorPractica(practicaNombre, fechaIncio, fechaFin);
    }
    
}
