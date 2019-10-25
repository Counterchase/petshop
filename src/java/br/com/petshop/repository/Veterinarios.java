package br.com.petshop.repository;

import br.com.petshop.model.Veterinario;
import br.com.petshop.model.Veterinario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Veterinarios implements Serializable {

    //Responsável por gerencial o ciclo de vida das entidades
    @Inject
    private EntityManager em;
    

    //Construtor
    public Veterinarios() {
    }

    //Construtor recebe como parametros um EntityManager
    public Veterinarios(EntityManager em) {
        this.em = em;
    }

    //Localizar Veterinario pelo ID
    public Veterinario porID(Integer id) {
        return em.find(Veterinario.class, id);
    }

    public List<Veterinario> pesquisarPorNome(String nome) {
        TypedQuery<Veterinario> query = em.createQuery("from veterinario where nome like :nome", Veterinario.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    public List<Veterinario> pesquisarTodos() {
        return em.createQuery("from veterinario", Veterinario.class).getResultList();
    }

    //Salvar ou Alterar um Veterinario
    public Veterinario salvar(Veterinario veterinario) {
        return em.merge(veterinario);
    }

    public void excluir(Veterinario veterinario) {
        veterinario = porID(veterinario.getId());
        em.remove(veterinario);
    }

}
