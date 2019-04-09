/*
 * Autor: Padilla Bustamante Uriel Gustavo
 * E-mail: padilla98.upb@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del modulo prácticas
 */
package com.unsis.capcr.entity;

import java.sql.Date;

/**
 *
 * @author LabTW08
 */
public class Practica {
    private String codigo;
    private String nombre;
    private String idSemestre;
    private String idCarrera;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Date fechaEliminacion;

    public Practica() {
    }

    public Practica(String codigo, String nombre, String idSemestre, String idCarrera,Date fechacreacion,Date fechaActualizacion,Date fechaEliminacion ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idSemestre = idSemestre;
        this.idCarrera = idCarrera;
        this.fechaCreacion = fechacreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaEliminacion = fechaEliminacion;
        
    }
 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(String idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
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
