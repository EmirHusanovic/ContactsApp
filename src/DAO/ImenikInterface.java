package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ImenikInterface {

	public void add(String Korisnik) throws SQLException;

	public void edit(String Korisnik) throws SQLException;

	public void delete( ) throws SQLException;

	public  void viewAll(String Korisnik) throws SQLException;

	public void searchByName(String Korisnik) throws SQLException;

	public void searchBySurname(String Korisnik) throws SQLException;

}
