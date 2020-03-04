package com.br.socialbooksClient.domain;

public class DetalhesErro {
	private String titulo ;
	private Long status;
	private Long timeStamp;
	private String mensagemDesenvoldor;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMensagemDesenvoldor() {
		return mensagemDesenvoldor;
	}
	public void setMensagemDesenvoldor(String mensagemDesenvoldor) {
		this.mensagemDesenvoldor = mensagemDesenvoldor;
	}
	
	
}
