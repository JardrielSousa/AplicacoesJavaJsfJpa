package br.com.java8.conteudo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.java8.model.Pessoa;

public class Lambda {

    public static void main(String[] args) {
	List<Pessoa> list = Arrays.asList(new Pessoa("teste",1),new Pessoa("jardriel",22),new Pessoa("mae",37));
	list.stream().forEach(a->{	
	    System.out.println("Nome: "+a.getNome() +" idade " + a.getIdade());
	});
	
	IntStream todasAsIdades = list.stream().mapToInt(p->p.getIdade());
	todasAsIdades.forEach(a->System.out.println("nome:"+a));
	
	OptionalInt maiorIdade = list.stream().mapToInt(p->p.getIdade()).max();
	OptionalInt menorIdade = list.stream().mapToInt(p->p.getIdade()).min();
	System.out.println("Maior idade: "+maiorIdade.getAsInt());
	System.out.println("Menor idade: "+menorIdade.getAsInt());
    }

}
