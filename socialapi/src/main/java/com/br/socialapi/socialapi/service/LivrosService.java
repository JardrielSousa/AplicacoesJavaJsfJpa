package com.br.socialapi.socialapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.socialapi.socialapi.domain.Comentario;
import com.br.socialapi.socialapi.domain.Livro;
import com.br.socialapi.socialapi.repository.ComentarioRepository;
import com.br.socialapi.socialapi.repository.LivroRepository;
import com.br.socialapi.socialapi.service.exceptions.LivroNaoEncontradoExceptions;

@Service
public class LivrosService {
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	public Livro buscar(Long id) {
		Livro livro = livroRepository.findById(id).orElse(null);
		if(livro == null) {
			
		}
		return livro;
	}
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro) ;
	}
	public void deletar(Long id) {
		try {
			livroRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoExceptions("O livro não foi encontrado");
		}
	}
	public void atualizar(Livro livro) {
		verificaSeExiste(livro);
		livroRepository.save(livro);
	}
	private void verificaSeExiste(Livro livro) {
		buscar(livro.getId());
	}
	public void salvarComentario(Long livroId , Comentario comentario) {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		comentarioRepository.save(comentario);
	}
	public List<Comentario> listarComentario(Long livroId) {
		Livro livro = buscar(livroId);
		if(livro!=null) {
			return livro.getComentario();
		}else {
			return new ArrayList<Comentario>();
		}
	}
	
}
