/*
 * Autor: Eber Martínez García
 * E-mail: hebber.garcia.1997@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación de la clase RegistroModel que implementa 
 *              los metodo de la interfaz IRegidtroModel.
 */

package com.unsis.capcr.model;

import com.unsis.capcr.entity.Registro;
import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Alumno;
import com.unsis.capcr.entity.Practica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroModel implements IRegistroModel{
    
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resulSet;
    private String query;

    @Override
    public List<Registro> obtenerRegistros() {
        ArrayList <Registro> listaRegistro = new ArrayList<>();
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Rregidtro;";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Registro obtenerRegistro(Long idRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearRegistro(Registro registro) {
        return;
    }

    @Override
    public void actualizarRegistro(Alumno alumno, Practica practica, Registro registro) {
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "update Registro set matriculaAlumno=?,codigoPractica=?,horaEntrada=?,horaSalida=?,fecha=?,sustituye=?,estado=?,comentario=? where codigoPractica=? ";
            statement = connection.prepareStatement(query);                

            statement.setString(1, alumno.getMatricula()); 
            //statement.setString(2, practica.getIdPractica());
            statement.setString(3, registro.getHoraEntrada());
            statement.setString(4, registro.getHoraSalida());
                

            statement.executeUpdate();

            resulSet.close();
            statement.close();
            connection.close();


        }catch(Exception e){
             System.err.println("Error");;

        }
    }

    @Override
    public void eliminarRegistro(Long idRegistro) {
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "delete from Reporte where idPractica = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idRegistro);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println("Error " + e.getMessage());
        }
    }
}
