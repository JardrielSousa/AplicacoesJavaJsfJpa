package com.br.socialapi.socialapi.resources;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.socialapi.socialapi.domain.Comentario;
import com.br.socialapi.socialapi.domain.Livro;
import com.br.socialapi.socialapi.service.LivrosService;
import com.br.socialapi.socialapi.service.exceptions.LivroNaoEncontradoExceptions;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {

	@Autowired
	private LivrosService livroService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Livro> livros =  livroService.listar();
		if(livros.isEmpty()) {
			throw new LivroNaoEncontradoExceptions("Não temos livros Cadastrados !!!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(livros) ;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Livro livro) {
		livro = livroService.salvar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Livro livro = null;
		CacheControl cachecontrol = CacheControl.maxAge(20, TimeUnit.SECONDS);
		try {
			livroService.buscar(id);
		} catch (LivroNaoEncontradoExceptions e) {
			return ResponseEntity.notFound().build();
		}			
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cachecontrol).body(livro) ;
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
	@RequestMapping(value = "/{id}/comentarios",method=RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long livroId , @RequestBody Comentario comentario) {
		livroService.salvarComentario(livroId , comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/comentarios",method=RequestMethod.GET)
	public ResponseEntity<List<Comentario>> listarComentario(@PathVariable("id") Long livroId) {
		List<Comentario> comentarios = livroService.listarComentario(livroId);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}
