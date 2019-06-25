package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Parameters")
//@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="sesso")
	private String sesso;
	
	@Column(name="altezza")
	private Integer altezza ;
	
	@Column(name="peso")
	private Integer peso ;
	
	@Column(name="eta")
	private Integer eta ;
	
	@Column(name="totKcal")
	private String totKcal ;
	
	
	//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="idUser")
		private User user;

	
	public Parameter() {
	}






	public String getSesso() {
		return sesso;
	}



	public void setSesso(String sesso) {
		this.sesso = sesso;
	}



	public Integer getAltezza() {
		return altezza;
	}



	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}



	public Integer getPeso() {
		return peso;
	}



	public void setPeso(Integer peso) {
		this.peso = peso;
	}



	public Integer getEta() {
		return eta;
	}



	public void setEta(Integer eta) {
		this.eta = eta;
	}



	public String getTotKcal() {
		return totKcal;
	}



	public void setTotKcal(String totKcal) {
		this.totKcal = totKcal;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}






	public Integer getId() {
		return id;
	}






	public void setId(Integer id) {
		this.id = id;
	}




}	