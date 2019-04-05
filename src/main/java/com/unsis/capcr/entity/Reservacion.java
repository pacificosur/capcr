
package com.unsis.capcr.entity;

import java.util.Date;

public class Reservacion {
    private Long idReservacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String area;
    private String responsableArea;
    private String practica;
    private String responsablePractica;
    
    // Constructor
    public Reservacion() {
    } 
    // setters and getters

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
