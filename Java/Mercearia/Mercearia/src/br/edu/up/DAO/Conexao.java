package br.edu.up.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
	
	private static final String URL = "jdbc:sqlite:C:\\Users\\lucas\\Downloads\\Mercearia_Main.db";
	
	public static Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(URL);
	}

}
