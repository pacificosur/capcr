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
private ResultSet resultset;
private String query;
    @Override
    public List<Alumno> ObtenerAlumno() {
        ArrayList <Alumno> listaalumnos= new ArrayList();
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Alumno";
            statement=(PreparedStatement) statement.executeQuery(query);
            while(resultset.next()){
                Alumno alumno= new Alumno();
                alumno.setMatricula(resultset.getString("Matricula"));
                alumno.setNombre(resultset.getString("Nombre"));
                alumno.setGrupo(resultset.getString("Grupo"));  
                alumno.setFechaCreacion(resultset.getDate("FechaCreacion"));
                alumno.setFechaActualizacion(resultset.getDate("FechaActualizacion"));
                alumno.setFechaEliminacion(resultset.getDate("FechaEliminacion"));
                alumno.setSemestre(resultset.getString("Semestre")); 
                alumno.setCarrera(resultset.getString("Carrera"));
                listaalumnos.add(alumno);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return listaalumnos;
    }

    @Override
    public Alumno ObtenerAlumno(String Matricula) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query = " SELECT * FROM Alumno WHERE Matricula = ?";
            statement.setString(3,Matricula);
            statement=(PreparedStatement) statement.executeQuery(query);
            while(resultset.next()){
                Alumno alumno= new Alumno();
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCarrera());
                statement.setString(8,alumno.getSemestre());
                statement.executeUpdate();

                resultset.close();
                statement.close();
                return alumno;
        }
                resultset.close();
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
            query="INSERT INTO Alumno(Nombre,Apellido,Grupo,Matricula,Carrera,Semestre"
                    + "VALUES(?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCarrera());
                statement.setString(8,alumno.getSemestre());
                statement.executeUpdate();
                
                resultset.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    @Override
    public void EliminarAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="DELET FROM Alumno WHERE Matricula=?";
            statement= connection.prepareStatement(query);
            statement.setString(1, query);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch(Exception e){
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
            query="UPDATE SET (Nombre,Apellido,Grupo,Matricula,Carrera,Semestre"
                    + "VALUES(?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCarrera());
                statement.setString(8,alumno.getSemestre());
                statement.executeUpdate();            
                resultset.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
}
