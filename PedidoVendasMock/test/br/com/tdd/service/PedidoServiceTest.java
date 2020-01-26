package br.com.tdd.service;

import static org.junit.Assert.assertEquals;

import javax.management.loading.PrivateClassLoader;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.tdd.email.NotificarEmail;
import br.com.tdd.model.Pedido;
import br.com.tdd.model.builder.PedidoBuilder;
import br.com.tdd.repository.Pedidos;
import br.com.tdd.sms.NotificarSMS;

public class PedidoServiceTest {

	private PedidoService pedidoService;
	@Mock
	Pedidos pedidos;
	@Mock
	NotificarEmail notificarEmail;
	@Mock
	NotificarSMS notificarSms;
	private Pedido pedido;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		pedidoService = new PedidoService(pedidos,notificarEmail,notificarSms);
		pedido = new PedidoBuilder().
				para("jardriel", "jardriel.redes18@mail.com", "985528894").
				comValor(100.0).construir();
	}
	
	@Test
	public void test01DeveCalcularImposto() {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0,imposto,0.001);
	}
	@Test
	public void test02DeveSalvarNoBanco() {
	    pedidoService.lancar(pedido);
		Mockito.verify(pedidos).salvar(pedido);
	}
	@Test
	public void test03DeveNotificarEmail() {
		pedidoService.lancar(pedido);
		Mockito.verify(notificarEmail).enviar(pedido);
	}
	@Test
	public void test04DeveNotificarSms() {
		pedidoService.lancar(pedido);
		Mockito.verify(notificarSms).notificar(pedido);
	}
}
