package br.com.testesUnitarios.entidades;

import java.util.ArrayList;
import java.util.List;

import br.com.testesUnitarios.desconto.CalcularFaixaDeDesconto;
import br.com.testesUnitarios.test.QuantidadeItensInvalida;

public class Pedido {
	
	private List<ItemPedido> itens = new ArrayList<>();
	private CalcularFaixaDeDesconto calcularFaixaDeDesconto;
	
	public Pedido(CalcularFaixaDeDesconto calcularFaixaDeDesconto) {
		this.calcularFaixaDeDesconto = calcularFaixaDeDesconto;
	}

	public void adicionaItem(ItemPedido itempedido) {
		validadaQuantidadeItens(itempedido);
		itens.add(itempedido);
	}

	private void validadaQuantidadeItens(ItemPedido itempedido) {
		if(itempedido.getQuantidade() < 0)
			throw new QuantidadeItensInvalida();
	}

	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i->i.getValorProduto()* i.getQuantidade()).sum();
		Double desconto = calcularFaixaDeDesconto.desconto(valorTotal);
		return new ResumoPedido(valorTotal, desconto);
	}

}
