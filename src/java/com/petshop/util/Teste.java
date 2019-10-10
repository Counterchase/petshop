
package com.petshop.util;

import com.petshop.model.Cliente;
import com.petshop.repository.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Clientes clientes = new Clientes(em);
        Cliente c = new Cliente();
        c.setNome("jooa");
        c.setCPF("04512092145");
        clientes.salvar(c);
        List<Cliente> listaDeClientes = clientes.pesquisarTodos();
        System.out.println(listaDeClientes);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
