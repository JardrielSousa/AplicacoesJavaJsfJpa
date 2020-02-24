package com.br.socialapi.socialapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.socialapi.socialapi.domain.Autor;
import com.br.socialapi.socialapi.repository.AutoresRepository;
import com.br.socialapi.socialapi.service.exceptions.AutorExistenteException;
import com.br.socialapi.socialapi.service.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	@Autowired
	private AutoresRepository autoresRepository;

	public List<Autor> listar() {
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		if (autor.getId() != null) {
			Autor a = autoresRepository.getOne(autor.getId());
			if (a != null) {
				throw new AutorExistenteException("O Autor já existe!!!");
			}
		}
		return autoresRepository.save(autor);
	}
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.getOne(id);
		if(autor == null) {
			throw new AutorNaoEncontradoException("Autor não encontrado !!!");
		}
		return autor;
	}
}
