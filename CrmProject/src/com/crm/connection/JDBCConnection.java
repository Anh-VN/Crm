package com.crm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/crm";
	private static String username = "root";
	private static String password = "130997";

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connection Success");
			return connection;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found!");
		} catch (SQLException e) {
			System.out.println("Database Not Found!");
		}
		
		return null;
	}
}
