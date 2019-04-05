package com.unsis.capcr.model;

import com.unsis.capcr.entity.Registro;
import java.util.List;

public interface IRegistroModel {
    public List<Registro> obtenerRegistros();
    public Registro obtenerRegistro(Long idRegistro);
    public void crearRegistro(Registro registro);
    public void actualizarRegistro(Registro registro);
    public void eliminarRegistro(Registro registro);
}
