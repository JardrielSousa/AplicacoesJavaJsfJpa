package br.com.algaworks.service;

import br.com.algaworks.model.Voo;

public class PrecoPassagemSilver implements CalcularPrecoPassagem{

	@Override
	public double calcular(Voo voo) {
		if(voo.getPreco()> 700)
			return voo.getPreco() * 0.9;
		return voo.getPreco() * 0.94;	
	}

}
