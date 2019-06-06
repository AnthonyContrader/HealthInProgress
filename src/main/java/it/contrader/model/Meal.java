package it.contrader.model;

public class Meal {

	
	private int Idpiatti;
	private int Kcal;
	private String piatto;

 

public Meal() {
		
	}

public Meal(int idpiatti, int kcal, String piatto) {
		super();
		Idpiatti = idpiatti;
		Kcal = kcal;
		this.piatto = piatto;
	}

public int getIdpiatti() {
	return Idpiatti;
}

public void setIdpiatti(int idpiatti) {
	Idpiatti = idpiatti;
}

public int getKcal() {
	return Kcal;
}

public void setKcal(int kcal) {
	Kcal = kcal;
}

public String getPiatto() {
	return piatto;
}

public void setPiatto(String piatto) {
	this.piatto = piatto;
}

}