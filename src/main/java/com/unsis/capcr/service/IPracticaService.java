/*
 * Autor: Padilla Bustamante Uriel Gustavo
 * E-mail: padilla98.upb@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del modulo prácticas
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Practica;
import java.util.List;

public interface IPracticaService {
    public Practica getPractica(String IdPractica);
    public List<Practica> getPracticas(String IdSemestre,String IdCarrera);
    
    public void crearPractica(Practica practica);
    public void actualizarPractica(Practica practica);
    public void eliminarPractica(String IdPractica);
    public List<Practica> getPracticaRegistro(String IdSemestre, String IdCarrera);
    
}
