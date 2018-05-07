package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DTO.Imenik;
import DTO.Users;

public class ImenikImpl implements ImenikInterface {
	// connect to the database
	Connection connection = ConnectionManager.getInstance().getConnection();

	// Unos
	@Override
	public void add(String Korisnik) throws SQLException {
		// Sql query
		String query = "Insert into Imena (ime,prezime,phoneNum,email,Korisnik)values(?,?,?,?,?)";
		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite ime: ");
		String ime = input.nextLine();
		System.out.println("Unesite prezime:");
		String prezime = input.nextLine();
		System.out.println("Unesite broj telefona: ");
		String phoneNum = input.nextLine();
		System.out.println("Unesite email adresu: ");
		String email = input.nextLine();
		input.close();
		try (
				// java sql statement
				PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, ime);
			statement.setString(2, prezime);
			statement.setString(3, phoneNum);
			statement.setString(4, email);
			statement.setString(5, Korisnik);

			statement.executeUpdate();
			System.out.println("Izvrsen je novi unos! ");
		}

	}

	// Update metoda
	@Override
	public void edit(String Korisnik) throws SQLException {

		Scanner input = new Scanner(System.in);
		System.out.println("Unesite staro ime: ");
		String imeStaro = input.nextLine();
		System.out.println("Unesite staro prezime: ");
		String prezStaro = input.nextLine();
		System.out.print("Unesite novo ime: ");
		String imeNovo = input.nextLine();
		System.out.print("Unesite novo prezime: ");
		String prezimeNovo = input.nextLine();
		input.close();
		String query = "Update Imenik.Imena SET Ime=? and Prezime=? where (Ime=?,Prezime=?, Korisnik=?)";
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, imeNovo);
			statement.setString(2, prezimeNovo);
			statement.setString(3, imeStaro);
			statement.setString(4, prezStaro);
			statement.setString(5, Korisnik);
			statement.executeUpdate();
			System.out.println("Edit je uspijesno izvrsen! ");

		}

	}

	// Delete
	@Override
	public void delete() throws SQLException {
		String query = "Delete from Imena where Ime=?";
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite ime korisnika kojeg zelite da obrisete: ");
		String ime = input.nextLine();
		input.close();
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, ime);
			statement.executeUpdate();
			System.out.println("Korisnik je uspijesno izbrisan! ");

		}
	}

	// Print all
	@Override
	public void viewAll(String Korisnik) throws SQLException {
		String query = "Select * from Imena where Korisnik=?";
		ResultSet rs = null;
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, Korisnik);
			rs = statement.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("Ime") + " " + rs.getString("Prezime") + " " + rs.getString("phoneNum")
						+ " " + rs.getString("email"));
			}

		}

	}

	// Search
	@Override
	public void searchByName(String Korisnik) throws SQLException {
		ResultSet rs = null;
		String query = "Select * from Imena where Ime=? and Korisnik=?";
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite ime po kojima zelite da pretrazite: ");
		String ime = input.nextLine();
		input.close();
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, ime);
			statement.setString(2, Korisnik);
			rs = statement.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getString("Ime") + " " + rs.getString("Prezime")+ " " + rs.getString("phoneNum")
				+ " " + rs.getString("email"));
			}

		}

	}

	// Search
	@Override
	public void searchBySurname(String Korisnik) throws SQLException {

		ResultSet rs = null;
		String query = "Select * from Imena where Prezime=? and Korisnik=?";
		Scanner input = new Scanner(System.in);
		System.out.print("Unesite prezime po kojima zelite da pretrazite: ");
		String prezime = input.nextLine();
		input.close();
		try (PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);) {
			statement.setString(1, prezime);
			statement.setString(2, Korisnik);
			rs = statement.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getString("Ime") + " " + rs.getString("Prezime")+ " " + rs.getString("phoneNum")
				+ " " + rs.getString("email"));
			}

		}

	}

}
