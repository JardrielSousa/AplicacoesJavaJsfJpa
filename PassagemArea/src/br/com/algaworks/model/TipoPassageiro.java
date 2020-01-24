package br.com.algaworks.model;

import br.com.algaworks.service.CalcularPrecoPassagem;
import br.com.algaworks.service.PrecoPassagemSilver;
import br.com.algaworks.service.PrecoPassagemgold;

public enum TipoPassageiro {
	gold(new PrecoPassagemgold()) , silver(new PrecoPassagemSilver());
	
	CalcularPrecoPassagem calcularPrecoPassagem;
	
	TipoPassageiro(CalcularPrecoPassagem calcularPrecoPassagem) {
		this.calcularPrecoPassagem = calcularPrecoPassagem;
	}

	public CalcularPrecoPassagem getCalcularPrecoPassagem() {
		return calcularPrecoPassagem;
	}

	public void setCalcularPrecoPassagem(CalcularPrecoPassagem calcularPrecoPassagem) {
		this.calcularPrecoPassagem = calcularPrecoPassagem;
	}
	
	
}
