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
        Practica practica=null;
        try {
            connection=(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Practica where codigo='"+IdPractica+"'";
            statement= connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                practica=new Practica();
                practica.setCodigo(resultSet.getString("codigo"));
                practica.setNombre(resultSet.getString("nombre"));
                practica.setIdCarrera(resultSet.getString("codigocarrera"));
                practica.setIdSemestre(resultSet.getString("codigosemestre"));
                practica.setFechaCreacion(resultSet.getDate("fechacreacion"));
                practica.setFechaActualizacion(resultSet.getDate("fechaactualizacion"));
                practica.setFechaEliminacion(resultSet.getDate("fechaeliminacion"));
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
            query="SELECT * FROM Practica where fechaeliminacion is null";
            statement= connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Practica practica=new Practica();
                practica.setCodigo(resultSet.getString("codigo"));
                practica.setNombre(resultSet.getString("nombre"));
                practica.setIdCarrera(resultSet.getString("codigocarrera"));
                practica.setIdSemestre(resultSet.getString("codigosemestre"));
                practica.setFechaCreacion(resultSet.getDate("fechacreacion"));
                practica.setFechaActualizacion(resultSet.getDate("fechaactualizacion"));
                practica.setFechaEliminacion(resultSet.getDate("fechaeliminacion"));
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
            query="INSERT INTO Practica(codigo,nombre, "
                    + "codigoSemestre, codigoCarrera, fechaCreacion, fechaActualizacion,fechaEliminacion) "
                    + "VALUES(?,?,?,?,now(),null,null) ";
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
            query="UPDATE Practica set nombre=?, "
                    + "codigoSemestre=?, codigoCarrera=?, fechaActualizacion=now() where codigo=? ";
            statement = connection.prepareStatement(query);
            statement.setString(1,practica.getNombre()); 
            statement.setString(2,practica.getIdSemestre()); 
            statement.setString(3,practica.getIdCarrera());  
            statement.setString(4,practica.getCodigo()); 
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
            query="UPDATE Practica set fechaEliminacion=now()"
                    + " where codigo=? ";
            statement= connection.prepareStatement(query);
            statement.setString(1, IdPractica);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error "+ e.getMessage());
        }
    }
    public static void main(String[] args) {
        IPracticaModel pm = new PracticaModel();
        java.util.Date d = new java.util.Date(); 
        Practica practica = new Practica("1003","lavado de manos","01","03",new java.sql.Date(d.getTime()),null,null);
        pm.actualizarPractica(practica);
    }
    
}