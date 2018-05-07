package DAO;

import java.sql.SQLException;

import DTO.Users;

public interface UserInterface {
	public void addUser() throws SQLException;

	public String getUser(String username) throws SQLException;

}
