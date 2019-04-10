/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 09/04/2019
 * Descripción: implementación del CRUD para el módulo de Usuario.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel implements IUsuarioModel {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT *FROM usuario;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getLong("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellidos(resultSet.getString("apellido"));
                usuario.setNombreUsuario(resultSet.getString("nombreusuario"));
                usuario.setContraseña(resultSet.getString("contraseña"));
                usuario.setTipo(resultSet.getInt("tipo"));

                listaUsuario.add(usuario);
                System.out.println("saliendo");
            }
            resultSet.close();
            connection.close();
            statement.close();
            return listaUsuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        Usuario usuario = new Usuario();
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM usuario where idUsuario = ? ";
            statement = (PreparedStatement) connection.createStatement();
            statement.setLong(1, idUsuario);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
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
            return usuario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "insert into usuario(nombre, apellido, nombreUsuario, contraseña, tipo)values(?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellidos());
            statement.setString(3, usuario.getNombreUsuario());
            statement.setString(4, usuario.getContraseña());
            statement.setLong(5, usuario.getTipo());
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "UPDATE usuario SET nombre=?, apellido=?, nombreUsuario=?, contraseña=?, tipo=? values(?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellidos());
            statement.setString(3, usuario.getNombreUsuario());
            statement.setString(4, usuario.getContraseña());
            statement.setLong(5, usuario.getTipo());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Long idUsuario) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "DELETE FROM usuario WHERE idUsuario = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idUsuario);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        IUsuarioModel um = new UsuarioModel();
        
        //Usuario u = new Usuario();   
        /* u.setNombre("Hiralda");
        u.setApellidos("Castro");
        u.setNombreUsuario("unsis3");
        u.setContraseña("12345");
        u.setTipo(2);
        um.crearRegistro(u);*/
        for (Usuario u : um.obtenerUsuarios()) {
            System.out.println(u.getNombre());
        }

    }
}
