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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.unsis.capcr.db.ConnectionPostgreSQL;
import java.sql.SQLException;

public class RegistroModel implements IRegistroModel {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Registro> obtenerRegistros() {
        ArrayList<Registro> listaRegistro = new ArrayList<>();

        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Registro as r inner join Alumno as a on r.matriculaAlumno = a.matricula where r.horaSalida is null;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Registro registro = new Registro();
                registro.setIdRegistro(resultSet.getLong("idRegistro"));
                registro.setCodigoPractica(resultSet.getString("codigoPractica"));
                registro.setMatriculaAlumno(resultSet.getString("matriculaAlumno"));
                registro.setHoraEntrada(resultSet.getString("horaEntrada"));
                registro.setHoraSalida(resultSet.getString("horaSalida"));
                registro.setSustituye(resultSet.getString("sustituye"));
                registro.setNombreAlumno(resultSet.getString("nombre"));
                listaRegistro.add(registro);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return listaRegistro;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Registro obtenerRegistro(Long idRegistro) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Registro WHERE idregistro = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idRegistro);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Registro registro = new Registro();
                registro.setCodigoPractica(resultSet.getString("codigoPractica"));
                registro.setMatriculaAlumno(resultSet.getString("matriculaAlumno"));
                registro.setHoraEntrada(resultSet.getString("horaEntrada"));
                registro.setHoraSalida(resultSet.getString("horaSalida"));
                registro.setSustituye(resultSet.getString("sustituye"));
                return registro;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public void crearRegistro(Registro registro) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "INSERT INTO Registro(matriculaAlumno, codigoPractica, horaEntrada, "
                    + "horaSalida, fecha, sustituye, estado, comentario)"
                    + "VALUES(?, ?, now(), null, now(),?, 'en proceso', null); ";
            statement = connection.prepareStatement(query);
            statement.setString(1, registro.getMatriculaAlumno());
            statement.setString(2, registro.getCodigoPractica());
            statement.setString(3, registro.getSustituye());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return;
    }

    public void eliminarRegistro(Registro registro) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "update Registro set estado=?,horaSalida=now(),estado='cancelado',comentario=? where idRegistro=? ";
            statement = connection.prepareStatement(query);

            statement.setString(1, registro.getMatriculaAlumno());
            statement.setString(2, registro.getCodigoPractica());
            statement.setString(3, registro.getMatriculaAlumno());

            statement.executeUpdate();
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println("Error");;

        }
    }
//    public void actualizarRegistros(Registro registro) {
//        try{
//            connection = (Connection) new ConnectionPostgreSQL().conecta();
//            query = "update Registro set matriculaAlumno=?,codigoPractica=?,horaEntrada=now(),horaSalida=null,fecha=current_date,sustituye=null,estado='en proceso',comentario=null where matriculaAlumno=? ";
//            statement = connection.prepareStatement(query);                
//
//            statement.setString(1, registro.getMatriculaAlumno()); 
//            statement.setString(2, registro.getCodigoPractica());
//            statement.setString(3, registro.getMatriculaAlumno());
//            
//            statement.executeUpdate();
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//
//        }catch(Exception e){
//             System.err.println("Error");;
//
//        }
//    }

    public void finalizarRegistro(Long idRegistro, String comentario) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "update Registro set horaSalida=now() estado='cancelado' comentario=? where idRegistro = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, comentario);
            statement.setLong(2, idRegistro);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Long idRegistro) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "update Registro set horaSalida=now() estado='finalizado' where idRegistro = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, idRegistro);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public Registro obtenerRegistroPorMatricula(String matricula) {
        try {
            connection = (Connection) new ConnectionPostgreSQL().conecta();
            query = "SELECT * FROM Registro WHERE matriculaalumno = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, matricula);
            resultSet = statement.executeQuery();
            Registro registro = new Registro();
            while (resultSet.next()) {
                registro.setCodigoPractica(resultSet.getString("codigoPractica"));
                registro.setMatriculaAlumno(resultSet.getString("matriculaAlumno"));
                registro.setHoraEntrada(resultSet.getString("horaEntrada"));
                registro.setHoraSalida(resultSet.getString("horaSalida"));
                registro.setSustituye(resultSet.getString("sustituye"));
                break;
            }
            resultSet.close();
            statement.close();
            connection.close();
            return registro;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        RegistroModel rm = new RegistroModel();

        List<Registro> r = rm.obtenerRegistros();
        for (Registro registro : r) {
            System.out.println(registro.getNombreAlumno());
        }

    }


}
