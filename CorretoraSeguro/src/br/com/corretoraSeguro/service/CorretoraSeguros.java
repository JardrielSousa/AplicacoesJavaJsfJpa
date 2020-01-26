package br.com.corretoraSeguro.service;

import br.com.corretoraSeguro.Seguravel;

public class CorretoraSeguros {
    public Double fazerPropostaSeguro(Seguravel objetoSeguravel) {
	System.out.println("-------------------------------");
	System.out.println("Corretora de Seguros - Proposta");
	System.out.println("-------------------------------");
	System.out.println(objetoSeguravel.obterDescricao());
	System.out.println("Valor da apólice: " + objetoSeguravel.CalcularValorApolice());
	System.out.println("-------------------------------");
	return objetoSeguravel.CalcularValorApolice();
    }
}
    
