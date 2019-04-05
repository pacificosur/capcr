/*
 * Autor: Rolando Pedro Gabriel
 * E-mail: rolando.pedro.gabriel@gmail.com
 * Fecha Creación: 04/04/2019
 * Fecha Modificación: 05/04/2019
 * Descripción: implementación del CRUD para el módulo de Reservación.
 */
package com.unsis.capcr.model;

import com.unsis.capcr.entity.Reservacion;
import java.util.List;

public class ReservacionModel implements IReservacionModel{
//     <dependency>
//            <groupId>org.postgresql</groupId>
//            <artifactId>postgresql</artifactId>
//        </dependency>     
    
    
//        <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
//	<dependency>
//	    <groupId>org.postgresql</groupId>
//	    <artifactId>postgresql</artifactId>
//	    <version>42.1.2</version>
//	</dependency>

    @Override
    public List<Reservacion> obtenerRegistros() {
        return null;
    }

    @Override
    public Reservacion obtenerRegistro(Long idReservacion) {
       return null;
    }

    @Override
    public void crearRegistro(Reservacion reservacion) {        
    }

    @Override
    public void actualizarRegistro(Reservacion reservacion) {        
    }

    @Override
    public void eliminarRegistro(Long idReservacion) {        
    }
    
    /**
     * 
     * private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String query;

    @Override
    public List<Alumno> obtenerRegistros() {
       ArrayList <Alumno> listaRegistro = new ArrayList<>();
        try{
            connection = new Conexion().getConnection();
            query = " SELECT * FROM Alumno";
            statement = (PreparedStatement) connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                alumno.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setSemestre(resultSet.getString("semestre"));
                alumno.setCarrera(resultSet.getString("carrera"));
                alumno.setEdad(resultSet.getInt("edad"));
                alumno.setEmail(resultSet.getString("correoElectronico"));
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));


                listaRegistro.add(alumno);
            }
            resultSet.close();
            statement.close();
            connection.close();

             return listaRegistro;
        }catch(Exception e){
                return null;

        }	
       
    }

    @Override
    public Alumno obtenerRegistro(int id) {   
        try{
            connection = new Conexion().getConnection();
            query = " SELECT * FROM Alumno WHERE idAlumno = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                alumno.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                alumno.setMatricula(resultSet.getString("matricula"));
                alumno.setSemestre(resultSet.getString("semestre"));
                alumno.setCarrera(resultSet.getString("carrera"));
                alumno.setEdad(resultSet.getInt("edad"));
                alumno.setEmail(resultSet.getString("correoElectronico"));
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                alumno.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                alumno.setFechaActualizacion(resultSet.getDate("fechaActualizacion"));
                alumno.setFechaEliminacion(resultSet.getDate("fechaEliminacion"));

                return alumno;
            }
            resultSet.close();
            statement.close();
            connection.close();


        }catch(Exception e){
                return null;
        }
       return null;
    }
    

    @Override
    public void crearRegistro(Alumno alumno) {
        ArrayList <Alumno> listaRegistro = new ArrayList<>();
        try{
            connection = new Conexion().getConnection();
            query = "insert into Alumno (idAlumno,nombre,apellidoPaterno,apellidoMaterno,matricula,semestre,carrera,edad,correoElectronico,fechaNacimiento,fechaCreacion,fechaActualizacion,fechaEliminacion values(?,?,?,?,?,?,?,?,?,?,?,?,?)) ";
            statement = connection.prepareStatement(query);
            statement.setInt(1,alumno.getIdAlumno());         
            statement.setString(2,alumno.getNombre()); 
            statement.setString(3,alumno.getApellidoPaterno()); 
            statement.setString(4,alumno.getApellidoMaterno()); 
            statement.setString(5,alumno.getMatricula()); 
            statement.setString(6,alumno.getSemestre()); 
            statement.setString(7,alumno.getCarrera()); 
            statement.setInt(8,alumno.getEdad()); 
            statement.setString(9,alumno.getCorreoElectronico()); 
            statement.setDate(10, (Date) alumno.getFechaNacimiento()); 
            statement.setDate(11,(Date)alumno.getFechaCreacion()); 
            statement.setDate(12,(Date)alumno.getFechaActualizacion()); 
            statement.setDate(13,(Date)alumno.getFechaEliminacion());              
            statement.executeUpdate();

            listaRegistro.add(alumno);

            resultSet.close();
            statement.close();
            connection.close();


        }catch(Exception e){
             System.err.println("Error");;

        }	
       
    }

    @Override
    public void actualizarRegistro(Alumno alumno) {
        
        try{
            connection = new Conexion().getConnection();
            query = "update Alumno set nombre=?,apellidoPaterno=?,apellidoMaterno=?,matricula=?,semestre=?,carrera=?,edad=?,correoElectronico=?,fechaNacimiento=?,fechaCreacion=?,fechaActualizacion=?,fechaEliminacion=? where idAlumno=? ";
            statement = connection.prepareStatement(query);                

            statement.setString(1,alumno.getNombre()); 
            statement.setString(2,alumno.getApellidoPaterno()); 
            statement.setString(3,alumno.getApellidoMaterno()); 
            statement.setString(4,alumno.getMatricula()); 
            statement.setString(5,alumno.getSemestre()); 
            statement.setString(6,alumno.getCarrera()); 
            statement.setInt(7,alumno.getEdad()); 
            statement.setString(8,alumno.getCorreoElectronico()); 
            statement.setDate(9, (Date) alumno.getFechaNacimiento()); 
            statement.setDate(10,(Date)alumno.getFechaCreacion()); 
            statement.setDate(11,(Date)alumno.getFechaActualizacion()); 
            statement.setDate(12,(Date)alumno.getFechaEliminacion()); 
            statement.setInt(13,alumno.getIdAlumno());

            statement.executeUpdate();

            resultSet.close();
            statement.close();
            connection.close();


        }catch(Exception e){
             System.err.println("Error");;

        }	
    }

    @Override
    public void eliminarRegistro(int id) {
        try{
            connection = new Conexion().getConnection();
            query = " delete  FROM Alumno WHERE idAlumno = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
            resultSet.close();
            statement.close();
            connection.close();

        }catch(Exception e){
            System.err.println("error");
        }
    }
    
    
     */
    
}
