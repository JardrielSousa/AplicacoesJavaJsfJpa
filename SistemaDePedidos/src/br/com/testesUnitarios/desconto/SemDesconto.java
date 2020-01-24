package br.com.testesUnitarios.desconto;

public class SemDesconto extends CalcularFaixaDeDesconto {

	public SemDesconto(CalcularFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
