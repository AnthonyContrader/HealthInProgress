package it.contrader.model;

public class Sport {
	private int idsport;
	private String nome;
	private String tipo;
	private Double durata;
	
	public Sport() {}
	
	public Sport(String nome, String tipo, Double durata) {
		this.nome=nome;
		this.tipo=tipo;
	    this.durata=durata;
	    
	 
	    
	}

	/**
	 * @return the idsport
	 */
	public int getIdsport() {
		return idsport;
	}

	/**
	 * @param idsport the idsport to set
	 */
	public void setIdsport(int idsport) {
		this.idsport = idsport;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the durata
	 */
	public Double getDurata() {
		return durata;
	}

	/**
	 * @param durata the durata to set
	 */
	public void setDurata(Double durata) {
		this.durata = durata;
	}
	}
	
	