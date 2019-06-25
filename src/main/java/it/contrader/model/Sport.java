  package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Sports")
//@NamedQuery(name="Sport.findAll", query="SELECT s FROM Sport s")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSport")
	private Integer idSport;

	@Column(name="nome")
	private String nome;
	
	@Column(name="tipo")
	private String tipo ;
	
	@Column(name="durata")
	private Integer durata ;
	
	//bi-directional many-to-one association to User
			@ManyToOne
			@JoinColumn(name="idUser")
			private User user;
	


	public Sport() {
		super();
	}

	public Integer getIdSport() {
		return idSport;
	}

	public void setIdSport(Integer idSport) {
		this.idSport = idSport;
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

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	} 
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 
}
