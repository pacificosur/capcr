/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.capcr.db;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LabTW01
 */
public class Connection {
private final String url= "jdbc:postgresql://localhost/Usuario";
	private final String user= "postgres";
	private final String password= "root";
	
	public Connection conecta() {
		Connection conn= null;
		try {
			conn= DriverManager.getConnection(url, user, password);
			System.out.println("Conexión Establecida");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Conexion no establecida.");
		}
		return conn;
	}
}
