package br.com.corretoraSeguro.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.corretoraSeguro.model.Barco;
import br.com.corretoraSeguro.model.Carro;
import br.com.corretoraSeguro.model.Imovel;
import br.com.corretoraSeguro.model.Notebook;
import br.com.corretoraSeguro.service.CorretoraSeguros;

public class CorretoraSeguroTest {
    private CorretoraSeguros corretora;
    private Carro carro;
    private Imovel imovel;
    private Barco barco;
    private Notebook notebook;

    @Before
    public void init() {
	corretora = new CorretoraSeguros();
	carro = new Carro(12.000, 97);
	imovel = new Imovel(40.000, 70);
	barco = new Barco(100.000, 100);
	notebook = new Notebook(3.000, 2020);
    }

    @Test
    public void test01Carro() {
	Double valor = corretora.fazerPropostaSeguro(carro);
	assertEquals(0.432, valor, 0.00);
    }

    @Test
    public void test02Imovel() {
	Double valor = corretora.fazerPropostaSeguro(imovel);
	assertEquals(35.12, valor, 0.00);
    }

    @Test
    public void test03Barco() {
	Double valor = corretora.fazerPropostaSeguro(barco);
	assertEquals(50.3, valor, 0.00);
    }

    @Test
    public void test04Notebook() {
	Double valor = corretora.fazerPropostaSeguro(notebook);
	assertEquals(0.12, valor, 0.00);
    }
}
