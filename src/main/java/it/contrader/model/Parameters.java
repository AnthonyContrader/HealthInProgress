package it.contrader.model;

public class Parameters {
	private int idParameter;
	private String sesso;
	private double altezza;
	private double peso;
	private int eta;
	private int polso;
	private int freqResp;
	private int tempCorp;

	
	public Parameters(int idParameter,String sesso, double altezza, double peso, int eta, int polso, int freqResp,
			int tempCorp) {
		super();
		this.idParameter = idParameter;
		this.sesso = sesso;
		this.altezza = altezza;
		this.peso = peso;
		this.eta = eta;
		this.polso = polso;
		this.freqResp = freqResp;
		this.tempCorp = tempCorp;
	}







	public Parameters() {
		// TODO Auto-generated constructor stub
	}







	







	public int getIdParameter() {
		return idParameter;
	}







	public void setIdParameter(int idParameter) {
		this.idParameter = idParameter;
	}







	public String getSesso() {
		return sesso;
	}







	public void setSesso(String sesso) {
		this.sesso = sesso;
	}







	public double getAltezza() {
		return altezza;
	}







	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}







	public double getPeso() {
		return peso;
	}







	public void setPeso(double peso) {
		this.peso = peso;
	}







	public int getEta() {
		return eta;
	}







	public void setEta(int eta) {
		this.eta = eta;
	}







	public int getPolso() {
		return polso;
	}







	public void setPolso(int polso) {
		this.polso = polso;
	}







	public int getFreqResp() {
		return freqResp;
	}







	public void setFreqResp(int freqResp) {
		this.freqResp = freqResp;
	}







	public int getTempCorp() {
		return tempCorp;
	}







	public void setTempCorp(int tempCorp) {
		this.tempCorp = tempCorp;
	}



	@Override
	public String toString() {
		return new String (this.idParameter + " " + this.sesso + " "+ this.altezza + " "+ this.peso + " "+ this.eta + " "+ this.polso + " "+ this.freqResp + " "+ this.tempCorp + " " );
	}



}