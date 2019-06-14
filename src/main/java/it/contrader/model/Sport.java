package it.contrader.model;

public class Sport {
	private int Idsport;
	private String nome;
	private int tipo;
	private int durata;
	
	public Sport() {}

	public Sport(String nome, int tipo, int durata) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.durata = durata;
	}

	public int getIdsport() {
		return Idsport;
	}

	public void setIdsport(int idsport) {
		Idsport = idsport;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	
	
}
	