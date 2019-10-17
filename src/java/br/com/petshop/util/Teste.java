package br.com.petshop.util;

import br.com.petshop.model.Cliente;
import br.com.petshop.repository.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("frameworksCDI");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Clientes clientes = new Clientes(em);
        Cliente c = new Cliente();
        c.setNome("joao");
        c.setCPF("04512092145");
        clientes.salvar(c);
        List<Cliente> listaDeClientes = clientes.pesquisarTodos();
        System.out.println(listaDeClientes);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
