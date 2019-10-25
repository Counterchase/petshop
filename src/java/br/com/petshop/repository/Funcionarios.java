package br.com.petshop.repository;

import br.com.petshop.model.Funcionario;
import br.com.petshop.model.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Dependent
public class Funcionarios implements Serializable {

    //Responsável por gerencial o ciclo de vida das entidades
    @Inject
    private EntityManager em;
    

    //Construtor
    public Funcionarios() {
    }

    //Construtor recebe como parametros um EntityManager
    public Funcionarios(EntityManager em) {
        this.em = em;
    }

    //Localizar Funcionario pelo ID
    public Funcionario porID(Integer id) {
        return em.find(Funcionario.class, id);
    }

    public List<Funcionario> pesquisarPorNome(String nome) {
        TypedQuery<Funcionario> query = em.createQuery("from funcionario where nome like :nome", Funcionario.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    public List<Funcionario> pesquisarTodos() {
        return em.createQuery("from funcionario", Funcionario.class).getResultList();
    }

    //Salvar ou Alterar um Funcionario
    public Funcionario salvar(Funcionario funcionario) {
        return em.merge(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        funcionario = porID(funcionario.getId());
        em.remove(funcionario);
    }

}
