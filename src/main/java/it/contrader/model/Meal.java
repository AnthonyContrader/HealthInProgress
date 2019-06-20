  package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import it.contrader.model.Parameter;

import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Meals")
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPiatto")
	private Integer idPiatto;

	@Column(name="nome")
	private String nome;
	
	@Column(name="kcal")
	private Integer kcal ;
	
	@Column(name="tipo")
	private String tipo ;
	
	//bi-directional many-to-one association to ingredient
			@OneToMany(mappedBy="meal")
			private List<Ingredient> ingredients;
	
	//bi-directional many-to-one association to User
			@ManyToOne
			@JoinColumn(name="idUser")
			private User user;

	public Meal() {
		super();
	}

	public Integer getIdPiatto() {
		return idPiatto;
	}

	public void setIdPiatto(Integer idPiatto) {
		this.idPiatto = idPiatto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getKcal() {
		return kcal;
	}

	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//////////////////////////////////////////////
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Ingredient addIngredient(Ingredient ingredient) {
		getIngredients().add(ingredient);
		ingredient.setUser(this);

		return ingredient;
	}

	public Ingredient removeIngredient(Ingredient ingredient) {
		getIngredients().remove(ingredient);
		ingredient.setUser(null);

		return ingredient;
}
 
	

	
}
