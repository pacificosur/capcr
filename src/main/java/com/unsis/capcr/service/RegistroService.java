/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Registro;
import com.unsis.capcr.model.IRegistroModel;
import com.unsis.capcr.model.RegistroModel;
import java.util.List;

/**
 *
 * @author LabTW13
 */
public class RegistroService implements IRegistroService {
    IRegistroModel iRegistroModel= new RegistroModel();

    @Override
    public List<Registro> obtenerRegistros() {
        return iRegistroModel.obtenerRegistros();
    }

    @Override
    public Registro obtenerRegistro(Long idRegistro) {
        return iRegistroModel.obtenerRegistro(idRegistro);
    }

    @Override
    public void crearRegistro(Registro registro) {
        iRegistroModel.crearRegistro(registro);
    }

    @Override
    public void eliminarRegistro(Long idRegistro) {
        iRegistroModel.eliminarRegistro(idRegistro);
    }

    @Override
    public Registro obtenerRegistroPorMatricula(String matricula) {
        return iRegistroModel.obtenerRegistroPorMatricula(matricula);
    }

    @Override
    public void finalizarRegistro(Long idRegistro, String comentario) {
         iRegistroModel.finalizarRegistro(idRegistro,comentario);
    }
            
}
