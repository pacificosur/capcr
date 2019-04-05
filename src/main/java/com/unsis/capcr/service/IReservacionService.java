/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

/**
 *
 * @author LabTW01
 */
public interface IReservacionService {
    public List<Reservacion> obtenerRegistros();
    public Reservacion obtenerRegistro(Long idReservacion);


    public void crearRegistro(Reservacion reservacion);
    public void actualizarRegistro(Reservacion reservacion);
    public void eliminarRegistro(Long idReservacion);
}
