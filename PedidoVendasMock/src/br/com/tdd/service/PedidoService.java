package br.com.tdd.service;

import br.com.tdd.email.NotificarEmail;
import br.com.tdd.model.Pedido;
import br.com.tdd.repository.Pedidos;
import br.com.tdd.sms.NotificarSMS;

public class PedidoService {

	private Pedidos pedidos;
	private NotificarEmail notificarEmail;
	private NotificarSMS notificarSms;
	public PedidoService(Pedidos pedido , NotificarEmail notificarEmail,NotificarSMS notificarSms) {
		this.pedidos = pedido;
		this.notificarEmail = notificarEmail;
		this.notificarSms = notificarSms;
	}
	
	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		pedidos.salvar(pedido);
		notificarEmail.enviar(pedido);
		notificarSms.notificar(pedido);
		return imposto;
	}

}
