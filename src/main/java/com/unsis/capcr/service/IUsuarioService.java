package com.unsis.capcr.service;
import com.unsis.capcr.entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerUsuario(Long idUsuario);

    public void crearRegistro(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public void eliminarRegistro(Usuario usuario);
    
    public boolean logueo(Usuario usuario);
}
