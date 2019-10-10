package com.petshop.repository;

import com.petshop.model.ServicoAgenda;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ServicoAgendas implements Serializable {

    @Inject
    private EntityManager em;

    public ServicoAgendas() {
    }

    public ServicoAgendas(EntityManager em) {
        this.em = em;
    }

    public List<ServicoAgenda> pesquisarTodos() {
        TypedQuery<ServicoAgenda> query = em.createQuery("from ServicoAgenda", ServicoAgenda.class);

        return query.getResultList();
    }
    
    
    public List<ServicoAgenda> pesquisarValoresGrafico() {
        String instance = "new com.petshop.model.ServicoAgenda(servico, sum(valor) as valor)";
        String jpql = "SELECT "+ instance +" FROM ServicoAgenda group by servico";
        TypedQuery<ServicoAgenda> query = em.createQuery(jpql, ServicoAgenda.class);

        return query.getResultList();
    }
}
