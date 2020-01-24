package br.com.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.java8.model.Pessoa;

public class TestStream {

    public static void main(String[] args) {
	List<Pessoa> pessoas =
		Arrays.asList(new Pessoa("amor", 18),
			new Pessoa("jardriel",22),
			new Pessoa("sandra", 37),
			new Pessoa("jardel",42));
	System.out.println("===================================================================");
	System.out.println("MAIS QUE 20 ANOS");
	System.out.println("===================================================================");
	pessoas.stream().filter(a->a.getIdade()>20).forEach(a->System.out.println(a.getNome()));
	System.out.println("===================================================================");
	System.out.println("MAIS QUE 30 ANOS");
	System.out.println("===================================================================");
	pessoas.stream()
	.filter(idade->idade.getIdade()>30)
	.collect(Collectors.toList())
	.forEach(a->System.out.println(a.getNome()));
	
	System.out.println("===================================================================");
	System.out.println("MAIS QUE 20 ANOS ORDENADO POR NOME , ");
	System.out.println("===================================================================");
	
	List<Pessoa> inters = Arrays.asList(new Pessoa("teste", 50),new Pessoa("a", 10),new Pessoa("zz", 30),new Pessoa("teste",20),new Pessoa("a", 1));
	inters.stream().filter(i->i.getIdade()>20).collect(Collectors.toList());
	inters.sort(Comparator.comparing(Pessoa::getNome).thenComparing(Pessoa::getIdade));
	inters.forEach(a->System.out.println(a.getNome()+" "+a.getIdade()));
	
	OptionalDouble idadeMedia = (OptionalDouble) pessoas.stream().mapToInt(Pessoa::getIdade).average();
	System.out.println("idade media:"+idadeMedia.getAsDouble());

    }

}
