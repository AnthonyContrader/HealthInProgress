package it.contrader.model;

public class Parameters {
	  int Idparameter;
	  String Nome ;
	  String sesso;
	  String Dispositivo;
	  int id_user;
	  double altezza;
	  double peso;
	  int eta;
	  int polso;
	  int freq_resp;
	  int temp_corp;
	  int oss_sang;
	  
	public int getIdparameter() {
		return Idparameter;
	}
	public void setIdparameter(int idparameter) {
		Idparameter = idparameter;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getDispositivo() {
		return Dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	public int getFreq_resp() {
		return freq_resp;
	}
	public void setFreq_resp(int freq_resp) {
		this.freq_resp = freq_resp;
	}
	public int getTemp_corp() {
		return temp_corp;
	}
	public void setTemp_corp(int temp_corp) {
		this.temp_corp = temp_corp;
	}
	public int getOss_sang() {
		return oss_sang;
	}
	public void setOss_sang(int oss_sang) {
		this.oss_sang = oss_sang;
	}
	  
	  
}