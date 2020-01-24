package br.com.testesUnitarios.desconto;

public class CalcularFaixaDeDescontoTerceiraFaixa extends CalcularFaixaDeDesconto {

	public CalcularFaixaDeDescontoTerceiraFaixa(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		 if(valorTotal > 1000.0) {
				return valorTotal * 0.08;
			}
		return -1;
	}

}
