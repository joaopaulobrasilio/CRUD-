package SistemaVendas;

import java.util.ArrayList;

import java.util.List;

public class Pedidos {

	double valor;
	double quantidade;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	Produto produto = new Produto();

	private List<Produto> listaProdutos = new ArrayList<>();

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void adicionarProduto(Produto produto) {

		listaProdutos.add(produto);
		// produto = new Produto();
	}

	public void removerProduto(String nome) {
		for (int i = 0; i < listaProdutos.size(); i++) {
			Produto produto = listaProdutos.get(i);
			if (produto.getNome().equals(nome)) {
				listaProdutos.remove(i);

			}
		}

	}

	public void alterarProduto(Produto p) {
		for (int i = 0; i < listaProdutos.size(); i++) {
			Produto produto = listaProdutos.get(i);
			if (produto.getNome().equals(p.getNome())) {
				produto.setQuantidade(p.getQuantidade());
				produto.setValor(p.getValor());

			} 

		}

	}

	public double getTotal() {
		double total = 0;

		for (Produto produto : listaProdutos) {
			total = total + (produto.getQuantidade() * produto.getValor());
		}
		return total;
	}

	
}
