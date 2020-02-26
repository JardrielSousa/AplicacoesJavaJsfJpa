package com.br.socialapi.socialapi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Livro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1795577923880663047L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "O Campo nome não pode ser vazio")
	private String nome;
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date publicacao;
	@JsonInclude(Include.NON_NULL)
	private String editora;
	@JsonInclude(Include.NON_NULL)
	@Size(max = 1500)
	private String resumo;
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios ;
	@ManyToOne
	@JoinColumn(name="autorId")
	@JsonInclude(Include.NON_NULL)
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
