package br.com.algaworks.service;

import br.com.algaworks.model.Voo;

public class PrecoPassagemgold implements CalcularPrecoPassagem{

	@Override
	public double calcular(Voo voo) {
		if(voo.getPreco() > 500)
			return calcularValorAcimaDoLimite(voo);
		return calcularValorAbaixoDoLimite(voo);	
	}

	private double calcularValorAbaixoDoLimite(Voo voo) {
		return voo.getPreco() * 0.9;
	}

	private double calcularValorAcimaDoLimite(Voo voo) {
		return voo.getPreco() * 0.85;
	}

}
