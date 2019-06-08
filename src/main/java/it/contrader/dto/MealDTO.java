package it.contrader.dto;

public class MealDTO {

	int Idpiatti;
	int Kcal;
	String piatto;

	public MealDTO() {
		super();
	}
	public MealDTO(int idpiatti, int kcal, String piatto) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Idpiatti;
		result = prime * result + Kcal;
		result = prime * result + ((piatto == null) ? 0 : piatto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealDTO other = (MealDTO) obj;
		if (Idpiatti != other.Idpiatti)
			return false;
		if (Kcal != other.Kcal)
			return false;
		if (piatto == null) {
			if (other.piatto != null)
				return false;
		} else if (!piatto.equals(other.piatto))
			return false;
		return true;
	}
	
	

	
}
