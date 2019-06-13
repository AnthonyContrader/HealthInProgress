package it.contrader.model;

public class Device {
	private int Iddevice;
	private String nome;
	
	
	public Device() {}


	public Device(String nome) {
		super();
		this.nome = nome;
	}


	public int getIddevice() {
		return Iddevice;
	}


	public void setIddevice(int iddevice) {
		Iddevice = iddevice;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
}
	