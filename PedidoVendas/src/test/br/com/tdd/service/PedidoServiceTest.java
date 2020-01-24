package test.br.com.tdd.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.com.tdd.model.Pedido;
import br.com.tdd.model.builder.PedidoBuilder;
import br.com.tdd.service.PedidoService;


public class PedidoServiceTest {
	@Test
	public void deveCalcularOImposto() {
		Pedido pedido = new PedidoBuilder().comValor(100.0)
				.para("jardriel", "jardriel@dev.com","99998888").
				construir();
		PedidoService pedidoService = new PedidoService();
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto , 0.0001);
	}
}
