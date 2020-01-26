package br.com.sistemaFinanceiro.service;

import br.com.sistemaFinanceiro.model.Conta;

public class RelatorioContas {
    public void exibirContas(Conta[] contas) {
	ContaPagar contaPagar = new ContaPagar();
	contaPagar.exibirDetalhes(contas);
	ContaReceber contaReceber = new ContaReceber();
	contaReceber.exibirDetalhes(contas);
    }
}
