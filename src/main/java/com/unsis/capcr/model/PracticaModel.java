/*
 * Autor: Padilla Bustamante Uriel Gustavo
 * E-mail: padilla98.upb@gmail.com  
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del modulo prácticas
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Practica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LabTW08
 */
public class PracticaModel implements IPracticaModel{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;
      
    @Override
    public Practica getPractica(String IdPractica) {
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Practica where idPractica='"+IdPractica+"'";
            statement= (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                Practica practica=new Practica();
                practica.setCodigo(resultSet.getString("idPractica"));
                practica.setNombre("nombre");
                practica.setIdCarrera("idCarrera");
                practica.setIdSemestre("idSemestre");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<Practica> getPracticas(String IdSemestre, String IdCarrera) {
        ArrayList<Practica> listaPractica= new ArrayList<>();
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Practica";
            statement= (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                Practica practica=new Practica();
                practica.setCodigo(resultSet.getString("idPractica"));
                practica.setNombre("nombre");
                practica.setIdCarrera("idCarrera");
                practica.setIdSemestre("idSemestre");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return null;
    }

    @Override
    public void crearPractica(Practica practica) {
         try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="INSERT INTO Practica(codigo,nombre, "
                    + "codigoSemestre, codigoCarrera, fechaCreacion, fechaActualizacion,fechaEliminacion) "
                    + "VALUES(?,?,?,?,?,?,?,?)) ";
            statement = connection.prepareStatement(query);
            statement.setString(1,practica.getCodigo()); 
            statement.setString(2,practica.getNombre()); 
            statement.setString(3,practica.getIdSemestre()); 
            statement.setString(4,practica.getIdCarrera()); 
            statement.setDate(5,practica.getFechaCreacion()); 
            statement.setDate(6,practica.getFechaActualizacion());
            statement.setDate(7,practica.getFechaEliminacion()); 
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
    }

    @Override
    public void actualizarPractica(Practica practica) {
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="UPDATE Practica set codigo=?,nombre=?, "
                    + "codigoSemestre=?, codigoCarrera=?, fechaCreacion=?, fechaActualizacion=?,fechaEliminacion=? ";
            statement = connection.prepareStatement(query);
            statement.setString(1,practica.getCodigo()); 
            statement.setString(2,practica.getNombre()); 
            statement.setString(3,practica.getIdSemestre()); 
            statement.setString(4,practica.getIdCarrera()); 
            statement.setDate(5,practica.getFechaCreacion()); 
            statement.setDate(6,practica.getFechaCreacion());
            statement.setDate(7,practica.getFechaCreacion()); 
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
    }

    @Override
    public void eliminarPractica(String IdPractica) {
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="DELETE FROM Practica WHERE idPractica= ?";
            statement= connection.prepareStatement(query);
            statement.setString(1, IdPractica);
            statement.executeUpdate();
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
    }
    
}
