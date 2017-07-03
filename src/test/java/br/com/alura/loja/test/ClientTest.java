package br.com.alura.loja.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClientTest {
	
	private String body;
	private Client client;
	private WebTarget webTarget;
	private Gson gson;
	private final String URL = "https://appfirebaserest.firebaseio.com/";
	private final String URI = "ocorrencias.json";
	
	@Test
	public void testURIConnection() {
		client = ClientBuilder.newClient();
		webTarget = client.target("http://www.mocky.io");
		body = webTarget.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		Assert.assertTrue(body.contains("<rua>Rua Vergueiro 3185"));
		System.out.println(body);
	}

}
