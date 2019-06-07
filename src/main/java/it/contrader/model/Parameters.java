package it.contrader.model;

public class Parameters {
	private int idParameter;
	
	private String sesso;
	
    private int userId;
	private double altezza;
	private double peso;
	private int eta;
	private int polso;
	private int freqResp;
	private int tempCorp;

	
	public Parameters() {
		
	}
	public Parameters(String nome, String sesso, String dispositivo, double altezza,
			double peso, int eta, int polso, int freqResp, int tempCorp, int ossSang) {
		this.idParameter = idParameter;
 
		this.sesso = sesso;
 
		this.userId = userId;
		this.altezza = altezza;
		this.peso = peso;
		this.eta = eta;
		this.polso = polso;
		this.freqResp = freqResp;
		this.tempCorp = tempCorp;
	 
	}







	@Override
	public String toString() {
		return "Parameters [idParameter=" + idParameter +  ", sesso=" + sesso + ", dispositivo="
			+ ", altezza=" + altezza + ", peso=" + peso + ", eta=" + eta
				+ ", polso=" + polso + ", freqResp=" + freqResp + ", tempCorp=" + tempCorp + "ù]";
	}







	public int getIdParameter() {
		return idParameter;
	}



	public void setIdParameter(int idParameter) {
		this.idParameter = idParameter;
	}







	public void setNome(String nome) {
		nome = nome;
	}



	public String getSesso() {
		return sesso;
	}



	public void setSesso(String sesso) {
		this.sesso = sesso;
	}




	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
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



	


}