package br.com.petshop.repository;

import br.com.petshop.model.ServicoAgenda;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ServicoAgendas implements Serializable{
    @Inject
    private EntityManager em;

    public ServicoAgendas() {
    }

    public ServicoAgendas(EntityManager em) {
        this.em = em;
    }
    
    public List<ServicoAgenda> pesquisarTodos(){
        return em.createQuery("from ServicoAgenda", ServicoAgenda.class).getResultList();
    }
    
    public List<ServicoAgenda> pesquisarValoresGrafico(){
        String jpql = "select new br.com.petshop.model.ServicoAgenda(servico, sum(valor) as valor) from ServicoAgenda group by servico";
        TypedQuery<ServicoAgenda> query = em.createQuery(jpql, ServicoAgenda.class);
        return query.getResultList();
    }
}
