/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.entity;

/**
 *
 * @author LabTW08
 */
public class Practica {
    private String idPractica;
    private String nombre;
    private String IdSemestre;
    private String IdCarrera;
    
    

    public Practica() {
    }

    public Practica(String idPractica, String nombre, String IdSemestre, String IdCarrera) {
        this.idPractica = idPractica;
        this.nombre = nombre;
        this.IdSemestre = IdSemestre;
        this.IdCarrera = IdCarrera;
    }


    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        this.idPractica = idPractica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getIdSemestre() {
        return IdSemestre;
    }

    public void setIdSemestre(String IdSemestre) {
        this.IdSemestre = IdSemestre;
    }

    public String getIdCarrera() {
        return IdCarrera;
    }

    public void setIdCarrera(String IdCarrera) {
        this.IdCarrera = IdCarrera;
    }
    
    
}
