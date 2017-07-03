package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import br.com.alura.loja.entity.Cart;
import br.com.alura.loja.entity.Product;

public class CartDAO {
	
	private static Map<Long, Cart> banco = new HashMap<Long, Cart>();
	private static AtomicLong contador = new AtomicLong(1);
	
	static {
		Product videogame = new Product(6237, "Videogame 4", 4000, 1);
		Product esporte = new Product(3467, "Jogo de esporte", 60, 2);
		Cart carrinho = new Cart()
								.adiciona(videogame)
								.adiciona(esporte)
								.para("Rua Vergueiro 3185, 8 andar", "S�o Paulo")
								.setId(1l);
		banco.put(1l, carrinho);
	}
	
	public void save(Cart carrinho) {
		long id = contador.incrementAndGet();
		carrinho.setId(id);
		banco.put(id, carrinho);
	}
	
	public Cart find(Long id) {
		return banco.get(id);
	}
	
	public Cart remove(long id) {
		return banco.remove(id);
	}

}
