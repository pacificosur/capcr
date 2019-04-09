/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del CRUD para el módulo de Reservación.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Reservacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements IReservacionModel{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Reservacion> obtenerRegistros() {
        ArrayList <Reservacion> listaRegistro = new ArrayList<>();
        try{
            connection = new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Reservacion";
            statement = (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Reservacion reservacion = new Reservacion();
                reservacion.setIdReservacion(resultSet.getLong("idReservacion"));
                reservacion.setFechaInicio(resultSet.getDate("fechaInicio"));
                reservacion.setFechaFin(resultSet.getDate("fechaFin"));
                reservacion.setArea(resultSet.getString("area"));
                reservacion.setResponsableArea(resultSet.getString("responsableArea"));
                reservacion.setPractica(resultSet.getString("practica"));
                reservacion.setResponsablePractica(resultSet.getString("responsablePractica"));
                listaRegistro.add(reservacion);
            }
            resultSet.close();
            statement.close();
            connection.close();

             return listaRegistro;
        }catch(Exception e){
                return null;

        }	
    }

    @Override
    public Reservacion obtenerRegistro(Long idReservacion) {
        try{
           connection = new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Reservacion WHERE idReservacion = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1,idReservacion);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Reservacion reservacion = new Reservacion();
                reservacion.setIdReservacion(resultSet.getLong("idReservacion"));
                reservacion.setFechaInicio(resultSet.getDate("fechaInicio"));
                reservacion.setFechaFin(resultSet.getDate("fechaFin"));
                reservacion.setArea(resultSet.getString("area"));
                reservacion.setResponsableArea(resultSet.getString("responsableArea"));
                reservacion.setPractica(resultSet.getString("practica"));
                reservacion.setResponsablePractica(resultSet.getString("responsablePractica"));                
                return reservacion;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
                return null;
        }
       return null;
    }

    @Override
    public void crearRegistro(Reservacion reservacion) {   
        try{
            connection = new ConnectionPostgreSQL().conecta();
            query = "INSERT INTO reservacion(fechaInicio, fechaFin, "
                    + "area, responsableArea, practica, responsablePractica) "
                    + "VALUES(?,?,?,?,?,?,?)) ";
            statement = connection.prepareStatement(query);         
            statement.setDate(1,reservacion.getFechaInicio()); 
            statement.setDate(2,reservacion.getFechaFin()); 
            statement.setString(3,reservacion.getArea()); 
            statement.setString(4,reservacion.getResponsableArea()); 
            statement.setString(5,reservacion.getPractica()); 
            statement.setString(6,reservacion.getResponsablePractica()); 
                     
            statement.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }

    }

    @Override
    public void actualizarRegistro(Reservacion reservacion) { 
        try{
        connection = new ConnectionPostgreSQL().conecta();
            query = "UPDATE reservacion SET fechaInicio=?, fechaFin=?, "
                    + "area=?, responsableArea=?, practica=?, responsablePractica=?) "
                    + "VALUES(?,?,?,?,?,?,?)) ";
            statement = connection.prepareStatement(query);         
            statement.setDate(1,reservacion.getFechaInicio()); 
            statement.setDate(2,reservacion.getFechaFin()); 
            statement.setString(3,reservacion.getArea()); 
            statement.setString(4,reservacion.getResponsableArea()); 
            statement.setString(5,reservacion.getPractica()); 
            statement.setString(6,reservacion.getResponsablePractica()); 
                     
            statement.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();
        }catch(SQLException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Long idReservacion) {      
        try{
            connection = new Conexion().getConnection();
            query = "DELETE FROM Reservacion WHERE idReservacion = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1,idReservacion);
            statement.executeUpdate();
            statement.close();
            connection.close();

        }catch(SQLException e){
            System.err.println("Error " + e.getMessage());
        }
    }   
}