package com.unsis.capcr.service;
import com.unsis.capcr.entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    public List<Usuario> obtenerUsuarios();

    public Usuario obtenerUsuario(Long idUsuario);

    public void crearRegistro(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public void eliminarRegistro(Long idUsuario);
    
    public boolean logueo(Usuario usuario);
    
    public void asignarRol(Usuario usuario);
    
    public int RolUsuario(Usuario usuario);
  
    public Usuario obtenerUsuarioPorNombre(String nombreUsuario);

    public Usuario obtenerUsuarioDiferentes(String nombreUsuario, Long idUsuario);
}
