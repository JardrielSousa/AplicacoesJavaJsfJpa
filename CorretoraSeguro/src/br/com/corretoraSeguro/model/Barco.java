package br.com.corretoraSeguro.model;

import br.com.corretoraSeguro.Seguravel;

public class Barco implements Seguravel{
    private double valorMercado;
    private int areaConstruida;
    public Barco(double valorMercado, int areaConstruida) {
	super();
	this.valorMercado = valorMercado;
	this.areaConstruida = areaConstruida;
    }
    public double getValorMercado() {
        return valorMercado;
    }
    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }
    public int getAreaConstruida() {
        return areaConstruida;
    }
    public void setAreaConstruida(int areaConstruida) {
        this.areaConstruida = areaConstruida;
    }
    @Override
    public double CalcularValorApolice() {
	double valorApolice = this .valorMercado * 0.003;
	valorApolice = valorApolice + (areaConstruida * 0.5);
	return valorApolice;
    }
    @Override
    public String obterDescricao() {
	return "Descrições do Barco" + this .areaConstruida + "m2 e valor de mercado "+ this.valorMercado;
    }
    
}
