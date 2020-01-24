package br.com.algaworks.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.algaworks.model.Passageiro;
import br.com.algaworks.model.TipoPassageiro;
import br.com.algaworks.model.Voo;

public class PrecoPassagemServiceTest {
	PrecoPassagemService precoPassagemService ;
	@Before 
	public void setUp() {
		precoPassagemService = new PrecoPassagemService();
	}
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro , voo);
		assertEquals(esperado,valor , 0.0001);
	}
	@Test
	public void devePermitirCalcularValor() throws Exception {
		Passageiro passageiro = new Passageiro("jardriel", TipoPassageiro.gold);
		Voo voo = new Voo("sao paulo", "Rio de janeiro",100.0);
		double valor = precoPassagemService.calcular(passageiro , voo);
	}
	@Test
	public void deveCalcularValorDaPassagemParaPassageirogoldComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("jardriel", TipoPassageiro.gold);
		Voo voo = new Voo("sao paulo", "Rio de janeiro",100.0);
		assertValorPassagem(passageiro, voo, 90.0);
		
	}
	@Test
	public void deveCalcularValorDaPassagemParaPassageirogoldComValorACimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("jardriel", TipoPassageiro.gold);
		Voo voo = new Voo("sao paulo", "Rio de janeiro",600.0);
		assertValorPassagem(passageiro, voo, 510.0);
		
	}
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroSilverComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("jardriel", TipoPassageiro.silver);
		Voo voo = new Voo("sao paulo", "Rio de janeiro",100.0);
		assertValorPassagem(passageiro, voo, 94.0);
		
	}
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroSilverComValorACimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("jardriel", TipoPassageiro.silver);
		Voo voo = new Voo("sao paulo", "Rio de janeiro",800.0);
		assertValorPassagem(passageiro, voo, 720.0);
		
	}
	
}
