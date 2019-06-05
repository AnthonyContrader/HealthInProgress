package it.contrader.dto;

public class UserDTO {
	private int idUser;
	private String nome;
	private String tipo;
	private String password;


	public UserDTO(String username, String usertype) {
		this.nome = username;
		this.tipo = usertype;
	}
	
	public UserDTO() {} 
	
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
