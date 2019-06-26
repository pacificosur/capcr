/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Registro;
import java.util.List;

/**
 *
 * @author LabTW13
 */
public interface IRegistroService {
    public List<Registro> obtenerRegistros();

    public Registro obtenerRegistro(Long idRegistro);

    public void crearRegistro(Registro registro);

    public void eliminarRegistro(Long idRegistro);
    
    public Registro obtenerRegistroPorMatricula(String matricula);
    
    public void finalizarRegistro(Long idRegistro, String comentario);
}
