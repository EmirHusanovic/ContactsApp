package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionManager {

	// instanca same klase
	private static ConnectionManager instance = null;
	// Vrijednosti prilikom instalacije MySql servera
	private static final String USERNAME = "root";
	private static final String PASSWORD = "guitarhero1";
	// Ime baze na koju se spajamo
	private static final String CONN_STRING = "jdbc:mysql://localhost/Imenik?useSSL=false&serverTimezone=UTC";
	// Connection object
	private Connection connection = null;

	// Private constructor
	private ConnectionManager() {

	}

	// Provjeriti da li je instana null,instancirati i vratiti ili samo vratiti
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();

		}
		return instance;
	}

	private boolean openConnection() {
		try {
			connection = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				System.out.println("Konekcija otvorena.");
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	public void close() {
		System.out.println("Konekcija zatvorena.");
		try {
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}

}
