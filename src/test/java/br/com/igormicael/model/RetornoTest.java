package br.com.igormicael.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RetornoTest {

	@Test
	public void testarPalavraNaTela() {

		Retorno r = new Retorno();
		String [] palavra = new String[4];
		
		palavra[0] = "i";
		palavra[0] = "g";
		palavra[0] = "o";
		palavra[0] = "r";
		
		r.esconderPalavra(palavra);
		
		String palavraNaTela [] = r.getPalavraNaTela();
		
		assertEquals(4, palavraNaTela.length);
		
	}
}
