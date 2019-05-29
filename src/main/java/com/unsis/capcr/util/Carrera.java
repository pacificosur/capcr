/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.util;

/**
 *
 * @author LabTW04
 */
public enum Carrera {

    ENFERMERIA("Enfermería", "03"), ODONTOLOGIA("Odontología", "13"), MEDICINA("Medicina", "14");

    private String nombreCarrera;
    private String codigoCarrera;

    private Carrera(String nombreCarrera, String codigoCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrea) {
        this.nombreCarrera = nombreCarrea;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

}
