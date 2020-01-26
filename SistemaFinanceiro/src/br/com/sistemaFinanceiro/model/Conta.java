package br.com.sistemaFinanceiro.model;

import br.com.sistemaFinanceiro.enumerador.SituacaoConta;

public abstract class Conta {
    
	public String descricao;
	public double valor;
	public String dataVencimento;
	
	SituacaoConta situacaoConta;
	public Conta() {
		
	}
	public void cancelar() {
		System.out.println("Conta cancelada com sucesso!!");
	}
	public String getConta() {
		return descricao;
	}
	public void setConta(String conta) {
		this.descricao = conta;
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
	
	public abstract void exibirDetalhes(Conta[] contas);
}
