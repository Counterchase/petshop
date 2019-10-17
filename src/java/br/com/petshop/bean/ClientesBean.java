package br.com.petshop.bean;

import br.com.petshop.model.Cliente;
import br.com.petshop.repository.Clientes;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ClientesBean {
    @Inject
    private Clientes clientes;
    private List<Cliente> listaDeClientes;
    
    public void todosOsClientes(){
        listaDeClientes = clientes.pesquisarTodos();
    }
    
    public List<Cliente> getListaDeClientes(){
        return listaDeClientes;
    }
}
