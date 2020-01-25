package br.com.sistemaFinanceiro.service;

import br.com.sistemaFinanceiro.model.Conta;
import br.com.sistemaFinanceiro.model.Fornecedor;

public class ContaPagar extends  Conta {
	
	private Fornecedor fornecedor;
	private String descricao;
	private double valor;
	private String dataVencimento;
	public ContaPagar() {
		
	}
	public ContaPagar(Fornecedor fornecedor,String descricao , double valor , String dataVencimento) {
		this.fornecedor = fornecedor;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}
	
	public void pagar() {
		System.out.println("TRANSFERENCIA REALIZADO COM SUCESSO");
		System.out.println("Nome do Fornecedor:"+fornecedor.getNome());
		System.out.println("Descrição:"+descricao);
		System.out.println("Valor:"+valor);
		System.out.println("Data do Vencimento:"+dataVencimento);
		
	}
}
