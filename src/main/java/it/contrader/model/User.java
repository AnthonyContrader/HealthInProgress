package it.contrader.model;

public class User {

	private int Iduser;
	private String Nome;
	private String Password;
	private  String Tipo;
	
	
	
	public User() {
		super();
	}

	public User( String nome, String password, String tipo) {
		super();
		
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

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
	
		return new String (this.Iduser + " " + this.Nome + " " + this.Tipo+""+ this.Password);
	}
	public boolean equals(User userCompare)  {

		if (!this.getNome().equals(userCompare.getNome())) {

			return false;

		}
 
		

		if (!this.getPassword().equals(userCompare.getPassword())) {

			return false;

		}

		

		

		return true;

				

	}
}