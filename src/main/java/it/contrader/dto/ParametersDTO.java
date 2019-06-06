package it.contrader.dto;

public class ParametersDTO {

	private int idParameter;
	private String nome;
	private String sesso;
	private String dispositivo;
	private int userId;
	private double altezza;
	private double peso;
	private int eta;
	private int polso;
	private int freqResp;
	private int tempCorp;
	private int ossSang;
	
	public ParametersDTO()
	{
		
	}

	public ParametersDTO(int idParameter,String nome, String sesso, String dispositivo, double altezza, double peso, int eta, int polso,
			int freqResp, int tempCorp, int ossSang) {
		
		this.idParameter=idParameter;
		this.nome = nome;
		this.sesso = sesso;
		this.dispositivo = dispositivo;
		this.altezza = altezza;
		this.peso = peso;
		this.eta = eta;
		this.polso = polso;
		this.freqResp = freqResp;
		this.tempCorp = tempCorp;
		this.ossSang = ossSang;
	}
	

	public int getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(int idParameter) {
		this.idParameter = idParameter;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
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

	public int getOssSang() {
		return ossSang;
	}

	public void setOssSang(int ossSang) {
		this.ossSang = ossSang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(altezza);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dispositivo == null) ? 0 : dispositivo.hashCode());
		result = prime * result + eta;
		result = prime * result + freqResp;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ossSang;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + polso;
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		result = prime * result + tempCorp;
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
		ParametersDTO other = (ParametersDTO) obj;
		if (Double.doubleToLongBits(altezza) != Double.doubleToLongBits(other.altezza))
			return false;
		if (dispositivo == null) {
			if (other.dispositivo != null)
				return false;
		} else if (!dispositivo.equals(other.dispositivo))
			return false;
		if (eta != other.eta)
			return false;
		if (freqResp != other.freqResp)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ossSang != other.ossSang)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (polso != other.polso)
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (tempCorp != other.tempCorp)
			return false;
		return true;
	}
	

}
