/*
 * Autor: Eber Martínez García
 * E-mail: hebber.garcia.1997@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/04/2019
 * Descripción: implementación del entity del registro.
 */

package com.unsis.capcr.entity;

import java.util.Date;

public class Registro {
    private Long idRegistro;
    private String matriculaAlumno;
    private String codigoPractica;
    private String horaEntrada;
    private String horaSalida;
    private String sustituye;
    
    public Registro(Long idRegistro,String matriculaAlumno, String codigoPractica, String horaEntrada, String horaSalida, String sustituye){
        this.idRegistro=idRegistro;
        this.matriculaAlumno=matriculaAlumno;
        this.codigoPractica=codigoPractica;
        this.horaEntrada=horaEntrada;
        this.horaSalida=horaSalida;
        this.sustituye=sustituye;
    }

    public Long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }
    
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