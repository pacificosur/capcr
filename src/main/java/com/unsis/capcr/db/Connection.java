/**/
package com.unsis.capcr.db;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection {
private final String url= "jdbc:postgresql://localhost/Usuario";
	private final String user= "postgres";
	private final String password= "root";
	
	public Connection conecta() {
		Connection conn= null;
		try {
			conn= (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Conexión Establecida");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Conexion no establecida.");
		}
		return conn;
	}
}
