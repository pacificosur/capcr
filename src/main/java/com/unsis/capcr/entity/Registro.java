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
    private String matriculaAlumno;
    private String codigoPractica;
    private String horaEntrada;
    private String horaSalida;
    private String sustituye;
    private Date fecha;
    private String comentario;
    
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
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setComentario(String comenta){
        this.comentario=comenta;
    }
    
    public String getComentario(){
        return comentario;
    }
}