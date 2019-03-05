package br.com.igormicael.model;

import java.io.Serializable;
import java.util.List;

public class Retorno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1024819501867161570L;
	
	private String mensagem;
	private String letra;
	private String palavraNaTela [];
	private String palavraEscolhida [];
	private int numeroTentativas;
	
	public Retorno() {
		this.numeroTentativas = 6;
	}
	
	public void esconderPalavra(String[] palavraEscolhida) {
		this.palavraNaTela = new String [palavraEscolhida.length];
	}
	
	public void descobrirLetras(List<IndiceLetra> indiceLetra) {
		
		if(indiceLetra != null && indiceLetra.size() > 0) {
			for (IndiceLetra il : indiceLetra) {
				palavraNaTela[il.getIndice()] = il.getLetra();
			}
		}
	}
	
	public void diminuirJogadas() {
		// decremento o numero de jogadas
		if(this.numeroTentativas > 0) {
			this.numeroTentativas = this.numeroTentativas -1;
		}
	}
	
	public boolean ehPossivelJogar() {
		if(this.numeroTentativas > 0) {
			return true;
		}else {
			return false;
		}
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String [] getPalavraNaTela() {
		return palavraNaTela;
	}

	public void setPalavraNaTela(String [] palavraNaTela) {
		this.palavraNaTela = palavraNaTela;
	}

	public int getNumeroTentativas() {
		return numeroTentativas;
	}

	public void setNumeroTentativas(int numeroTentativas) {
		this.numeroTentativas = numeroTentativas;
	}

	public String[] getPalavraEscolhida() {
		return palavraEscolhida;
	}

	public void setPalavraEscolhida(String[] palavraEscolhida) {
		this.palavraEscolhida = palavraEscolhida;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

}
