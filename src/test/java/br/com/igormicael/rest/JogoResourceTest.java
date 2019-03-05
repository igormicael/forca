package br.com.igormicael.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import br.com.igormicael.rest.JogoResource;

public class JogoResourceTest {

	@Test
	public void escolherPalavra() {
		JogoResource jr = new JogoResource();
		
		String [] palavraEscolhida = jr.escolherPalavra();
		
		String palavra = "";
		for (int i = 0; i < palavraEscolhida.length; i++) {
			 palavra += palavraEscolhida[i];
		}
		
		assertTrue(jr.getListaPalavras().contains(palavra));
		assertTrue(palavraEscolhida.length > 0);
	}
}
