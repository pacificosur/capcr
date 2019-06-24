/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 11/04/2019
 * Descripción: implementación del CRUD para el módulo de Reservación.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Reservacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements IReservacionModel {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Reservacion> obtenerRegistros() {
        ArrayList<Reservacion> listaRegistro = new ArrayList<>();
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "select * from fnobtenerreservaciones();";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reservacion reservacion = new Reservacion();
                reservacion.setIdReservacion(resultSet.getLong("_idreservacion"));
                reservacion.setFechaInicio(resultSet.getDate("_fechainicio"));
                reservacion.setFechaFin(resultSet.getDate("_fechafin"));
                reservacion.setArea(resultSet.getString("_area"));
                reservacion.setResponsableArea(resultSet.getString("_responsablearea"));
                reservacion.setPractica(resultSet.getString("_practica"));
                reservacion.setResponsablePractica(resultSet.getString("_responsablepractica"));
                listaRegistro.add(reservacion);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return listaRegistro;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Reservacion obtenerRegistro(Long idReservacion) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "select * from fnobtenerreservacion(?);";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idReservacion);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reservacion reservacion = new Reservacion();
                reservacion.setIdReservacion(resultSet.getLong("_idreservacion"));
                reservacion.setFechaInicio(resultSet.getDate("_fechainicio"));
                reservacion.setFechaFin(resultSet.getDate("_fechafin"));
                reservacion.setArea(resultSet.getString("_area"));
                reservacion.setResponsableArea(resultSet.getString("_responsablearea"));
                reservacion.setPractica(resultSet.getString("_practica"));
                reservacion.setResponsablePractica(resultSet.getString("_responsablepractica"));
                return reservacion;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public void crearRegistro(Reservacion reservacion) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "call spcrearreservacion(?,?,?,?,?,?); ";
            statement = connection.prepareStatement(query);
            statement.setDate(1, reservacion.getFechaInicio());
            statement.setDate(2, reservacion.getFechaFin());
            statement.setString(3, reservacion.getArea());
            statement.setString(4, reservacion.getResponsableArea());
            statement.setString(5, reservacion.getPractica());
            statement.setString(6, reservacion.getResponsablePractica());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarRegistro(Reservacion reservacion) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "call spactualizarreservacion(?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setDate(1, reservacion.getFechaInicio());
            statement.setDate(2, reservacion.getFechaFin());
            statement.setString(3, reservacion.getArea());
            statement.setString(4, reservacion.getResponsableArea());
            statement.setString(5, reservacion.getPractica());
            statement.setString(6, reservacion.getResponsablePractica());
            statement.setLong(7, reservacion.getIdReservacion());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Long idReservacion) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "call speliminarreservacion(?);";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idReservacion);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
