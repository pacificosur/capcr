/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción:Clase que impementa la interfaz IAlumnoService
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.model.AlumnoModel;
import com.unsis.capcr.model.IAlumnoModel;
import java.util.List;

/**
 *
 * @author LabTW06
 */
public class AlumnoService implements IAlumnoService{
    IAlumnoModel iAlumnoModel=new AlumnoModel();
    @Override
    public List<Alumno> ObtenerAlumno() {
       return iAlumnoModel.ObtenerAlumno();
    }

    @Override
    public Alumno ObtenerAlumno(String Matricula) {
        return  iAlumnoModel.ObtenerAlumno(Matricula);
    }

    @Override
    public void CrearAlumno(Alumno alumno) {
        iAlumnoModel.CrearAlumno(alumno);
    }

    @Override
    public void EliminarAlumno(Alumno alumno) {
        iAlumnoModel.EliminarAlumno(alumno);
    }


    @Override
    public void ActualizarAlumno(Alumno alumno) {
        iAlumnoModel.ActualizarAlumno(alumno);
    }
    
}
