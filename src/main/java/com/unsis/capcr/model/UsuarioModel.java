/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/04/2019
 * Descripción: implementación del CRUD para el módulo de Usuario.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel implements IUsuarioModel {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;
            
    @Override
    public List<Usuario> obtenerUsuario() {
        ArrayList <Usuario> listaUsuario = new ArrayList<>();
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT *FROM Reservacion";
            statement = (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getLong("idUsuario"));             
                usuario.setTipo(1);
                usuario.setApellidos(query);
                usuario.setContraseña(query);
                usuario.setNombre(query);
                usuario.setNombreUsuario(query);
            }
            resultSet.close();
            connection.close();
            statement.close();
            return listaUsuario;
        }catch(Exception e){
        }
        
        return null;
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
    public void eliminarRegistro(Long idUsuario) {
        
        
     try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "DELETE *FROM Usuario WHERE idUsuario = ?";
            statement = connection.prepareStatement(query);
            
            statement.setLong(1,idUsuario);
            statement.executeUpdate();
            connection.close();
            statement.close();
            
        }catch(Exception e){
        }
    }

}
