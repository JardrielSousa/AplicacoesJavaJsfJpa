package com.br.socialapi.socialapi.Escultador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.socialapi.socialapi.domain.DetalhesErro;
import com.br.socialapi.socialapi.service.exceptions.LivroNaoEncontradoExceptions;

@ControllerAdvice
public class ResoucesExceptionEscutador {
	@ExceptionHandler(LivroNaoEncontradoExceptions.class)
	public ResponseEntity<DetalhesErro> LivroNaoEncontradoException(LivroNaoEncontradoExceptions e , HttpServletRequest resquest){
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(404l);
		detalhesErro.setTitulo("O Livro não pode ser Encontrado!!!");
		detalhesErro.setTimeStamp(System.currentTimeMillis());
		detalhesErro.setMensagemDesenvoldor("http://erros.socialbooks.api.com/404");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
	}
}
