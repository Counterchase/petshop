package br.com.petshop.bean;

import br.com.petshop.model.Veterinario;
import br.com.petshop.repository.Veterinarios;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class VeterinariosBean {
    @Inject
    private Veterinarios veterinarios;
    private List<Veterinario> listaDeVeterinarios;
    
    public void todosOsVeterinarios(){
        listaDeVeterinarios = veterinarios.pesquisarTodos();
    }
    
    public List<Veterinario> getListaDeVeterinarios(){
        return listaDeVeterinarios;
    }
}
