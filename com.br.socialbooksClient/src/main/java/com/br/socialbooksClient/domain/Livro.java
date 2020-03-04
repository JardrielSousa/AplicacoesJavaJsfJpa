package com.br.socialbooksClient.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Livro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1795577923880663047L;
	private Long id;
	private String nome;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date publicacao;
	private String editora;
	private String resumo;
	private List<Comentario> comentarios ;
	private Autor autor;
	
	public Livro() {
		
	}
	public Livro(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Comentario> getComentario() {
		return comentarios;
	}
	public void setComentario(List<Comentario> comentario) {
		this.comentarios = comentario;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
