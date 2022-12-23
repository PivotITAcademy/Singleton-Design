package com.learning.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static DbConnection instance;

	private Connection conn = null;

	private DbConnection() {

	}

	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "Nidhi1989");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}
}
