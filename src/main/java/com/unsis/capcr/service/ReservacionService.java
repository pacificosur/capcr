/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del servicio para el módulo de Reservación.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

public class ReservacionService implements IReservacionService{

    @Override
    public List<Reservacion> obtenerRegistros() {
        return null;
    }

    @Override
    public Reservacion obtenerRegistro(Long idReservacion) {
        return null;
    }

    @Override
    public void crearRegistro(Reservacion reservacion) {        
    }

    @Override
    public void actualizarRegistro(Reservacion reservacion) {       
    }

    @Override
    public void eliminarRegistro(Long idReservacion) {        
    }
    
}
