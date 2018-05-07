package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import DTO.Users;

public class User implements UserInterface {
	// connect to the database
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void addUser() throws SQLException {
		// Sql query
		String query = "Insert into User(username,password)values(?,?)";

		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite username: ");
		String username = input.nextLine();
		System.out.println("Unesite password:");
		String password = input.nextLine();
		input.close();
		try (
				// java sql statement
				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
			System.out.println("User added to database!");
		}

	}

	@Override
	public String getUser(String username) throws SQLException {

		// null student
		Users user = null;
		String ime = "";
		String pass = "";

		String query = "SELECT * FROM User WHERE username = ?";

		ResultSet rs = null;

		try (

				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {

			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {

				ime = rs.getString("username");
				pass = rs.getString("password");

				rs.close();
			}
		}

		return ime + " " + pass;

	}
}
