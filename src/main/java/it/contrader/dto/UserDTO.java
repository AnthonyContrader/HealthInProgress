package it.contrader.dto;

public class UserDTO {
	private int idUser;
	private String nome;
	private String tipo;
	private String password;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (idUser != other.idUser)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	





}
