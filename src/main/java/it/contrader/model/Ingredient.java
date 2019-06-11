package it.contrader.model;

public class Ingredient {
	private int idingredient;
	private String nome;
	public Ingredient() {
		super();
	}
	public Ingredient( String nome) {
		super();
		this.idingredient = idingredient;
		this.nome = nome;
	}
	public int getIdingredient() {
		return idingredient;
	}
	public void setIdingredient(int idingredient) {
		this.idingredient = idingredient;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
	
		return new String (this.idingredient + " " + this.nome);
	}
}
