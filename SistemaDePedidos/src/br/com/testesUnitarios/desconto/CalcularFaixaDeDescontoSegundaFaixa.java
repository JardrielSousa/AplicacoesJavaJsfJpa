package br.com.testesUnitarios.desconto;

public class CalcularFaixaDeDescontoSegundaFaixa extends CalcularFaixaDeDesconto {

	public CalcularFaixaDeDescontoSegundaFaixa(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 800.0 && valorTotal <=1000.0) {
			return valorTotal * 0.06;
		}
		return -1;
	}
	
}
	
