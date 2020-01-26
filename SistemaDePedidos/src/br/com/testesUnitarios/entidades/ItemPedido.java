package br.com.testesUnitarios.entidades;

public class ItemPedido {
	private String nomeProduto;
	private double valorProduto;
	private int quantidade;

	public ItemPedido(String nomeProduto, double valorProduto, int quantidade) {
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.quantidade = quantidade;
	}
	public ItemPedido() {
		super();
	}
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}