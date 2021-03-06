package br.com.corretoraSeguro.model;

import br.com.corretoraSeguro.Seguravel;

public class Carro implements Seguravel{
    private Double valorMercado;
    private int anoFabricado;
    
    public Carro(Double valorMercado, int anoFabricado) {
	super();
	this.valorMercado = valorMercado;
	this.anoFabricado = anoFabricado;
    }

    @Override
    public double CalcularValorApolice() {
	double valorApolice = this .valorMercado * 0.04;
	if (this.getAnoFabricado() < 2000) {
	valorApolice = valorApolice * 0.90;
	}
	return valorApolice;
    }

    @Override
    public String obterDescricao() {
	return "Carro ano " + this.getAnoFabricado() + " com valor de mercado "
		+ this .getValorMercado();
    }

    public Double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(Double valorMercado) {
        this.valorMercado = valorMercado;
    }

    public int getAnoFabricado() {
        return anoFabricado;
    }

    public void setAnoFabricado(int anoFabricado) {
        this.anoFabricado = anoFabricado;
    }
   
    
}
