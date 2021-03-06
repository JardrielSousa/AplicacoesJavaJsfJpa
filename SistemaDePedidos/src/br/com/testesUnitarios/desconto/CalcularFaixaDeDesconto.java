package br.com.testesUnitarios.desconto;

public abstract class CalcularFaixaDeDesconto {
	private CalcularFaixaDeDesconto proximo;

	public CalcularFaixaDeDesconto(CalcularFaixaDeDesconto proximo) {
		super();
		this.proximo = proximo;
	}
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		if(desconto == -1)
			return proximo.desconto(valorTotal);
		return desconto;
	}
	protected abstract double calcular(double valorTotal);
}
