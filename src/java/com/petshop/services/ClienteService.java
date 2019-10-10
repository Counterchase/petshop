
package com.petshop.services;

import com.petshop.model.Cliente;
import com.petshop.repository.Clientes;
import com.petshop.util.Transacional;
import javax.inject.Inject;

public class ClienteService {
    @Inject
    private Clientes clientes;
    @Transacional
    public void salvar(Cliente cliente){
        clientes.salvar(cliente);
    }
    @Transacional
    public void excluir (Cliente cliente){
        clientes.excluir(cliente);
    }
}
