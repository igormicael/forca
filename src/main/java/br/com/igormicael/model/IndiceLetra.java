package br.com.igormicael.model;

public class IndiceLetra {
	
	private Integer indice;
	private String letra;
	
	public IndiceLetra(Integer indice, String letra) {
		super();
		this.indice = indice;
		this.letra = letra;
	}

	public IndiceLetra() {
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
}
