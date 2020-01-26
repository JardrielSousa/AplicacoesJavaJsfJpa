package br.com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.entidades.Cliente;

public class AtualizarObjeto {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycon");
		EntityManager em = emf.createEntityManager();
		Cliente cliente =  em.find(Cliente.class, 1L);
		em.getTransaction().begin();
		cliente.setNome("teste 111");
		em.getTransaction().commit();
		em.close();
		System.out.println("Objeto atualizado com sucesso!!");
		System.out.println(cliente.getNome());

	}

}
