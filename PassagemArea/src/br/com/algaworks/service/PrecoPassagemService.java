package br.com.algaworks.service;

import br.com.algaworks.model.Passageiro;
import br.com.algaworks.model.Voo;

public class PrecoPassagemService {
	public static double calcular(Passageiro passageiro, Voo voo) {
		return passageiro.getTipoPassageiro().getCalcularPrecoPassagem().calcular(voo);
	}

}
