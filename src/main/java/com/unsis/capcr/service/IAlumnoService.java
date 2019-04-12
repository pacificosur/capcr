/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
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
    public List<Alumno> obtenerAlumno();
    public Alumno obtenerAlumno(String Matricula);
    public void crearAlumno(Alumno alumno);
    public void eliminarAlumno(Alumno alumno);
    public void actualizarAlumno(Alumno alumno);
    
    
}
