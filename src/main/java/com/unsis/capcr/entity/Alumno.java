/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación de la clase Alumno
 */
package com.unsis.capcr.entity;

import java.sql.Date;

/**
 *
 * @author LabTW06
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private String grupo;
    private String matricula;
    private String carrera;
    private String semestre;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaEliminacion;
    //Constructor

    public Alumno() {
    }

    public Alumno(String matricula,String nombre, String apellido, String grupo, Date fechaCreacion, Date fechaActualizacion, Date fechaEliminacion, String carrera, String semestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupo = grupo;
        this.matricula = matricula;
        this.carrera = carrera;
        this.semestre = semestre;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaEliminacion = fechaEliminacion;
    }
    
    

    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }    
}
