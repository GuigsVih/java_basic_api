package br.com.vesmos.Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public abstract class ConnectionFactory 
{
	protected Connection connection;
	
	public ConnectionFactory()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/vesmos",
					"root", ""
					);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection connection()
	{
		return connection;
	}
	
	public ResultSet execute(String query) throws SQLException
	{
		Statement statement = connection().createStatement();
		return statement.executeQuery(query);
		
		
	}
}
