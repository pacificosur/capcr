/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación de la clase entidad (dominio) para el módulo de 
 *              Reservación.
 */
package com.unsis.capcr.entity;

import java.sql.Date;

public class Reservacion {
    private Long idReservacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String area;
    private String responsableArea;
    private String practica;
    private String responsablePractica;

    public Reservacion() {
    }
    
    public Long getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Long idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponsableArea() {
        return responsableArea;
    }

    public void setResponsableArea(String responsableArea) {
        this.responsableArea = responsableArea;
    }

    public String getPractica() {
        return practica;
    }

    public void setPractica(String practica) {
        this.practica = practica;
    }

    public String getResponsablePractica() {
        return responsablePractica;
    }

    public void setResponsablePractica(String responsablePractica) {
        this.responsablePractica = responsablePractica;
    }
}
