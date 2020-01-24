package com.br.socialapi.socialapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.br.socialapi.socialapi.domain.Livro;
import com.br.socialapi.socialapi.repository.LivroRepository;
import com.br.socialapi.socialapi.service.exceptions.LivroNaoEncontradoExceptions;

public class LivrosService {
	@Autowired
	private LivroRepository livroRepository;
	
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
	
}
