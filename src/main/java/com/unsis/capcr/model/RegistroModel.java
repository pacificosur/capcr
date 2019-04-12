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
import com.unsis.capcr.db.ConnectionPostgreSQL;
import java.nio.charset.CodingErrorAction;
import java.sql.SQLException;
import java.util.Date;


public class RegistroModel implements IRegistroModel{
    
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Registro> obtenerRegistros() {
        ArrayList <Registro> listaRegistro = new ArrayList<>();
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Registro;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Ingresando...");
                Registro registro = new Registro();
                registro.setCodigoPractica(resultSet.getString("codigoPractica"));
                registro.setMatriculaAlumno(resultSet.getString("matriculaAlumno"));
                registro.setHoraEntrada(resultSet.getString("horaEntrada"));
                registro.setHoraSalida(resultSet.getString("horaSalida"));
                registro.setFecha(resultSet.getDate("fecha"));
                registro.setSustituye(resultSet.getString("sustituye"));
                registro.setComentario(resultSet.getString("comentario"));
                listaRegistro.add(registro);    
            }
            resultSet.close();
            statement.close();
            connection.close();
            return listaRegistro;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Registro obtenerRegistro(Long idRegistro) {
        try{    
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Registro WHERE codigoPractica = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idRegistro);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Ingresando...");
                Registro registro = new Registro();
                registro.setCodigoPractica(resultSet.getString("codigoPractica"));
                registro.setMatriculaAlumno(resultSet.getString("matriculaAlumno"));
                registro.setHoraEntrada(resultSet.getString("horaEntrada"));
                registro.setHoraSalida(resultSet.getString("horaSalida"));
                registro.setFecha(resultSet.getDate("fecha"));
                registro.setSustituye(resultSet.getString("sustituye"));
                registro.setComentario(resultSet.getString("comentario"));
                return registro;
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public void crearRegistro(Registro registro) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "INSERT INTO registro(horaEntrada, horaSalida, fecha, sustituye, comentario"
                    + "VALUES(?, ?, ?, ?, ?); ";
            statement = connection.prepareStatement(query);
            statement.setString(1, registro.getHoraEntrada());
            statement.setString(2, registro.getHoraSalida());
            //statement.setDate(3, registro.getFecha());
            statement.setString(4, registro.getSustituye());
            statement.setString(5, registro.getComentario());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return;
    }

    @Override
    public void actualizarRegistro(Alumno alumno, Practica practica, Registro registro) {
        try{
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "update Registro set matriculaAlumno=?,codigoPractica=?,horaEntrada=?,horaSalida=?,fecha=?,sustituye=?,estado=?,comentario=? where codigoPractica=? ";
            statement = connection.prepareStatement(query);                

            statement.setString(1, alumno.getMatricula()); 
            statement.setString(2, practica.getCodigo());
            statement.setString(3, registro.getHoraEntrada());
            statement.setString(4, registro.getHoraSalida());
            //statement.setString(5, registro.getFecha());
            statement.setString(6, registro.getSustituye());
            statement.setString(7, registro.getComentario() );
            statement.setString(8, practica.getCodigo());
            
            statement.executeUpdate();
            resultSet.close();
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
    
    public static void main(String[] args) {
        //ConnectionPstgreSQL conn= null;
    }
}
