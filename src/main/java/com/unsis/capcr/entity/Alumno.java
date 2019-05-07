/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: Implementación de la clase Alumno.
 */
package com.unsis.capcr.entity;

import java.sql.Date;

public class Alumno {

    private String nombre;
    private String grupo;
    private String matricula;
    private String codigoCarrera;
    private String codigoSemestre;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaEliminacion;
    //Constructores

    public Alumno() {
    }

    public Alumno(String nombre, String grupo, String matricula, String codigoCarrera, String codigoSemestre, Date fechaCreacion, Date fechaActualizacion, Date fechaEliminacion) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.matricula = matricula;
        this.codigoCarrera = codigoCarrera;
        this.codigoSemestre = codigoSemestre;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaEliminacion = fechaEliminacion;
    }

    //getters and setters corepondientes a la clase Alumno
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getCodigoSemestre() {
        return codigoSemestre;
    }

    public void setCodigoSemestre(String codigoSemestre) {
        this.codigoSemestre = codigoSemestre;
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
