package br.com.petshop.repository;

import br.com.petshop.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Clientes implements Serializable {

    //Responsável por gerencial o ciclo de vida das entidades
    @Inject
    private EntityManager em;
    

    //Construtor
    public Clientes() {
    }

    //Construtor recebe como parametros um EntityManager
    public Clientes(EntityManager em) {
        this.em = em;
    }

    //Localizar cliente pelo ID
    public Cliente porID(Integer id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> pesquisarPorNome(String nome) {
        TypedQuery<Cliente> query = em.createQuery("from Cliente where nome like :nome", Cliente.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    public List<Cliente> pesquisarTodos() {
        return em.createQuery("from Cliente", Cliente.class).getResultList();
    }

    //Salvar ou Alterar um Cliente
    public Cliente salvar(Cliente cliente) {
        return em.merge(cliente);
    }

    public void excluir(Cliente cliente) {
        cliente = porID(cliente.getId());
        em.remove(cliente);
    }

}
