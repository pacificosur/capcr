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
import java.sql.Date;
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
    public List<Alumno> obtenerAlumno() {
        ArrayList <Alumno> listaAlumnos= new ArrayList();
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="SELECT * FROM Alumno;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Alumno alumno= new Alumno();
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setGrupo(resultSet.getString("grupo"));  
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));
                alumno.setCodigoSemestre(resultSet.getString("codigoSemestre"));
                alumno.setCodigoCarrera(resultSet.getString("codigoCarrera"));
                 
                
                listaAlumnos.add(alumno);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
            return listaAlumnos;
        }catch(SQLException e){
            e.getMessage();
            return null;
        }
        
    }
    
    
    @Override
    public Alumno obtenerAlumno(String matricula) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query = " SELECT * FROM Alumno WHERE matricula = ?";
            statement=(PreparedStatement) statement.executeQuery(query);
            statement.setString(1, matricula);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Alumno alumno= new Alumno();
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCodigoSemestre());
                statement.setString(8,alumno.getCodigoCarrera());
                statement.executeUpdate();
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
    public void crearAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="INSERT INTO alumno(matricula, nombre, grupo, fechaCreación, fechaActualizacion, fechaEliminacion, codigoSemestre, codigoCarrera"
                    + "VALUES(?,?,?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCodigoSemestre());
                statement.setString(8,alumno.getCodigoCarrera());            
                
                statement.executeUpdate();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    
   /*public static void main(String[] args){
        IAlumnoModel am = new AlumnoModel();
        java.util.Date d = new java.util.Date(); 
        Alumno al= new Alumno("matricula","nombre","apellido","grupo",new java.sql.Date(d.getTime()),null,null,"carrera","semestre");
        am.CrearAlumno(al);
        List<Alumno> alumno=am.ObtenerAlumno();
        
        for(Alumno a: am.ObtenerAlumno()){
            System.out.println(a.getNombre());
        } 
    }*/

    
    @Override
    public void actualizarAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="UPDATE Alumno SET (matricula, nombre, grupo, fechaCreación, fechaActualizacion, fechaEliminacion, codigoSemestre, codigoCarrera, "
                    + "VALUES(?,?,?,?,?,?,?,?))";
                statement=(PreparedStatement) statement.executeQuery(query);
                statement.setString(1,alumno.getMatricula());
                statement.setString(2,alumno.getNombre());
                statement.setString(3,alumno.getGrupo());
                statement.setDate(4,alumno.getFechaCreacion());
                statement.setDate(5,alumno.getFechaActualizacion());
                statement.setDate(6,alumno.getFechaEliminacion());
                statement.setString(7,alumno.getCodigoSemestre());
                statement.setString(8,alumno.getCodigoCarrera());
                statement.executeUpdate();            
                resultSet.close();
                statement.close();
                connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
   
    @Override
    public void eliminarAlumno(Alumno alumno) {
        try{
            connection =(Connection) new ConnectionPostgreSQL().conecta();
            query="DELETE FROM Alumno WHERE matricula = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, query);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
}
