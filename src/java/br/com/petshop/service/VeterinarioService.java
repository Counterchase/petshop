package br.com.petshop.service;

import br.com.petshop.model.Veterinario;
import br.com.petshop.repository.Veterinarios;
import br.com.petshop.util.Transacional;
import javax.inject.Inject;

public class VeterinarioService {
    @Inject
    private Veterinarios veterinarios;
    
    @Transacional
    public void salvar(Veterinario veterinario){
        veterinarios.salvar(veterinario);
    }
    
    @Transacional
    public void excluir(Veterinario veterinario){
        veterinarios.excluir(veterinario);
    }
    
}
