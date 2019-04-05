
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

public interface IReservacionModel {
    public List<Reservacion> obtenerRegistros();
    public Reservacion obtenerRegistro(Long idReservacion);


    public void crearRegistro(Reservacion reservacion);
    public void actualizarRegistro(Reservacion reservacion);
    public void eliminarRegistro(Long idReservacion);
}
