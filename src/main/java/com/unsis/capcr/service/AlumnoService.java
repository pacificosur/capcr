/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción:Clase que implementa la interfaz IAlumnoService
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.model.AlumnoModel;
import com.unsis.capcr.model.IAlumnoModel;
import java.util.List;

public class AlumnoService implements IAlumnoService {

    IAlumnoModel iAlumnoModel = new AlumnoModel();

    @Override
    public List<Alumno> obtenerAlumnos() {
        return iAlumnoModel.obtenerAlumnos();
    }

    @Override
    public Alumno obtenerAlumno(String Matricula) {
        return iAlumnoModel.obtenerAlumno(Matricula);
    }

    @Override
    public void crearAlumno(Alumno alumno) {
        iAlumnoModel.crearAlumno(alumno);
    }

    @Override
    public void eliminarAlumno(String idAlumno) {
        iAlumnoModel.eliminarAlumno(idAlumno);
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        iAlumnoModel.actualizarAlumno(alumno);
    }

}
