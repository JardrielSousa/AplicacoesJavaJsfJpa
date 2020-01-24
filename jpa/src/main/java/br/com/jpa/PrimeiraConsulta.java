package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.entidades.Cliente;

public class PrimeiraConsulta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycon");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 5L);
		
		if(cliente != null) {
			System.out.println("nome:" + cliente.getNome());
		}else {
			System.out.println("cliente nao encontrado");
		}
		

	}

}
