package br.com.igormicael.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.igormicael.model.IndiceLetra;
import br.com.igormicael.model.Retorno;


@Path("/jogo")
public class JogoResource {

	private List<String> listaPalavras;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response iniciar() {
		
		listaPalavras = 
				Arrays.asList(
						"igor", "cleo",
						"batista", "lucia",
						"julio","nergia",
						"iury", "ingrid",
						"erica","allison");
		
		Retorno retorno = new Retorno();
		retorno.setPalavraEscolhida(escolherPalavra());

		retorno.esconderPalavra(retorno.getPalavraEscolhida());

		return Response.status(200).entity(retorno).build();
	}

	public String [] escolherPalavra() {
		int posicao = new Random().ints(1, 0, 10).findFirst().getAsInt();
		
		String palavra = listaPalavras.get(posicao);

		return palavra.split("");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response darPaupite(Retorno retorno ) {
		
		if(retorno.ehPossivelJogar()) {
			
			retorno.setMensagem(null);
			
			Boolean errou = verificarPaupite(retorno);
			
			if(!verificarSeGanhou(retorno)) {
				if(retorno.getNumeroTentativas() == 0) {
					retorno.setMensagem("Você perdeu o jogo!");
				}else {
					if(errou) {
						retorno.setMensagem("Você errou o palpite!");
						retorno.diminuirJogadas();
					}
				}
			}
		}else {
			
			retorno.setMensagem("Você perdeu o jogo!");
			
		}
		
		return Response.status(200).entity(retorno).build();
	}
	
	private Boolean verificarPaupite(Retorno retorno) {
		
		List<IndiceLetra> indiceLetra = new ArrayList<>();
		
		Boolean errou = true;
		
		String letra = retorno.getLetra();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < letra.length(); i++) {
			char charAt = letra.charAt(i);
			sb.setLength(0);
			sb.append(charAt);
			
			for (Integer j = 0; j < retorno.getPalavraEscolhida().length; j++) {
				
				if(retorno.getPalavraEscolhida()[j].equalsIgnoreCase(sb.toString())) {
					indiceLetra.add( new IndiceLetra(j, sb.toString()));
				}
			}
		}
		
		if(indiceLetra.size() > 0) {
			retorno.descobrirLetras(indiceLetra);
			errou = false;
			retorno.setMensagem(null);
		}
		
		return errou;
		
	}

	private Boolean verificarSeGanhou(Retorno retorno) {
		
		Boolean listasIguais = true;
		
		// caso as duas listas estiverem preenchidas e com valores iguais
		for (int i = 0; i < retorno.getPalavraEscolhida().length; i++) {
			if(!retorno.getPalavraEscolhida()[i].equalsIgnoreCase( 
					retorno.getPalavraNaTela()[i])) {
				listasIguais = false;
				break;
			}
		}
		
		// caso a quantidade de tentativas seja >= 0
		if(retorno.getNumeroTentativas() > 0 && listasIguais) {
			retorno.setMensagem("Você venceu o jogo!");
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
		
		
	}

	public List<String> getListaPalavras() {
		return listaPalavras;
	}

	public void setListaPalavras(List<String> listaPalavras) {
		this.listaPalavras = listaPalavras;
	}
	
}
