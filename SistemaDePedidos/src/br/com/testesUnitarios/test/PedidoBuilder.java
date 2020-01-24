package br.com.testesUnitarios.test;

import br.com.testesUnitarios.desconto.CalcularFaixaDeDesconto;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoPrimeiraFaixa;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoSegundaFaixa;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoTerceiraFaixa;
import br.com.testesUnitarios.desconto.SemDesconto;
import br.com.testesUnitarios.entidades.ItemPedido;
import br.com.testesUnitarios.entidades.Pedido;

public class PedidoBuilder {
	private Pedido instancia;
	
	public PedidoBuilder() {
		CalcularFaixaDeDesconto calculadora = 
				new CalcularFaixaDeDescontoTerceiraFaixa(
						new CalcularFaixaDeDescontoSegundaFaixa(
								new CalcularFaixaDeDescontoPrimeiraFaixa(
										new SemDesconto(null))));
			instancia = new Pedido(calculadora);
	}
	public PedidoBuilder comItem(double valorUnitario,int quantidade) {
		instancia.adicionaItem(new ItemPedido("gerado", valorUnitario, quantidade));
		return this;
	}
	public Pedido construir() {
		return instancia;
	}
}
