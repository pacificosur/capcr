/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.entity;

/**
 *
 * @author LabTW06
 */
public class Alumno {
    private String Nombre;
    private String Apellido;
    private String Grupo;
    private String Matricula;
    private String Carrera;
    private String Semestre;
    
    
    
    
    //Constructor
    public Alumno() {
    }
    
    public Alumno(String Nombre, String Apellido, String Grupo, String Matricula, String Carrera, String Semestre) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Grupo = Grupo;
        this.Matricula = Matricula;
        this.Carrera = Carrera;
        this.Semestre = Semestre;
    }
    
    //getters and setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String Semestre) {
        this.Semestre = Semestre;
    }

    
    

    

   
    
    
}
