package com.br.socialbooksClient;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.br.socialbooksClient.domain.Livro;

public class LivrosClient {
	RestTemplate restTemplate = new RestTemplate();
	public List<Livro> listar(){
		RequestEntity<Void> request = RequestEntity.get(
				URI.create("http://localhost:8080/livros/")).
				header("Authorization", "Basic amFyZHJpZWw6MTIzNA==").build();
		
		ResponseEntity<Livro[]> response = restTemplate.exchange(request,Livro[].class);
		return Arrays.asList(response.getBody());
		
	}
	public String salvar(Livro livro){
		RequestEntity<Livro> request = RequestEntity.post(
				URI.create("http://localhost:8080/livros/")).
				header("Authorization", "Basic amFyZHJpZWw6MTIzNA==").body(livro);
		
		ResponseEntity<Void> response = restTemplate.exchange(request,Void.class);
		return response.getHeaders().getLocation().toString();
		
	}
}
