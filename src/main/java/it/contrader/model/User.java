package it.contrader.model;

public class User {

	int Iduser;
	String Nome;
	String Password;
	String Tipo;

	public User(int iduser, String nome, String password, String tipo) {
		super();
		Iduser = iduser;
		Nome = nome;
		Password = password;
		Tipo = tipo;
	}

	public int getIduser() {
		return Iduser;
	}

	public void setIduser(int iduser) {
		Iduser = iduser;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}