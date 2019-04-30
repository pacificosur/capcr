/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/04/2019
 * Descripción: implementación del servicio para el módulo de Usuario.
 */
package com.unsis.capcr.service;

import com.unsis.capcr.entity.Usuario;
import com.unsis.capcr.model.IUsuarioModel;
import com.unsis.capcr.model.UsuarioModel;
import java.util.List;

public class UsuarioService implements IUsuarioService {

    IUsuarioModel iUsuarioModel = new UsuarioModel();
    
    @Override
    public List<Usuario> obtenerUsuarios() {
        return iUsuarioModel.obtenerUsuarios();
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        return null;
    }

    @Override
    public void crearRegistro(Usuario usuario) {

    }

    @Override
    public void actualizarRegistro(Usuario usuario) {

    }

    @Override
    public void eliminarRegistro(Usuario usuario) {

    }

    @Override
    public boolean logueo(Usuario usuario) {
       return iUsuarioModel.logueo(usuario);
    }

}
