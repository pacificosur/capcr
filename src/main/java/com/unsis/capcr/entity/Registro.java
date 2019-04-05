package com.unsis.capcr.entity;

public class Registro {
    private String matriculaAlumno;
    private String codigoPractica;
    private String horaEntrada;
    private String horaSalida;
    private String sustituye;
    
    public Registro(){
        
    }

    public String getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(String matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getCodigoPractica() {
        return codigoPractica;
    }

    public void setCodigoPractica(String codigoPractica) {
        this.codigoPractica = codigoPractica;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getSustituye() {
        return sustituye;
    }

    public void setSustituye(String sustituye) {
        this.sustituye = sustituye;
    }
    
}