package br.com.alura.loja.config;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
	private static ResourceConfig config;
	private static URI uri;
	private static HttpServer server;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		config = new ResourceConfig().packages("br.com.alura.loja");
		uri = URI.create("http://localhost:8080/");
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Server started");
		System.in.read();
		server.stop();
		System.out.println("Server stoped");
    }

}
