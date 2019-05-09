/*
 * Autor: Belisario Nazario Anselmo
 * E-mail: unsis.b@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/05/2019
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
            query = "SELECT * FROM usuario;";
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
            query = "SELECT * FROM usuario WHERE idUsuario = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idUsuario);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usuario.setIdUsuario(resultSet.getLong("idUsuario"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellidos(resultSet.getString("apellido"));
                usuario.setNombreUsuario(resultSet.getString("nombreusuario"));
                usuario.setContraseña(resultSet.getString("contraseña"));
                usuario.setTipo(resultSet.getInt("tipo"));
                return usuario;
            }
            resultSet.close();
            connection.close();
            statement.close();
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
            query = "UPDATE usuario SET nombre=?, apellido=?, nombreusuario=?, contraseña=?, tipo=? WHERE idUsuario = ?;";
            statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellidos());
            statement.setString(3, usuario.getNombreUsuario());
            statement.setString(4, usuario.getContraseña());
            statement.setLong(5, usuario.getTipo());
            statement.setLong(6, usuario.getIdUsuario());
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

    @Override
    public boolean logueo(Usuario usuario) {
        boolean c = false;
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM usuario WHERE nombreusuario = ? AND contraseña=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getContraseña());

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                c = true;
                break;
            }
            resultSet.close();
            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    /*public static void main(String[] args) {
        IUsuarioModel um = new UsuarioModel();
        Usuario u = new Usuario();   
        /*u.setNombre("Hiraldas");
        u.setApellidos("Castro");
        u.setNombreUsuario("unsis3");
        u.setContraseña("12345");
        u.setTipo(2);
        um.crearRegistro(u);*/
    //Para probar obtenerUsuarios.
    /*for (Usuario u : um.obtenerUsuarios()) {
            System.out.println(u.getNombre());
        }*/
    //Para probar obtenerUsuario.
    /*Usuario u = new Usuario();
        u = um.obtenerUsuario(new Long(1));
        System.out.println(u.getNombre()+u.getApellidos());*/
    //Para probar ActualizarRegistro.
    /*Usuario u = new Usuario();   
        u.setNombre("Hiraldas");
        u.setApellidos("Castro");
        u.setNombreUsuario("unsis3");
        u.setContraseña("12345");
        u.setTipo(2);
        u.setIdUsuario(new Long(1));
        um.actualizarRegistro(u);*/
    //para eliminar.
    // um.eliminarRegistro(new Long(6));
    //}
}
