package br.com.java8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.java8.model.Pessoa;

public class TestLambdaComSort {

    public static void main(String[] args) {
	
	List<Pessoa> pessoas = Arrays.asList(new Pessoa("jardriel", 22),new Pessoa("bbmae", 37),new Pessoa("aapai",42));
	
	
	Consumer<Pessoa> imprimeMens = (u -> System.out.println(u.getNome()));
	
	Consumer<Pessoa> mostraMens = u-> System.out.println("imprimir mensagem antes");
	
	pessoas.forEach(mostraMens.andThen(imprimeMens));
	
	pessoas.sort((a , b )->a.getNome().compareTo(b.getNome()));
	
	pessoas.forEach(a->System.out.println(a.getNome()));
	
	pessoas.sort(Comparator.comparing(Pessoa::getNome));
	
	pessoas.forEach(a->System.out.println(a.getNome()));
	 

    }

}
