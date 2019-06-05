package it.contrader.model;

public class User {

	private int Iduser;
	private String Nome;
	private String Password;
	private  String Tipo;
	
	public User() {}
	
	public User(int iduser, String nome, String password, String tipo) {
		super();
		Iduser = iduser;
		nome = Nome;
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

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}