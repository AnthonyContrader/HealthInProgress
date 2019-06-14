package it.contrader.dto;


public class ParametersDTO {

	private int idParameter;
	private String sesso;
	private int altezza;
	private int peso;
	private  int eta;
	private int polso;
	private int freqResp;
	private int tempCorp;
	
	public ParametersDTO() {
		super();
	}

	public ParametersDTO( String sesso, int altezza, int peso, int eta, int polso, int freqResp,
			int tempCorp) {
		super();
		
		this.sesso = sesso;
		this.altezza = altezza;
		this.peso = peso;
		this.eta = eta;
		this.polso = polso;
		this.freqResp = freqResp;
		this.tempCorp = tempCorp;
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

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
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
	