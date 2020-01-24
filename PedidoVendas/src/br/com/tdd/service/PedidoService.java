package br.com.tdd.service;

import br.com.tdd.model.Pedido;

public class PedidoService {

	public double lancar(Pedido pedido) {
		return pedido.getValor() * 0.1;
	}

}
