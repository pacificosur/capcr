
/* Autor: José Benito Gómez Sánchez
 * e-mail: josegomz.sa17@gmail.com
 * fechaCreacion: 05/04/2019
 * conexion de la clase java a postgreSQL
*/
package com.unsis.capcr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionPostgreSQL {
    private final String url= "jdbc:postgresql://localhost/clinica";
    private final String user= "postgres";
    private final String password= "root";
    Connection conn= null;
    public Connection conecta() {
	try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("Conexión Establecida");
	}
	catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Conexion no establecida.");
	} catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
	return conn;
    }
    public void cerrarConexion() throws SQLException{
        if(conn!=null){
            conn.close();
        }
    }
    
    public static void main(String[] args) {
		ConnectionPostgreSQL c = new ConnectionPostgreSQL();
		c.conecta();
    }
}
