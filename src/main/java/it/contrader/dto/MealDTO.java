package it.contrader.dto;

public class MealDTO {
	private int idpiatti;
	private String piatto;
	private int kcal;
	public MealDTO() {
		super();
	}
	
	
	
	public MealDTO(String piatto, int kcal) {
		super();
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
	

}

	
	

	