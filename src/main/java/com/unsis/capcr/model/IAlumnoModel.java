/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 04/04/2019
 * Descripción: implementación del la interfaz IAlumnoModel
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Alumno;
import java.util.List;

public interface IAlumnoModel {
    public List<Alumno> obtenerAlumno();
    public Alumno obtenerAlumno(String Matricula);
    
    public void crearAlumno(Alumno alumno);
    public void eliminarAlumno(Alumno alumno);
    public void actualizarAlumno(Alumno alumno); 
}
