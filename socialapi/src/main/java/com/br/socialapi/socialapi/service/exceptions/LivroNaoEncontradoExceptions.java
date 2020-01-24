package com.br.socialapi.socialapi.service.exceptions;

public class LivroNaoEncontradoExceptions extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8310217324555654595L;
	public LivroNaoEncontradoExceptions(String mensagem) {
		super(mensagem);
	}
	public LivroNaoEncontradoExceptions(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
