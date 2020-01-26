package br.com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.entidades.Cliente;

public class ConsultaJpql {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycon");
		EntityManager em = emf.createEntityManager();

		List<Cliente> clientes = em.createQuery("from Cliente",Cliente.class).getResultList();
		clientes.forEach(i-> 
			System.out.println("Id:" + i.getId() + "|" + "nome:"+i.getNome() + 
					" | " + "idade:" + i.getIdade() + 
					" | " + "Profissao:" + i.getProfissao()));
	}

}
