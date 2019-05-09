/*
 * Autor: Luis Wonen Olvera Vásquez
 * E-mail: loov1625@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: Clase AlumnoModel que implementa la interfaz IAlumno.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoModel implements IAlumnoModel {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public Alumno obtenerAlumno(String matricula) {
        Alumno alumno = null;
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = " SELECT * FROM Alumno WHERE matricula ='" + matricula + "'";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                alumno = new Alumno();
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setGrupo(resultSet.getString("grupo"));
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));
                alumno.setCodigoSemestre(resultSet.getString("codigoSemestre"));
                alumno.setCodigoCarrera(resultSet.getString("codigoCarrera"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return alumno;
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Alumno where fechaeliminacion is null";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setGrupo(resultSet.getString("grupo"));
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));
                alumno.setCodigoSemestre(resultSet.getString("codigoSemestre"));
                alumno.setCodigoCarrera(resultSet.getString("codigoCarrera"));

                listaAlumnos.add(alumno);
            }

            resultSet.close();
            statement.close();
            connection.close();

            return listaAlumnos;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return listaAlumnos;
        }

    }

    @Override
    public void crearAlumno(Alumno alumno) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "INSERT INTO alumno(matricula, nombre, grupo, fechacreacion, fechaactualizacion, fechaeliminacion, codigosemestre, codigocarrera)"
                    + " VALUES(?,?,?,now(),null,null,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, alumno.getMatricula());
            statement.setString(2, alumno.getNombre());
            statement.setString(3, alumno.getGrupo());
            statement.setString(4, alumno.getCodigoSemestre());
            statement.setString(5, alumno.getCodigoCarrera());

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "UPDATE Alumno SET nombre=?, grupo=?, fechaactualizacion=now(), codigosemestre=?, codigocarrera=? where matricula=? ";
            statement = (PreparedStatement) statement.executeQuery(query);
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getGrupo());
            statement.setString(3, alumno.getCodigoSemestre());
            statement.setString(4, alumno.getCodigoCarrera());
            statement.setString(5, alumno.getMatricula());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminarAlumno(String idAlumno) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "UPDATE Alumno set fechaeliminacion=now()"
                    + " where matricula=? ";
            statement = connection.prepareStatement(query);
            statement.setString(1, idAlumno);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
