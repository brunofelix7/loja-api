package br.com.alura.loja.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Cart {

	private List<Product> produtos = new ArrayList<Product>();
	private String rua;
	private String cidade;
	private long id;

	public Cart adiciona(Product produto) {
		produtos.add(produto);
		return this;
	}

	public Cart para(String rua, String cidade) {
		this.rua = rua;
		this.cidade = cidade;
		return this;
	}

	public Cart setId(long id) {
		this.id = id;
		return this;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public long getId() {
		return id;
	}
	
	public void remove(long id) {
		for (Iterator iterator = produtos.iterator(); iterator.hasNext();) {
			Product produto = (Product) iterator.next();
			if(produto.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public void troca(Product produto) {
		remove(produto.getId());
		adiciona(produto);
	}

	public void trocaQuantidade(Product produto) {
		for (Iterator iterator = produtos.iterator(); iterator.hasNext();) {
			Product p = (Product) iterator.next();
			if(p.getId() == produto.getId()) {
				p.setQuantidade(produto.getQuantidade());
				return;
			}
		}
	}
	
	public List<Product> getProdutos() {
		return produtos;
	}

}
