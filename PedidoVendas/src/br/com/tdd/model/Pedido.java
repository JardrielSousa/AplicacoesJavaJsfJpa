package br.com.tdd.model;

public class Pedido {
	private double valor;
	private Cliente cliente;
	
	public Pedido(double valor, Cliente cliente) {
		super();
		this.valor = valor;
		this.cliente = cliente;
	}
	public Pedido() {
		
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
