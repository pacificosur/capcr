/*
 * Autor: Gomez Sanchez Jose Benito
 * E-mail: josegomz.sa17@gmail.com  
 * Fecha creacion: 03/05/2019
 * Fecha modificacion: 03/05/2019
 */
package com.unsis.capcr.model;

import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolModel implements IRolModel{
    //variables usadas para la conexion a la base de datos
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private String query;
    
    /*Unico metodo que se encarga de obtener la lista de la tabla Rol*/
    @Override
    public List<Rol> obtenerRoles() {
        ArrayList<Rol> listaRol = new ArrayList<>();
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "select * from Rol;";
            statement = connection.prepareStatement(query);
            resultset = statement.executeQuery();
            while (resultset.next()) {
                Rol rol = new Rol();
                rol.setIdRol(resultset.getLong("idRol"));
                rol.setNombre(resultset.getString("nombre"));
                listaRol.add(rol);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
