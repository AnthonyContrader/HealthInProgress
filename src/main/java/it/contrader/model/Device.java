package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Devices")
//@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idDevice")
	private Integer idDevice;
	
	@Column(name="nome")
	private String nome;
	
	//bi-directional many-to-one association to User
			@ManyToOne
			@JoinColumn(name="idUser")
			private User user;

	

	
	public Device() {
	}




	public Integer getIdDevice() {
		return idDevice;
	}




	public void setIdDevice(Integer idDevice) {
		this.idDevice = idDevice;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	



	}	