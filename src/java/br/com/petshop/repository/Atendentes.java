package br.com.petshop.repository;

import br.com.petshop.model.Atendente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Atendentes implements Serializable {

    //Responsável por gerencial o ciclo de vida das entidades
    @Inject
    private EntityManager em;
    

    //Construtor
    public Atendentes() {
    }

    //Construtor recebe como parametros um EntityManager
    public Atendentes(EntityManager em) {
        this.em = em;
    }

    //Localizar Atendente pelo ID
    public Atendente porID(Integer id) {
        return em.find(Atendente.class, id);
    }

    public List<Atendente> pesquisarPorNome(String nome) {
        TypedQuery<Atendente> query = em.createQuery("from atendente where nome like :nome", Atendente.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    public List<Atendente> pesquisarTodos() {
        return em.createQuery("from atendente", Atendente.class).getResultList();
    }

    //Salvar ou Alterar um Atendente
    public Atendente salvar(Atendente atendente) {
        return em.merge(atendente);
    }

    public void excluir(Atendente atendente) {
        atendente = porID(atendente.getId());
        em.remove(atendente);
    }

}
