package br.com.corretoraSeguro.main;

import br.com.corretoraSeguro.model.Barco;
import br.com.corretoraSeguro.model.Carro;
import br.com.corretoraSeguro.model.Imovel;
import br.com.corretoraSeguro.model.Notebook;
import br.com.corretoraSeguro.service.CorretoraSeguros;

public class Principal {

    public static void main(String[] args) {
	CorretoraSeguros corretora = new CorretoraSeguros();
	Carro carro = new Carro(12.000, 97);
	Imovel imovel = new Imovel(40.000, 70);
	Barco barco = new Barco(100.000, 100);
	Notebook notebook = new Notebook(3.000, 2020);
	
	corretora.fazerPropostaSeguro(carro);	
	corretora.fazerPropostaSeguro(imovel);
	corretora.fazerPropostaSeguro(barco);
	corretora.fazerPropostaSeguro(notebook);
    }

}
