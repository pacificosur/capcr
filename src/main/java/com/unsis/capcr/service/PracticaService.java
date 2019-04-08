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

/**
 *
 * @author LabTW08
 */
public class PracticaService implements IPracticaService{

    @Override
    public Practica getPractica(String IdPractica) {
        return null;
    }

    @Override
    public List<Practica> getPracticas(String IdSemestre, String IdCarrera) {
        return null;
    }

    @Override
    public void crearPractica(Practica practica) {
    }

    @Override
    public void actualizarPractica(Practica practica) {
    }

    @Override
    public void eliminarPractica(String IdPractica) {
    }
    
}
