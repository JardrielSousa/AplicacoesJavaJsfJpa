package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.entidades.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycon");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("jardriel");
		cliente.setSexo("M");
		cliente.setIdade(21);
		cliente.setProfissao("dev");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		System.out.println("salvo com sucesso!!");
		em.close();
		

	}

}
