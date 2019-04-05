
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Usuario;
import java.util.List;

public interface IUsuarioModel {
    public List<Usuario> obtenerUsuario();
    public Usuario obtenerUsuario(Long idUsuario);
    public void crearRegistro(Usuario usuario);
    public void actualizarRegistro(Usuario usuario);
    public void eliminarRegistro(Usuario usuario);
}
