package DTO;

public class Imenik {
	private String name;
	private String surname;
	private String phone_Num;

	public String getPhone_Num() {
		return phone_Num;
	}

	public void setPhone_Num(String phone_Num) {
		this.phone_Num = phone_Num;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	private String e_mail;

	public Imenik() {

	}

	public Imenik(String name, String surname) {

		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
