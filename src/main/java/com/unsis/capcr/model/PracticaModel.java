/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                practica.setIdPractica(resultSet.getString("idPractica"));
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
    }

    @Override
    public void actualizarPractica(Practica practica) {
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
