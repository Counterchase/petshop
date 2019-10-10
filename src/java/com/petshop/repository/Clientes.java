/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.repository;

import com.petshop.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Estudante
 */
@Dependent
public class Clientes implements Serializable{
    @Inject
    private EntityManager em;

    public Clientes() {
    }

    public Clientes(EntityManager em) {
        this.em = em;
    }
    
    public Cliente porId(Integer id){
        return em.find(Cliente.class, id);
    }
    
    public List<Cliente> pesquisarPorNome(String nome){
        TypedQuery<Cliente> query = em.createQuery("from Cliente where nome like :nome", Cliente.class);
        query.setParameter("nome", nome+"%");
        return query.getResultList();
    }
    public List<Cliente> pesquisarTodos(){
      return em.createQuery("from Cliente", Cliente.class).getResultList();
    }
    public Cliente salvar(Cliente cliente){
        return em.merge(cliente);
    }
    public void excluir (Cliente cliente){
        cliente = porId(cliente.getId());
        em.remove(cliente);
    }

}
