package it.contrader.dto;

public class UserDTO {
 private int iduser;
 private String nome;
 private String tipo;
 private String password;
public UserDTO() {
	super();
}
public UserDTO(String nome, String tipo, String password) {
	super();
	this.iduser = iduser;
	this.nome = nome;
	this.tipo = tipo;
	this.password = password;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean equals(UserDTO userCompare)  {

	if (!this.getNome().equals(userCompare.getNome())) {

		return false;

	}

	

	if (!this.getPassword().equals(userCompare.getPassword())) {

		return false;

	}

	

	if (!this.getTipo().equals(userCompare.getTipo())) {

		return false;

	}

	

	return true;		
 
}}
