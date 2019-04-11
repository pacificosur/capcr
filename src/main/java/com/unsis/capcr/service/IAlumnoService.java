/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación de la interfa IAlumnoService 
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Alumno;
import java.util.List;

/**
 *
 * @author LabTW06
 */
public interface IAlumnoService {
    public List<Alumno> ObtenerAlumno();
    public Alumno ObtenerAlumno(String Matricula);
    public void CrearAlumno(Alumno alumno);
    public void EliminarAlumno(Alumno alumno);
    public void ActualizarAlumno(Alumno alumno);
    
    
}
