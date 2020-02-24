package com.br.socialapi.socialapi.service.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8310217324555654595L;
	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
