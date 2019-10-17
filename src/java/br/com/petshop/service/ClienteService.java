package br.com.petshop.service;

import br.com.petshop.model.Cliente;
import br.com.petshop.repository.Clientes;
import br.com.petshop.util.Transacional;
import javax.inject.Inject;

public class ClienteService {
    @Inject
    private Clientes clientes;
    
    @Transacional
    public void salvar(Cliente cliente){
        clientes.salvar(cliente);
    }
    
    @Transacional
    public void excluir(Cliente cliente){
        clientes.excluir(cliente);
    }
    
}
