package main;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.ImenikImpl;
import DAO.ImenikInterface;
import DAO.User;

public class mainClass {
	public static void main(String[] args) throws SQLException {
		boolean unos = false;
		User user = new User();
		ImenikInterface imena = new ImenikImpl();
		System.out.println("Za registraciju novog korisnika unesite 0, a za login unesite 1");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();

		switch (choose) {
		case 0:
			user.addUser();
			break;
		case 1:
			Scanner input1 = new Scanner(System.in);
			System.out.print("Unesite svoj username: ");
			String username = input1.nextLine();
			System.out.print("Unesite svoj passqord: ");
			String password = input1.nextLine();

			String nest = username + " " + password;

			while (unos == false) {
				if (nest.equals(user.getUser(username))) {

					unos = true;
					break;
				}
				System.out.println("Username ili password je netacan, ponovite!");
				username = input1.nextLine();
				password = input1.nextLine();
				nest = username + " " + password;
			}
			System.out.println("Ulogovani ste! ");
			System.out.println("Da dodate novi unos, unesite 0 ");
			System.out.println("Da editujete unos, unesite 1! ");
			System.out.println("Da izbrisete unos, unesite 2");
			System.out.println("Da prikazete sve unose uensite 3");
			System.out.println("Da pretrazite imenik po imenu, unesite 4");
			System.out.println("Da pretrazite imenik po prezimenu unesite 5");

			int unos1 = input1.nextInt();
			switch (unos1) {
			case 0:
				imena.add(username);
				break;

			case 1:

				imena.edit(username);

				break;
			
			// Dod
		case 2:
			imena.delete();
			break;
		case 3:
			imena.viewAll(username);
			
			break;
		case 4:
			imena.searchByName(username);
			break;
		case 5:
			imena.searchBySurname(username);
			break;
		}

	}
	}
}
