/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: creación de la interfaz Reservación.
 */
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
