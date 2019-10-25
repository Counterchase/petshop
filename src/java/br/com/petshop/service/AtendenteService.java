package br.com.petshop.service;

import br.com.petshop.model.Atendente;
import br.com.petshop.repository.Atendentes;
import br.com.petshop.util.Transacional;
import javax.inject.Inject;

public class AtendenteService {
    @Inject
    private Atendentes atendentes;
    
    @Transacional
    public void salvar(Atendente atendente){
        atendentes.salvar(atendente);
    }
    
    @Transacional
    public void excluir(Atendente atendente){
        atendentes.excluir(atendente);
    }
    
}
