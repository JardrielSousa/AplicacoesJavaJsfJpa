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
	
	
	
	public Fornecedor getFornecedor() {
	    return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
	    this.fornecedor = fornecedor;
	}
	public String getDescricao() {
	    return descricao;
	}
	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}
	public double getValor() {
	    return valor;
	}
	public void setValor(double valor) {
	    this.valor = valor;
	}
	public String getDataVencimento() {
	    return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
	    this.dataVencimento = dataVencimento;
	}
	public void pagar() {
		System.out.println("TRANSFERENCIA REALIZADO COM SUCESSO");
		System.out.println("Nome do Fornecedor:"+fornecedor.getNome());
		System.out.println("Descrição:"+descricao);
		System.out.println("Valor:"+valor);
		System.out.println("Data do Vencimento:"+dataVencimento);
		
	}
	@Override
	public void exibirDetalhes(Conta[] contas) {
	
	}
	
}
