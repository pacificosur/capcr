/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: creación de una interfaz para la implementación del CRUD para 
 *              el módulo de Reservación.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Alumno;
import java.util.List;

public interface IAlumnoModel {
    public List<Alumno> ObtenerAlumno();
    public Alumno ObtenerAlumno(String Matricula);
    
    public void CrearAlumno(Alumno alumno);
    public void EliminarAlumno(Alumno alumno);
    public void BuscarAlumno(Alumno alumno);
    public void ActualizarAlumno(Alumno alumno); 
}
