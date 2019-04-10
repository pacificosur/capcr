/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del servicio para el módulo de Reservación.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Reservacion;
import com.unsis.capcr.model.IReservacionModel;
import com.unsis.capcr.model.ReservacionModel;
import java.util.List;

public class ReservacionService implements IReservacionService{
    IReservacionModel iReservacionModel = new ReservacionModel();

    @Override
    public List<Reservacion> obtenerRegistros() {
        return iReservacionModel.obtenerRegistros();
    }

    @Override
    public Reservacion obtenerRegistro(Long idReservacion) {
        return iReservacionModel.obtenerRegistro(idReservacion);
    }

    @Override
    public void crearRegistro(Reservacion reservacion) {       
        iReservacionModel.crearRegistro(reservacion);
    }

    @Override
    public void actualizarRegistro(Reservacion reservacion) { 
        iReservacionModel.actualizarRegistro(reservacion);
    }

    @Override
    public void eliminarRegistro(Long idReservacion) {  
        iReservacionModel.eliminarRegistro(idReservacion);
    }
}
