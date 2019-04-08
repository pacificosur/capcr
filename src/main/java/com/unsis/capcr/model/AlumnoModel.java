/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.model;
import com.unsis.capcr.db.ConnectionPostgreSQL;
import com.unsis.capcr.entity.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            query="SELECT * FROM Alumnos";
            statement=(PreparedStatement) statement.executeQuery(query);
            while(resultset.next()){
                Alumno alumno= new Alumno();
                alumno.setNombre(resultset.getString("Nombre"));
                alumno.setApellido(resultset.getString("Apellido"));
                alumno.setGrupo(resultset.getString("Grupo"));  
                alumno.setMatricula(resultset.getString("Matricula"));
                alumno.setCarrera(resultset.getString("Carrera")); 
                alumno.setSemestre(resultset.getString("Semestre"));                
            }
        }catch(Exception e){
            e.getMessage();
        }
        return listaalumnos;
    }

    @Override
    public Alumno ObtenerAlumno(String Matricula) {
        return null;
    }

    @Override
    public void CrearAlumno(Alumno alumno) {
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
    }
    
}
