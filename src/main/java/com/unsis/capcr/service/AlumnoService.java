/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción:Clase que impementa la interfaz IAlumnoService
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Alumno;
import java.util.List;

/**
 *
 * @author LabTW06
 */
public class AlumnoService implements IAlumnoService{

    @Override
    public List<Alumno> ObtenerAlumno() {
        return null;
    }

    @Override
    public Alumno ObtenerAlumno(String Matricula) {
        return null;
    }

    @Override
    public void CrearAlumno(Alumno alumno) {
    }

    @Override
    public void EliminarAlumno(Alumno alumno) {
    }

    @Override
    public void BuscarAlumno(Alumno alumno) {
    }

    @Override
    public void ActualizarAlumno(Alumno alumno) {
    }
    
}
