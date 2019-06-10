package it.contrader.model;

public class Meal {

	private int idpiatti;
	private String piatto;
	private int kcal;
	
	
	
	

	public Meal() {
		super();
	}






	public Meal(int idpiatti, String piatto, int kcal) {
		super();
		this.idpiatti = idpiatti;
		this.piatto = piatto;
		this.kcal = kcal;
	}






	public int getIdpiatti() {
		return idpiatti;
	}






	public void setIdpiatti(int idpiatti) {
		this.idpiatti = idpiatti;
	}






	public String getPiatto() {
		return piatto;
	}






	public void setPiatto(String piatto) {
		this.piatto = piatto;
	}






	public int getKcal() {
		return kcal;
	}






	public void setKcal(int kcal) {
		this.kcal = kcal;
	}






	@Override
	public String toString() {
	
		return new String (this.idpiatti + " " + this.piatto + " " + this.kcal);
	}
	
}