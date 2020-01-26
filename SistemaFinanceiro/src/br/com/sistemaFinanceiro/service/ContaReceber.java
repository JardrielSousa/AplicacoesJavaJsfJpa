package br.com.sistemaFinanceiro.service;

import br.com.sistemaFinanceiro.model.Cliente;
import br.com.sistemaFinanceiro.model.Conta;

public class ContaReceber extends Conta{
	private Cliente cliente;
	private String descricao ;
	private double valor ;
	private String dataVencimento;
	public ContaReceber() {
	    
	}
	public ContaReceber(Cliente cliente ,String descricao , double valor , String dataVencimento){
		this.cliente = cliente;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}
	
	public void receber() {
		System.out.println("=================================================");
		System.out.println("PAGAMENTO REALIZADO COM SUCESSO");
		System.out.println("Nome do Fornecedor:"+cliente.getNome());
		System.out.println("Descrição:"+descricao);
		System.out.println("Valor:"+valor);
		System.out.println("Data do Vencimento:"+dataVencimento);
		
	}
	
	public void cancelar() {
		if(valor<50000.00) {
			System.out.println("A conta(Receber) foi cancelada com sucesso !!!");
		}
	}

	@Override
	public void exibirDetalhes(Conta[] contas) {
	   
	    
	}
}
