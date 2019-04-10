/*
 * Autor: Pedro Eliezer García Ramírez
 * E-mail: pg548169@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 08/04/2019
 * Descripción: Clase AlumnoModel que implementa la interfaz IAlumno.
 */
package com.unsis.capcr.model;
import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LabTW06
 */
public class AlumnoModel implements IAlumnoModel{
private Connection connection;
private PreparedStatement statement;
private ResultSet resultSet;
private String query;
    @Override
    public List<Alumno> ObtenerAlumno() {
        ArrayList <Alumno> listaalumnos= new ArrayList();
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Alumno";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Alumno alumno= new Alumno();
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setGrupo(resultSet.getString("grupo"));  
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));
                alumno.setSemestre(resultSet.getString("semestre")); 
                alumno.setCarrera(resultSet.getString("carrera"));
                listaalumnos.add(alumno);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return listaalumnos;
    }
    
    
    @Override
    public Alumno ObtenerAlumno(String matricula) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query = " SELECT * FROM Alumno WHERE matricula = ?";
            statement.setString(1,matricula);
            statement=(PreparedStatement) statement.executeQuery(query);
            
            while(resultSet.next()){
                Alumno alumno= new Alumno();
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getApellido());
                statement.setString(4,alumno.getGrupo());
                statement.setDate(5,alumno.getFechaCreacion());
                statement.setDate(6,alumno.getFechaActualizacion());
                statement.setDate(7,alumno.getFechaEliminacion());
                statement.setString(8,alumno.getCarrera());
                statement.setString(9,alumno.getSemestre());
                statement.executeUpdate();

                resultSet.close();
                statement.close();
                return alumno;
        }
                resultSet.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public void CrearAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="INSERT INTO Alumno(matricula, nombre, apellido, grupo, fechaCreación, fechaActualizacion, fechaEliminacion, carrera, semestre"
                    + "VALUES(?,?,?,?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getApellido());
                statement.setString(4,alumno.getGrupo());
                statement.setDate(5,alumno.getFechaCreacion());
                statement.setDate(6,alumno.getFechaActualizacion());
                statement.setDate(7,alumno.getFechaEliminacion());
                statement.setString(8,alumno.getCarrera());
                statement.setString(9,alumno.getSemestre());
                statement.executeUpdate();
                
                resultSet.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    
    public static void main(String[] args){
        IAlumnoModel am = new AlumnoModel();
        
        Alumno a = new Alumno();
        
        
    }

    
    @Override
    public void EliminarAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="DELETE FROM Alumno WHERE matricula=?";
            statement= connection.prepareStatement(query);
            statement.setString(1, query);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    @Override
    public void BuscarAlumno(Alumno alumno) {
    }

    @Override
    public void ActualizarAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="UPDATE Alumno SET (matricula, nombre, apellido, grupo, fechaCreación, fechaActualizacion, fechaEliminacion, carrera, semestre"
                    + "VALUES(?,?,?,?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getApellido());
                statement.setString(4,alumno.getGrupo());
                statement.setDate(5,alumno.getFechaCreacion());
                statement.setDate(6,alumno.getFechaActualizacion());
                statement.setDate(7,alumno.getFechaEliminacion());
                statement.setString(8,alumno.getCarrera());
                statement.setString(9,alumno.getSemestre());
                statement.executeUpdate();            
                resultSet.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
   
    
}
