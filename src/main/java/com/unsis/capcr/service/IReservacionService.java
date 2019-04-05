/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: creación de una interfaz para la implementación de los servicios
 *              del módulo de Reservación.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

public interface IReservacionService {
    public List<Reservacion> obtenerRegistros();
    public Reservacion obtenerRegistro(Long idReservacion);


    public void crearRegistro(Reservacion reservacion);
    public void actualizarRegistro(Reservacion reservacion);
    public void eliminarRegistro(Long idReservacion);
}
