/*
 * Autores: Padilla Bustamante Uriel Gustavo
 *          Castro Cisneros Hiralda
 * E-mail: padilla98.upb@gmail.com  
 *         hiraldac.cisneros@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 02/05/2019
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

public class PracticaModel implements IPracticaModel{
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;
      
    @Override
    public Practica getPractica(String IdPractica) {
        Practica practica=null;
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="select * from fnobtenerpractica('"+IdPractica+"')";
            statement= connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                practica=new Practica();
                practica.setCodigo(resultSet.getString("_codigo"));
                practica.setNombre(resultSet.getString("_nombre"));
                practica.setIdCarrera(resultSet.getString("_codigocarrera"));
                practica.setIdSemestre(resultSet.getString("_codigosemestre"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return practica;
    }

    @Override
    public List<Practica> getPracticas(String IdSemestre, String IdCarrera) {
        ArrayList<Practica> listaPractica= new ArrayList<>();
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="select * from fnobtenerpracticas();";
            statement= connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Practica practica=new Practica();
                practica.setCodigo(resultSet.getString("_codigo"));
                practica.setNombre(resultSet.getString("_nombre"));
                practica.setIdCarrera(resultSet.getString("_codigocarrera"));
                practica.setIdSemestre(resultSet.getString("_codigosemestre"));
                listaPractica.add(practica);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return listaPractica;
    }

    @Override
    public void crearPractica(Practica practica) {
         try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
//            query="INSERT INTO Practica(codigo,nombre, "
//                    + "codigoSemestre, codigoCarrera, fechaCreacion, fechaActualizacion,fechaEliminacion) "
//                    + "VALUES(?,?,?,?,now(),null,null) ";
            
            query="call spcrearpractica(?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1,practica.getCodigo()); 
            statement.setString(2,practica.getNombre()); 
            statement.setString(3,practica.getIdSemestre()); 
            statement.setString(4,practica.getIdCarrera());  
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
            query="call spactualizarpractica(?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1,practica.getCodigo()); 
            statement.setString(2,practica.getNombre()); 
            statement.setString(3,practica.getIdSemestre()); 
            statement.setString(4,practica.getIdCarrera());  
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
            query="call speliminarpractica(?) ";
            statement= connection.prepareStatement(query);
            statement.setString(1, IdPractica);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
    }

    @Override
    public List<Practica> getPracticaRegistro(String IdSemestre, String IdCarrera) {
        ArrayList<Practica> listaPractica= new ArrayList<>();
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="select * from practica where codigosemestre=? and codigocarrera=?;";
            statement= connection.prepareStatement(query);
            statement.setString(1, IdSemestre);
            statement.setString(2, IdCarrera);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Practica practica=new Practica();
                practica.setCodigo(resultSet.getString("codigo"));
                practica.setNombre(resultSet.getString("nombre"));
                listaPractica.add(practica);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
        return listaPractica;
    }
}