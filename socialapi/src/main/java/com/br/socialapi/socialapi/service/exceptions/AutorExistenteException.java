package com.br.socialapi.socialapi.service.exceptions;

public class AutorExistenteException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8310217324555654595L;
	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
