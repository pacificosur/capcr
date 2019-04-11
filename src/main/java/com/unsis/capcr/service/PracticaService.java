/*
 * Autor: Padilla Bustamante Uriel Gustavo
 * E-mail: padilla98.upb@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 10/04/2019
 * Descripción: implementación del modulo prácticas
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Practica;
import com.unsis.capcr.model.IPracticaModel;
import com.unsis.capcr.model.PracticaModel;
import java.util.List;

/**
 *
 * @author LabTW08
 */
public class PracticaService implements IPracticaService{

    IPracticaModel iPracticaModel=new PracticaModel();
    
    @Override
    public Practica getPractica(String IdPractica) {
        return iPracticaModel.getPractica(IdPractica);
    }

    @Override
    public List<Practica> getPracticas(String IdSemestre, String IdCarrera) {
        return iPracticaModel.getPracticas(IdSemestre, IdCarrera);
    }

    @Override
    public void crearPractica(Practica practica) {
        iPracticaModel.crearPractica(practica);
    }

    @Override
    public void actualizarPractica(Practica practica) {
        iPracticaModel.actualizarPractica(practica);
    }

    @Override
    public void eliminarPractica(String IdPractica) {
        iPracticaModel.eliminarPractica(IdPractica);
    }
    
}
