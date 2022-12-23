package com.learning.singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection instance = DbConnection.getInstance();

		long timeBefore = 0;
		long timeAfter = 0;

		System.out.println(instance);

		timeBefore = System.currentTimeMillis();
		Connection connection = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);

		// refer variable of statement
		try {
			Statement statement = connection.createStatement();

			// Create a query
			String query = "select * from person where salary>5000";

			// Create a ref variable to store SQL data
			ResultSet result;

			// Save the data which u get after executing the query
			result = statement.executeQuery(query);

			/*
			 * while (result.next()) {
			 * 
			 * String salary = result.getString("FIRSTNAME");
			 * 
			 * System.out.println(salary);
			 * 
			 * }
			 */

			timeBefore = System.currentTimeMillis();
			connection = instance.getConnection();
			timeAfter = System.currentTimeMillis();

			System.out.println(timeAfter - timeBefore);
			
			
			
			
			timeBefore = System.currentTimeMillis();
			connection = instance.getConnection();
			timeAfter = System.currentTimeMillis();
			
			System.out.println(timeAfter - timeBefore);
			
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				// Close connection
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
