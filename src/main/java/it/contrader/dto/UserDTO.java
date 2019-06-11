package it.contrader.dto;

public class UserDTO {
	private int idUser;
	private String nome;
	private String tipo;
	private String password;
	

	public UserDTO() {
		super();
	}



	public UserDTO(String nome, String tipo, String password) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.password = password;
	}





	public int getUserId() {
		return idUser;
	}

	public void setUserId(int userId) {
		this.idUser = userId;
	}

	public String getUsername() {
		return nome;
	}

	public void setUsername(String username) {
		this.nome = username;
	}

	public String getUsertype() {
		return tipo;
	}

	public void setUsertype(String usertype) {
		this.tipo = usertype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
