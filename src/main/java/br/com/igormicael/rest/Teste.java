package br.com.igormicael.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/message")
public class Teste {
	
	@GET
	public Response printMessage() {

		String result = "Restful example ";

		return Response.status(200).entity(result).build();

	}
}
