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
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	//bi-directional many-to-one association to User
			@ManyToOne
			@JoinColumn(name="idUser")
			private User user;

	

	
	public Device() {
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
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