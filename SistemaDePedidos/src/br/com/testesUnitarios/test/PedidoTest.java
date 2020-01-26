package br.com.testesUnitarios.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.testesUnitarios.desconto.CalcularFaixaDeDesconto;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoPrimeiraFaixa;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoSegundaFaixa;
import br.com.testesUnitarios.desconto.CalcularFaixaDeDescontoTerceiraFaixa;
import br.com.testesUnitarios.desconto.SemDesconto;
import br.com.testesUnitarios.entidades.ItemPedido;
import br.com.testesUnitarios.entidades.Pedido;
import br.com.testesUnitarios.entidades.ResumoPedido;

/*
 * A classe de teste foi criada para Garantir a adição de um Item ao Pedido
 * e em quais momentos ele terá desconto
 *
 * @Autor: Jardriel Sousa
 * @date : 04/09/2019
 */

public class PedidoTest {
	private PedidoBuilder pedido;

	/*
	 * Teste basico onde é adicionado um Item ao pedido , e com quantidade *
	 * valorPedido faz a verificação do desconto
	 * 
	 * @Autor:Jardriel Sousa
	 * 
	 * @date :04/09/2019
	 */

	@Before
	public void setUp() {
		pedido = new PedidoBuilder();
	}

	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.construir().resumo();
		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	}

	@Test
	public void adicionarPedidoValorTotalZeradoComDesconto() {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void adicionarPedidoValorSemDesconto() {
		pedido.comItem(5.0,5);
		assertResumoPedido(25.0, 0.0);
	}

	@Test
	public void adicionarDoisPedidosSemDesconto(){
		pedido.comItem(5.0, 4).comItem(5.0, 2);
		assertResumoPedido(30.0, 0.0);
	}

	@Test
	public void adicionarDescontoNa1Faixa(){
		pedido.comItem(20.0, 20);
		assertResumoPedido(400.0, 16.0);
	}

	@Test
	public void adicionarDescontoNa2Faixa(){
		pedido.comItem(15.0, 30).comItem(15.0, 30);
		assertResumoPedido(900.0, 54.0);
	}

	@Test
	public void adicionarDescontoNa3Faixa(){
		pedido.comItem(15.0, 30).comItem(15.0, 30).comItem(10.0, 30);
		assertResumoPedido(1200.0, 96.0);
	}
	@Test(expected = QuantidadeItensInvalida.class)
	public void naoAceitarItensComQuantidadesNeGativas() throws Exception {
		pedido.comItem(5.0, -10);
	}
}
