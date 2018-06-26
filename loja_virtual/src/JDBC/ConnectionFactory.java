package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final String ip = "localhost";
	private final int port = 5433;
	private final String user = "postgres";
	private final String password = "170998";
	private final String database = "loja";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
