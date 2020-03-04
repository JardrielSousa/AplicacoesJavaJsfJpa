package com.br.socialbooksClient.aplicacao;

import java.util.Date;
import java.util.List;

import com.br.socialbooksClient.LivrosClient;
import com.br.socialbooksClient.domain.Livro;

public class Aplicacao {
	public static void main(String[]args) {
		LivrosClient cliente = new LivrosClient();
		List<Livro> listaLivros = cliente.listar();
		for(Livro livro : listaLivros) {
			System.out.println("livro:"+livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("testando");
		livro.setPublicacao(new Date());
		livro.setResumo("aaaaaaaaaaaa");
		livro.setEditora("bbbb");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("Uri do livro salvo"+localizacao);
		
		
	}
}
