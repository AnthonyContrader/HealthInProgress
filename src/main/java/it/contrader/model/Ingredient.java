package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import it.contrader.*;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Ingredients")
//@NamedQuery(name="Parameter.findAll", query="SELECT i FROM Ingredient p")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idIngredient")
	private Integer idIngredient;

	@Column(name="nome")
	private String nome;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idPiatto")
	private Meal meal;

	public Ingredient() {
		super();
	}

	public Integer getIdIngredient() {
		return idIngredient;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public void setUser(Meal meal) {
		this.meal = meal;
	}
	

	}	