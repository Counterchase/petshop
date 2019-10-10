package com.petshop.bean;

import com.petshop.model.Cliente;
import com.petshop.repository.Clientes;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
