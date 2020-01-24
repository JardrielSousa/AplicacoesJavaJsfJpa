package com.br.socialapi.socialapi.resources;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.socialapi.socialapi.domain.Livro;
import com.br.socialapi.socialapi.repository.LivroRepository;
import com.br.socialapi.socialapi.service.LivrosService;
import com.br.socialapi.socialapi.service.exceptions.LivroNaoEncontradoExceptions;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {

	@Autowired
	private LivrosService livroService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.listar()) ;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livroService.salvar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Livro livro = null;
		try {
			livroService.buscar(id);
		} catch (LivroNaoEncontradoExceptions e) {
			return ResponseEntity.notFound().build();
		}			
		return ResponseEntity.status(HttpStatus.OK).body(livro) ;
	}
	@RequestMapping(value = "/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		try {
			livroService.deletar(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build(); 
	}
	@RequestMapping(value = "/{id}" ,method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Livro livro,@PathVariable("id") Long id) {
		livro.setId(id);
		try {
			livroService.atualizar(livro);
		} catch (LivroNaoEncontradoExceptions e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}
