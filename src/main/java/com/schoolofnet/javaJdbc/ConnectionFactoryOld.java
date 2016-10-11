package com.schoolofnet.javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryOld {
	
	private Connection con = null;
	
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimezone=UTC", "root", "root");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return con;
	}
	
	public void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}			
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
