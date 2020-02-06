package com.br.socialapi.socialapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.socialapi.socialapi.domain.Autor;
import com.br.socialapi.socialapi.repository.AutoresRepository;
import com.br.socialapi.socialapi.service.exceptions.AutorExistenteException;

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
}
