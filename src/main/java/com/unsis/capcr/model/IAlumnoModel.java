/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: Implementación del la interfaz IAlumnoModel.
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
