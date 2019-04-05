/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Practica;
import java.util.List;

/**
 *
 * @author LabTW08
 */
public class PracticaModel implements IPracticaModel{

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
