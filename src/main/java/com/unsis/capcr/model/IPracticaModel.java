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
public interface IPracticaModel {
    public Practica getPractica(String IdPractica);
    public List<Practica> getPracticas(String IdSemestre,String IdCarrera);
    
    public void crearPractica(Practica practica);
    public void actualizarPractica(Practica practica);
    public void eliminarPractica(String IdPractica);
    
}
