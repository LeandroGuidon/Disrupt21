package br.com.fiap.disrupt21.factory;

import java.sql.*;

public class ConnectionFactory {

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm85756", "270491");
		
		System.out.println("Conexão aberta");
		
		return con;	
	}
	
}
