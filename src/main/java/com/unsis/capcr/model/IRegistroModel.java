/*
 * Autor: Eber Martínez García
 * E-mail: hebber.garcia.1997@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación de la interfaz para el modelo del registro.
 */

package com.unsis.capcr.model;

import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.entity.Registro;
import java.util.List;

public interface IRegistroModel {
    public List<Registro> obtenerRegistros();
    public Registro obtenerRegistro(Long idRegistro);
    public void crearRegistro(Registro registro);
    public void eliminarRegistro(Long idRegistro);
    public void finalizarRegistro(Long idRegistro, String comentario);
    
    public Registro obtenerRegistroPorMatricula(String matricula);
}
