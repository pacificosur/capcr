/*
 * Autor: Gomez Sanchez Jose Benito
 * E-mail:josegomz.sa17@gmail.com
 * Fecha creacion: 03/05/2019
 * Fecha modificacion: 03/05/2019
 * Descripción: implementación de la clase entidad (dominio) para el módulo de Rol
 */
package com.unsis.capcr.entity;

public class Rol {
    private Long idRol;
    private String nombre;
    //constructor
    public Rol(){
    }
    //setters and getters

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}