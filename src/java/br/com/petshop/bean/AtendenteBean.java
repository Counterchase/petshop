package br.com.petshop.bean;

import br.com.petshop.model.Atendente;
import br.com.petshop.repository.Atendentes;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AtendenteBean {
    @Inject
    private Atendentes atendentes;
    private List<Atendente> listaDeAtendentes;
    
    public void todosOsAtendentes(){
        listaDeAtendentes = atendentes.pesquisarTodos();
    }
    
    public List<Atendente> getListaDeAtendentes(){
        return listaDeAtendentes;
    }
}
