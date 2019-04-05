/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

public class ReservacionModel implements IReservacionModel{

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
