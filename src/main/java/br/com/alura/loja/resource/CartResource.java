package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.alura.loja.dao.CartDAO;
import br.com.alura.loja.entity.Cart;
import br.com.alura.loja.util.Serializer;

@Path("carts")
public class CartResource {
	
	private String json;
	private Cart cart;
	private CartDAO cartDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String find(){
		cart = new Cart();
		cartDAO = new CartDAO();
		cart = cartDAO.find(1l);
		json = Serializer.toJSON(cart);
		return json;
	}
	
}
