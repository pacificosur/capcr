/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import java.sql.Date;

/**
 *
 * @author Uriel
 */
public interface IReporteService {
    public byte[] generarReporte(String grupo,String practicaNombre, Date fechaInicio, Date fechaFin);
    public void generarReportePorAlumno(String matricula,Date fechaInicio, Date fechaFin );
    public void generarReportePorPractica(String practicaNombre,Date fechaIncio, Date fechaFin);
}
